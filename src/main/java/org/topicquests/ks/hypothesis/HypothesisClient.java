/**
 * 
 */
package org.topicquests.ks.hypothesis;
import java.io.*;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.topicquests.support.ResultPojo;
import org.topicquests.support.api.IResult;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;

/**
 * @author jackpark
 * @see https://hc.apache.org/httpcomponents-client-ga/quickstart.html
 */
public class HypothesisClient {
	private HypothesisHarvesterEnvironment environment;
	private CloseableHttpClient client;
	private final String 
		BASE_URL,
		TOKEN,
		GROUP_ID,
		FINAL_URL;
	
	/**
	 * @param env
	 */
	public HypothesisClient(HypothesisHarvesterEnvironment env) {
		environment = env;
		client = HttpClients.createDefault();
		BASE_URL = environment.getStringProperty("BaseURL");
		TOKEN = environment.getStringProperty("DeveloperToken");
		GROUP_ID = environment.getStringProperty("GroupId");
		FINAL_URL = BASE_URL+"?group="+GROUP_ID;
		System.out.println(FINAL_URL);
	}
	
	/**
	 * Bulk loader for the given GROUP_ID
	 * @return {@link JSONObject}
	 */
	public IResult loadAnnotations() {
		IResult result = new ResultPojo();
		HttpGet httpGet = new HttpGet(FINAL_URL);
		httpGet.addHeader("Accept", "application/json");
		httpGet.addHeader("Authorization", "Bearer "+TOKEN);
		CloseableHttpResponse response1 = null;
		try {
			response1 = client.execute(httpGet);
			// System.out.println(response1.getStatusLine());
			HttpEntity entity1 = response1.getEntity();
			if (entity1 != null) {
				System.out.println("ContentSize "+entity1.getContentLength());
				InputStream is = entity1.getContent();
				JSONParser p = new JSONParser(JSONParser.MODE_JSON_SIMPLE);
				JSONObject obj = (JSONObject)p.parse(is);
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
	 * Load some annotations
	 * @param start
	 * @param count
	 * @return {@link JSONObject}
	 */
	public IResult loadSomeAnnotations(int start, int count) {
		IResult result = new ResultPojo();
		//TODO
		return result;
	}

}
