/**
 * 
 */
package org.topicquests.ks.hypothesis;

import java.util.*;

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
	private PivotModel2 pivotModel;
	
	/**
	 * 
	 */
	public AnalyzerListener(HypothesisHarvesterEnvironment env) {
		environment = env;
		pivotModel = environment.getPivotModel();
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
		pivotModel.processDocument(annotation);
		anas.add(annotation);
		environment.logDebug("Annotations "+anas.size());
	}


}
