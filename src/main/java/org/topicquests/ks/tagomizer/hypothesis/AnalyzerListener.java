/**
 * 
 */
package org.topicquests.ks.tagomizer.hypothesis;

import java.util.*;

import org.topicquests.ks.tagomizer.TagomizerClientEnvironment;
import org.topicquests.ks.tagomizer.api.IAnalyzerListener;
import org.topicquests.support.api.IResult;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

/**
 * @author jackpark
 *
 */
public class AnalyzerListener implements IAnalyzerListener {
	private TagomizerClientEnvironment environment;
	private JSONArray anas;
	private PivotModel pivotModel;
	
	/**
	 * 
	 */
	public AnalyzerListener(TagomizerClientEnvironment env) {
		environment = env;
		pivotModel = environment.getPivotModel();
		anas = new JSONArray();
	}

	public JSONArray getData() {
		return anas;
	}
	
	/* (non-Javadoc)
	 * @see org.topicquests.ks.tagomizer.api.IAnalyzerListener#acceptAnalyzedAnnotation(net.minidev.json.JSONObject)
	 */
	@Override
	public void acceptAnalyzedAnnotation(JSONObject annotation) {
		pivotModel.processDocument(annotation);
		anas.add(annotation);
		environment.acceptAnalyzedAnnotation(annotation);
		environment.logDebug("Annotations "+anas.size());
	}


}
