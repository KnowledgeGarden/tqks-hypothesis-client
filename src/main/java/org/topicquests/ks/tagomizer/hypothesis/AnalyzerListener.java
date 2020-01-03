/**
 * 
 */
package org.topicquests.ks.tagomizer.hypothesis;

import java.util.*;

import org.topicquests.ks.tagomizer.TagomizerClientEnvironment;
import org.topicquests.ks.tagomizer.api.IAnalyzerListener;
import org.topicquests.os.asr.JSONDocumentObject;
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
		environment.logDebug("ANA\n"+annotation);
		environment.acceptAnalyzedAnnotation(annotationToDocument(annotation));
		//environment.logDebug("Annotations "+anas.size());
	}

	JSONObject annotationToDocument(JSONObject annotation) {
		String text = annotation.getAsString("text");
		String id = annotation.getAsString("id");
		String annot = annotation.getAsString("annotation");
		String uid = annotation.getAsString("user");
		List<String> tags = (List<String>)annotation.get("tags");
		String dateString = annotation.getAsString("created");
		String url = annotation.getAsString("uri");
		String title = annotation.getAsString("title");
		if (title == null || title.equals(""))
			title = "no title available";
		JSONObject result = null;
		JSONDocumentObject doc = new JSONDocumentObject(uid);
		doc.setDocumentId(id);
		doc.setDocumentTitle(title);
		if (tags != null && !tags.isEmpty())
			doc.setTagList(tags);
		if (text != null && !text.equals(""))
			doc.addParagraph(text, "en");
		if (annot != null && !annot.equals(""))
			doc.addParagraph(annot, "en");
		doc.setURL(url);
		doc.setDateString(dateString);
		result = doc.getData();
		
		return result;
	}
}
