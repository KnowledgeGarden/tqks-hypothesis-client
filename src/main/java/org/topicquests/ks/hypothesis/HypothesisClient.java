/**
 * 
 */
package org.topicquests.ks.hypothesis;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.topicquests.support.ResultPojo;
import org.topicquests.support.api.IResult;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;

/**
 * @author jackpark
 * @see https://hc.apache.org/httpcomponents-client-ga/quickstart.html
 */
public class HypothesisClient {
	private HypothesisHarvesterEnvironment environment;
	private CloseableHttpClient client;
	private JSONProcessor processor;
	private Object waitObject = new Object();
	private long cursor;
	private final List<String> groups;
	private final String 
		BASE_URL, 	// set in /config/harvester-props.xml
		TOKEN,		// ditto
		GROUP_ID,	// ditto
		FINAL_URL;	// calculated here
	
	/**
	 * @param env
	 */
	public HypothesisClient(HypothesisHarvesterEnvironment env) {
		environment = env;
		client = HttpClients.createDefault();
		BASE_URL = environment.getStringProperty("BaseURL");
		TOKEN = environment.getStringProperty("DeveloperToken");
		GROUP_ID = environment.getStringProperty("GroupId");
		cursor = environment.getCursor(GROUP_ID);
		// create the final URL
		FINAL_URL = BASE_URL+"?group="+GROUP_ID;
		groups = new ArrayList<String>();
		List<List<String>> gl = (List<List<String>>)environment.getProperties().get("Groups");
		Iterator<List<String>> itr = gl.iterator();
		while (itr.hasNext())
			groups.add(itr.next().get(1));
		System.out.println(FINAL_URL);
		environment.logDebug("HypothesisClient "+groups);
	}
	
	public void setProcessor(JSONProcessor p) {
		this.processor = p;
	}
	
	/**
	 * Bulk loader for the given GROUP_ID
	 * @return {@link JSONObject}
	 */
	public IResult loadAnnotations() {
		IResult result = new ResultPojo();
		// create a GET command
		HttpGet httpGet = new HttpGet(FINAL_URL);
		httpGet.addHeader("Accept", "application/json");
		// authenticate
		httpGet.addHeader("Authorization", "Bearer "+TOKEN);
		CloseableHttpResponse response1 = null;
		try {
			// execute the get
			response1 = client.execute(httpGet);
			// System.out.println(response1.getStatusLine());
			HttpEntity entity1 = response1.getEntity();
			if (entity1 != null) {
				//Turn content into a JSONObject
				//System.out.println("ContentSize "+entity1.getContentLength());
				InputStream is = entity1.getContent();
				JSONParser p = new JSONParser(JSONParser.MODE_JSON_SIMPLE);
				JSONObject obj = (JSONObject)p.parse(is);
				//return the JSONObject for late processing
				result.setResultObject(obj);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			result.addErrorString(e.getMessage());
			environment.logError(e.getMessage(), e);
		} finally {
			if (response1 != null) {
				try {
					response1.close();
				} catch (Exception x) {
					x.printStackTrace();
					result.addErrorString(x.getMessage());
					environment.logError(x.getMessage(), x);
				}
				response1 = null;
			}
		}
		return result;
	}
	
	/**
	 * Load some annotations based on <code>cursor</code>
	 * @link GroupId
	 * @return {@link JSONObject}
	 */
	public IResult loadSomeAnnotations(String GroupID) {
		cursor = environment.getCursor(GroupID);
		//wait a while
		synchronized(waitObject) {
			try {
				waitObject.wait(5000);
			} catch (Exception e) {}
		}
		final String MyURL = BASE_URL+"?group="+GroupID;
		IResult result = new ResultPojo();
		HttpGet httpGet = new HttpGet(MyURL+"&offset="+cursor);
		httpGet.addHeader("Accept", "application/json");
		// authenticate
		httpGet.addHeader("Authorization", "Bearer "+TOKEN);
		CloseableHttpResponse response1 = null;
		try {
			// execute the get
			response1 = client.execute(httpGet);
			// System.out.println(response1.getStatusLine());
			HttpEntity entity1 = response1.getEntity();
			if (entity1 != null) {
				//Turn content into a JSONObject
				System.out.println("ContentSize "+entity1.getContentLength());
				InputStream is = entity1.getContent();
				JSONParser p = new JSONParser(JSONParser.MODE_JSON_SIMPLE);
				JSONObject obj = (JSONObject)p.parse(is);
				//return the JSONObject for late processing
				result.setResultObject(obj);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			result.addErrorString(e.getMessage());
			environment.logError(e.getMessage(), e);
		} finally {
			if (response1 != null) {
				try {
					response1.close();
				} catch (Exception x) {
					x.printStackTrace();
					result.addErrorString(x.getMessage());
					environment.logError(x.getMessage(), x);
				}
				response1 = null;
			}
		}
		return result;
	}

	/**
	 * Harvest everything
	 * @return
	 */
	public IResult harvest() {
		IResult result = new ResultPojo();
		JSONArray ja = new JSONArray();
		result.setResultObject(ja);
		IResult r = null;
		JSONObject jo;
		Iterator<String>itr = groups.iterator();
		String gid;
		while (itr.hasNext()) {
			gid = itr.next();
			r = this.loadSomeAnnotations(gid);
			jo = (JSONObject)r.getResultObject();
			environment.logDebug("FIRSTLOAD "+gid+"\n"+jo);
			if (jo != null) {
				long limit = Long.parseLong(jo.getAsString("total"));
				while (jo != null && sanity(jo) && (environment.getCursor(gid) < limit)) {
					processor.processJSON(jo);
					r = this.loadSomeAnnotations(gid);
					jo = (JSONObject)r.getResultObject();
					if (jo != null && sanity(jo))
						ja.add(jo);
				}
				processor.loadingDone();
			}
		}
		environment.shutDown();
		return result;
	}
	
	boolean sanity(JSONObject jo) {
		String x = jo.getAsString("status");
		if (x != null && x.equals("failure"))
			return false;
		return true;
	}
}
