/**
 * 
 */
package org.topicquests.ks.tagomizer;

import java.util.List;

import org.topicquests.ks.tagomizer.api.IAnnotationDocument;

import net.minidev.json.JSONObject;

/**
 * @author jackpark
 *
 */
public class AnnotationDocument extends JSONObject 
		implements IAnnotationDocument {

	/**
	 * 
	 */
	public AnnotationDocument() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addText(String text, String language) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDocumentTitle(String title) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setGroupId(String grouopId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUserId(String userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDocumentURL(String url) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDocumentId(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDocumentDate(String dateString) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTag(String label, String tagId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<JSONObject> listText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDocumentTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDocumentURL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDocumentId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDocumentDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGroupId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUserId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JSONObject> listTags() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
