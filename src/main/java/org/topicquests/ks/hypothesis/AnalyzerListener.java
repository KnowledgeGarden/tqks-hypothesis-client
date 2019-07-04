/**
 * 
 */
package org.topicquests.ks.hypothesis;

import java.util.*;

import org.topicquests.es.api.IClient;
import org.topicquests.ks.hypothesis.api.IAnalyzerListener;
import org.topicquests.support.api.IResult;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

/**
 * @author jackpark
 *
 */
public class AnalyzerListener implements IAnalyzerListener {
	private HypothesisHarvesterEnvironment environment;
	private JSONArray anas;
	private IClient esClient;
	private final String 
		INDEX = "annotations",
		META = INDEX+"_meta";
	/**
	 * 
	 */
	public AnalyzerListener(HypothesisHarvesterEnvironment env) {
		environment = env;
		esClient = environment.getElasticSearchProvider().getProvider();
		anas = new JSONArray();
	}

	public JSONArray getData() {
		return anas;
	}
	/* (non-Javadoc)
	 * @see org.topicquests.ks.hypothesis.api.IAnalyzerListener#acceptAnalyzedAnnotation(net.minidev.json.JSONObject)
	 */
	@Override
	public void acceptAnalyzedAnnotation(JSONObject annotation) {
		esClient.put(annotation.getAsString("id"), INDEX, annotation);
		anas.add(annotation);
		environment.logDebug("Annotations "+anas.size());
	}

	@Override
	public void acceptMeta(Set<String> users, Set<String> resources, Set<String> tags) {
		IResult r = esClient.get("_meta", META);
		JSONObject jo = (JSONObject)r.getResultObject();
		List<String> l;
		if (jo != null) {
			l = (List<String>)jo.get("users");
			if (l != null && !l.isEmpty())
				users.addAll(l);
			l = (List<String>)jo.get("resources");
			if (l != null && !l.isEmpty())
				resources.addAll(l);
			l = (List<String>)jo.get("tags");
			if (l != null && !l.isEmpty())
				tags.addAll(l);
		}
		jo = new JSONObject();
		l = new ArrayList<String>();
		l.addAll(users);
		jo.put("users", l);
		l = new ArrayList<String>();
		l.addAll(resources);
		jo.put("resources", l);
		l = new ArrayList<String>();
		l.addAll(tags);
		jo.put("tags", l);
		esClient.put("_meta", META, jo);
	}

}
