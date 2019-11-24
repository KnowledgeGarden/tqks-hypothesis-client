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
		//take care of the document and annotations and text
		processDocument(annotation);
		// take care of the pivots
		pivotModel.processPivotData(
				annotation.getAsString("id"),
				annotation.getAsString("user"),
				annotation.getAsString("uri"),
				annotation.getAsString("title"),
				annotation.getAsString("group"),
				annotation.getAsString("updated"),
				(List<String>)annotation.get("tags"));
		anas.add(annotation);
		environment.logDebug("Annotations "+anas.size());
	}
	
	void processDocument(JSONObject document) {
		String id = document.getAsString("id");
		String groupId = document.getAsString("group");
		String uri = document.getAsString("uri");
		String title = document.getAsString("title");
		String annotation = document.getAsString("annotation");
		String text = document.getAsString("text");
		String created = document.getAsString("created");
		String user = document.getAsString("user");
		
	}

}
