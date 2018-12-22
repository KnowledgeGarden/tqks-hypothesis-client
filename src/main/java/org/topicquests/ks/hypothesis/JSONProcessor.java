/**
 * 
 */
package org.topicquests.ks.hypothesis;
import java.util.*;
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

	/**
	 * @param env
	 */
	public JSONProcessor(HypothesisHarvesterEnvironment env) {
		environment = env;
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
		if (list != null && !list.isEmpty()) {
			System.out.println("NumRows "+list.size()+" | "+jo.getAsString("total"));
			Iterator<Object> itr = list.iterator();
			//For testing only, just show the first element
			// See /tests/FirstProcessorTest.java
			JSONObject jx = (JSONObject)itr.next();
			//System.out.println("JX "+jx);
			//TODO
		}
		return result;
	}

}
