/**
 * 
 */
package org.topicquests.ks.hypothesis;

import java.util.*;
import org.topicquests.ks.hypothesis.api.IAnalyzerListener;

import net.minidev.json.JSONObject;

/**
 * @author jackpark
 *
 */
public class AnalyzerListener implements IAnalyzerListener {
	private HypothesisHarvesterEnvironment environment;
	private List<JSONObject>anas;
	/**
	 * 
	 */
	public AnalyzerListener(HypothesisHarvesterEnvironment env) {
		environment = env;
		anas = new ArrayList<JSONObject>();
	}

	/* (non-Javadoc)
	 * @see org.topicquests.ks.hypothesis.api.IAnalyzerListener#acceptAnalyzedAnnotation(net.minidev.json.JSONObject)
	 */
	@Override
	public void acceptAnalyzedAnnotation(JSONObject annotation) {
		anas.add(annotation);
		environment.logDebug("Annotations "+anas.size());
	}

}
