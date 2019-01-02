/**
 * 
 */
package org.topicquests.ks.hypothesis.api;

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
}
