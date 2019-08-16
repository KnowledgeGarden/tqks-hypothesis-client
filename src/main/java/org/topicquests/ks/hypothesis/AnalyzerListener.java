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
	private PivotModel2 pivotModel;
	private final String 
		INDEX = "annotations";
	/**
	 * 
	 */
	public AnalyzerListener(HypothesisHarvesterEnvironment env) {
		environment = env;
		pivotModel = environment.getPivotModel();
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
		pivotModel.processPivotData(
				annotation.getAsString("id"),
				annotation.getAsString("user"),
				annotation.getAsString("uri"),
				annotation.getAsString("title"),
				(List<String>)annotation.get("tags"));
		anas.add(annotation);
		environment.logDebug("Annotations "+anas.size());
	}

}
