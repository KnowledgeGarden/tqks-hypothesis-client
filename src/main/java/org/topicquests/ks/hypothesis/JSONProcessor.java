/**
 * 
 */
package org.topicquests.ks.hypothesis;
import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

import org.topicquests.support.ResultPojo;
import org.topicquests.support.api.IResult;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

/**
 * @author jackpark
 *
 */
public class JSONProcessor {
	private HypothesisHarvesterEnvironment environment;
	private Analyzer analyzer;
	private PrintWriter out;
	/**
	 * @param env
	 */
	public JSONProcessor(HypothesisHarvesterEnvironment env, Analyzer a) {
		environment = env;
		analyzer = a;
		//debugSetup();
	}
/**
 * A plan is to:
 * <ol><li>Make this into a Thread</li>
 * <li>Add a harvester which takes each annotation apart and
 *  processes it into tags, annotations, etc, then sends that to
 *  the topic map</li></ol>
 */
	
	/**
	 * Process the results of a fetch
	 * @param jo
	 * @return
	 */
	public IResult processJSON(JSONObject jo) {
		IResult result = new ResultPojo();
		JSONArray list = (JSONArray)jo.get("rows");
		JSONObject jx;
		long cursor = environment.getCursor();
		if (list != null && !list.isEmpty()) {
			System.out.println("NumRows "+list.size()+" | "+jo.getAsString("total"));
			Iterator<Object> itr = list.iterator();
			//For testing only, just show the first element
			// See /tests/FirstProcessorTest.java
			//JSONObject jx = (JSONObject)itr.next();
			//System.out.println("JX "+jx);
			while (itr.hasNext()) {
				jx = (JSONObject)itr.next();
				//this.saveJSON(jx);
				analyzer.addAnnotation(jx);
				cursor++;
			}
			environment.updateCursor(cursor);
			//debugEnd();
		}
		return result;
	}

	void debugSetup() {
		try {
			File f = new File("test/"+System.currentTimeMillis()+".json");
			FileOutputStream fos = new FileOutputStream(f, true);
			OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
			out = new PrintWriter(osw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	void saveJSON(JSONObject jo) {
		out.println(jo.toJSONString());
	}
	void debugEnd() {
		try {
			out.flush();
			out.close();
			out = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
