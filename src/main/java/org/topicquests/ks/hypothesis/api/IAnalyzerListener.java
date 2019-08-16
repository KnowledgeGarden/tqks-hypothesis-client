/**
 * 
 */
package org.topicquests.ks.hypothesis.api;

import java.util.Set;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

/**
 * @author jackpark
 *
 */
public interface IAnalyzerListener {

	/**
	 * An <code>annotation</code> is a container of all properties found
	 * in a harvested annotation.
	 * @param annotation
	 */
	void acceptAnalyzedAnnotation(JSONObject annotation);
	
	JSONArray getData();
}
