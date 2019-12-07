/**
 * 
 */
package org.topicquests.ks.tagomizer.api;

import java.util.List;

import net.minidev.json.JSONObject;

/**
 * @author jackpark
 *
 */
public interface IAnnotationDocument {
	
	void addText(String text, String language);
	void setDocumentTitle(String title);
	void setGroupId(String grouopId);
	void setUserId(String userId);
	void setDocumentURL(String url);
	void setDocumentId(String id);
	void setDocumentDate(String dateString);
	void addTag(String label, String tagId);
	
	List<JSONObject> listText();
	String getDocumentTitle();
	String getDocumentURL();
	String getDocumentId();
	String getDocumentDate();
	String getGroupId();
	String getUserId();
	List<JSONObject>  listTags();
	
}
