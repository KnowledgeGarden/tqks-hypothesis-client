/**
 * 
 */
package org.topicquests.ks.hypothesis;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.topicquests.ks.hypothesis.api.ISQL;
import org.topicquests.pg.PostgresConnectionFactory;
import org.topicquests.pg.api.IPostgresConnection;
import org.topicquests.support.ResultPojo;
import org.topicquests.support.api.IResult;

/**
 * @author jackpark
 * To work with newpivots.sql
 */
public class PivotModel2 {
	private HypothesisHarvesterEnvironment environment;
	private PostgresConnectionFactory provider;
	private Object [] emptyObject = new Object[0];
	private Object [] oneObject = new Object[1];

	/**
	 * 
	 */
	public PivotModel2(HypothesisHarvesterEnvironment env) {
		environment = env;
		provider = environment.getProvider();
	}
	
	/**
	 * Process all the pivot data for a given annotation
	 * @param id
	 * @param annotationId
	 * @param user
	 * @param resource
	 * @param title
	 * @param groupId
	 * @param created - date string
	 * @param tags can be <code>null</code> or empty
	 */
	public void processPivotData(String docId,
								 String userId,
								 String resource, //url
								 String title,
								 String groupId,
								 String created,
								 List<String>tags) {
		
		environment.logDebug("PM.processPivotData "+resource+" | "+userId+" | "+tags);
		IPostgresConnection conn = null;
		IResult r = new ResultPojo();
		boolean validTags = (tags != null && !tags.isEmpty());
		Iterator<String> itr;
		String theTag;
		try {
			 conn = provider.getConnection();
		     conn.setProxyRole(r);
		     // resource --document
		     insertDocument(conn, r, docId, resource, title, created, groupId, userId);
		     // user
		     insertUser(conn, r, userId, docId, groupId);
		     // group
		     insertGroup(conn, r, groupId, docId);
		     // tags
		     if (validTags) {
		    	 itr = tags.iterator();
		    	 while (itr.hasNext()) {
		    		theTag = itr.next();
		    		insertTag(conn, r, this.tagToId(theTag), theTag, groupId);
		    	 }
		     }
		     //pivots--references
		     //tq_tagomizer.reference
		     // wants id, docId from doc table, userid from user table
		     insertReference(conn, r, docId, userId);
		     //tq_tagomizer.tag_ref
		     // forloop on each tag
		     // wants tagid from tag table, id
		     itr = tags.iterator();
		     String tagid;
	    	 while (itr.hasNext()) {
	    		theTag = itr.next();
	    		tagid = tagToId(theTag);
	    		insertTagReference(conn, r, tagid, docId, groupId);
	    	 }
		     
		} catch (Exception e) {
			environment.logError(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			conn.closeConnection(r);
		}
	}

	String tagToId(String tagName) {
		String result = tagName.trim();
		result = result.replaceAll(" ", "_");
		result = result.replaceAll("!", "x");
		result = result.replaceAll("'", "t");
		result = result.replaceAll(",", "c");
		result = result.replaceAll("?", "q");
		result = result.toLowerCase();
		return result;
	}
	/*
	int getTagId(IPostgresConnection conn, IResult r, String tag) 
			throws Exception {
		int result = -1;
		String sql = ISQL.SELECT_TAG_ID_BY_NAME;
		Object [] obj = new Object[1];
		obj[0] = tag;
		conn.executeSelect(sql, r, obj);
		ResultSet rs = (ResultSet)r.getResultObject();
		if (rs != null && rs.next())
			result = rs.getInt("id");
		return result;
	}*/

	String getDocId(IPostgresConnection conn, IResult r, String url, String groupId) 
			throws Exception {
		String result = null;
		//TODO
		// MANY Documents from Different Groups can be for the same URL
		String sql = ISQL.SELECT_DOC_ID_BY_URL_GROUP;
		Object [] obj = new Object[2];
		obj[0] = url;
		obj[1] = groupId;
		conn.executeSelect(sql, r, obj);
		ResultSet rs = (ResultSet)r.getResultObject();
		if (rs != null && rs.next())
			result = rs.getString("document_id");
		return result;
	}

	/*int getUserId(IPostgresConnection conn, IResult r, String user) 
			throws Exception {
		int result = -1;
		String sql = "SELECT id FROM tq_tagomizer.huser where hyp_uid=?";
		Object [] obj = new Object[1];
		obj[0] = user;
		conn.executeSelect(sql, r, obj);
		ResultSet rs = (ResultSet)r.getResultObject();
		if (rs != null && rs.next())
			result = rs.getInt("id");
		return result;
	}*/
	
	void insertTagReference(IPostgresConnection conn, IResult r, String tagId, String docId, String groupId)
			throws Exception {
		String sql = ISQL.INSERT_TAG_REF;
		Object [] obj = new Object[3];
		obj[0] = tagId;
		obj[1] = docId;
		obj[2] = groupId;
		conn.beginTransaction(r);
		conn.executeSQL(sql, r, obj);
		conn.endTransaction(r);
	}

	void insertReference(IPostgresConnection conn, IResult r, String docId, String userId)
			throws Exception {
		String sql = ISQL.INSERT_REFERENCE;
		Object [] obj = new Object[2];
		obj[0] = docId;
		obj[1] = userId;
		conn.beginTransaction(r);
		conn.executeSQL(sql, r, obj);
		conn.endTransaction(r);
	}

	void insertDocument(IPostgresConnection conn, IResult r, String docId, String resource, 
				String title, String created, String groupId, String userId)
			throws Exception {
		String sql = ISQL.INSERT_DOCUMENT;
		Object [] obj = new Object[6];
		obj[0] = docId;
		obj[1] = resource;
		obj[2] = title;
		obj[3] = created;
		obj[4] = groupId;
		obj[5] = userId;
		conn.beginTransaction(r);
		conn.executeSQL(sql, r, obj);
		conn.endTransaction(r);
	}
	
	void insertUser(IPostgresConnection conn, IResult r, String userId, String docId, String groupId)
			throws Exception {
		String sql = ISQL.INSERT_USER;
		Object [] obj = new Object[3];
		obj[0] = userId;
		obj[1] = docId;
		obj[2] = groupId;
		conn.beginTransaction(r);
		conn.executeSQL(sql, r, obj);
		conn.endTransaction(r);
	}
	
	void insertTag(IPostgresConnection conn, IResult r, String tagId, String tag, String groupId)
			throws Exception {
		String sql = ISQL.INSERT_TAG;
		Object [] obj = new Object[3];
		obj[0] = tagId;
		obj[1] = tag;
		obj[2] = groupId;
		conn.beginTransaction(r);
		conn.executeSQL(sql, r, obj);
		conn.endTransaction(r);
	}
	
	void insertGroup(IPostgresConnection conn, IResult r, String groupId, String docId)
			throws Exception {
		String sql = ISQL.INSERT_GROUP;
		Object [] obj = new Object[2];
		obj[0] = groupId;
		obj[1] = docId;
		conn.beginTransaction(r);
		conn.executeSQL(sql, r, obj);
		conn.endTransaction(r);
	}

}
