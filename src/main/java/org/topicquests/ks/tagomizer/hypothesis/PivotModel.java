/**
 * 
 */
package org.topicquests.ks.tagomizer.hypothesis;

import java.util.Iterator;
import java.util.List;

import org.topicquests.ks.identity.TagIdentifier;
import org.topicquests.ks.tagomizer.TagomizerClientEnvironment;
import org.topicquests.ks.tagomizer.api.ISQL;
import org.topicquests.pg.PostgresConnectionFactory;
import org.topicquests.pg.api.IPostgresConnection;
import org.topicquests.support.ResultPojo;
import org.topicquests.support.api.IResult;

import net.minidev.json.JSONObject;

/**
 * @author jackpark
 * To work with hypothesis.sql
 */
public class PivotModel {
	private TagomizerClientEnvironment environment;
	private PostgresConnectionFactory provider;

	/**
	 * @param env
	 */
	public PivotModel(TagomizerClientEnvironment env) {
		environment = env;
		provider = environment.getProvider();
		initializeGroupsFromConfig();
	}
	
	void initializeGroupsFromConfig() {
		List<List<String>> gl = (List<List<String>>)environment.getProperties().get("Groups");
		Iterator<List<String>> itr = gl.iterator();
		String name, gid;
		List<String>l;
		IPostgresConnection conn = null;
		IResult r = new ResultPojo();
		try {
			 conn = provider.getConnection();
		     conn.setProxyRole(r);
			while (itr.hasNext()) {
				l = itr.next();
				name = l.get(0);
				gid = l.get(1);
				insertGroup(conn, r, gid, name);
			}
		} catch (Exception e) {
			environment.logError(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			conn.closeConnection(r);
		}

	}
	

	/**
	 * <p>Persist the document and its pivots, then
	 *  persist the text component of annotations</p>
	 * @param document
	 */
	public void processDocument(JSONObject document) {
		environment.logDebug("ProcessDocument\n"+document);
		//Pivots first to establish the document table
		String id = document.getAsString("id");
		processPivotData(
				id,
				document.getAsString("user"),
				document.getAsString("uri"),
				document.getAsString("title"),
				document.getAsString("group"),
				document.getAsString("created"),
				(List<String>)document.get("tags"));
		//now the annotations
		String annotation = document.getAsString("annotation");
		String text = document.getAsString("text");
		environment.logDebug("PM.processDocument "+id+"\n"+annotation+"\n"+text);
		IPostgresConnection conn = null;
		IResult r = new ResultPojo();
		try {
			 conn = provider.getConnection();
		     conn.setProxyRole(r);
		     if (annotation != null && !annotation.equals(""))
		    	 insertAnnotation(conn, r, id, annotation);
		     //both annotation and text go into one table
		     if (text != null && !text.equals(""))
		    	 insertAnnotation(conn, r, id, text);
		} catch (Exception e) {
			environment.logError(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			conn.closeConnection(r);
		}
	}

	/**
	 * Process all the pivot data for a given document
	 * @param id
	 * @param annotationId
	 * @param user
	 * @param resource
	 * @param titl
	 * @param groupId
	 * @param created - date string
	 * @param tags can be <code>null</code> or empty
	 */
	void processPivotData(String docId,
								 String userId,
								 String resource, //url
								 String titl,
								 String groupId,
								 String created,
								 List<String>tags) {
		String title = titl;
		if (title.equals(""))
			title = "missing title";
		environment.logDebug("PM.processPivotData "+resource+" | "+userId+" | "+tags);
		IPostgresConnection conn = null;
		IResult r = new ResultPojo();
		boolean validTags = (tags != null && !tags.isEmpty());
		Iterator<String> itr;
		String theTag;
		try {
			 conn = provider.getConnection();
		     conn.setProxyRole(r);
		     insertUser(conn, r, userId);
		     //insertGroup(conn, r, groupId);
		     insertDocument(conn, r, docId, resource, title, created, userId);
		     String tagid;
		     if (validTags) {
		    	 itr = tags.iterator();
		    	 while (itr.hasNext()) {
		    		theTag = itr.next();
		    		tagid = TagIdentifier.tagToId(theTag);
		    		insertTag(conn, r, tagid, theTag, groupId);
		    		insertDocumentTagReference(conn, r, tagid, docId, groupId);
		    		insertUserTagReference(conn, r, tagid, userId);
		    		insertGroupUserReference(conn, r, groupId, userId);
		    	 }
		     }
		     
		} catch (Exception e) {
			environment.logError(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			conn.closeConnection(r);
		}
	}

	void insertUser(IPostgresConnection conn, IResult r, String userId)
			throws Exception {
		String sql = ISQL.INSERT_USER;
		environment.logDebug("SQL "+sql+"\n"+userId);
		Object [] obj = new Object[1];
		obj[0] = userId;
		conn.beginTransaction(r);
		conn.executeSQL(sql, r, obj);
		conn.endTransaction(r);
	}
	
	void insertGroup(IPostgresConnection conn, IResult r, String groupId, String groupName)
			throws Exception {
		String sql = ISQL.INSERT_GROUP;
		environment.logDebug("SQL "+sql+"\n"+groupId);
		Object [] obj = new Object[2];
		obj[0] = groupId;
		obj[1] = groupName;
		conn.beginTransaction(r);
		conn.executeSQL(sql, r, obj);
		conn.endTransaction(r);

	}

	void insertDocumentTagReference(IPostgresConnection conn, IResult r, String tagId, String docId, String groupId)
			throws Exception {
		String sql = ISQL.INSERT_DOC_TAG_REF;
		environment.logDebug("SQL "+sql+"\n"+tagId+" "+docId);
		Object [] obj = new Object[2];
		obj[0] = tagId;
		obj[1] = docId;
		conn.beginTransaction(r);
		conn.executeSQL(sql, r, obj);
		conn.endTransaction(r);
		sql = ISQL.INSERT_GROUP_DOC_REF;
		environment.logDebug("SQL "+sql+"\n"+docId+" "+groupId);
		obj = new Object[2];
		obj[0] = groupId;
		obj[1] = docId;
		conn.beginTransaction(r);
		conn.executeSQL(sql, r, obj);
		conn.endTransaction(r);
	}

	void insertGroupUserReference(IPostgresConnection conn, IResult r, String groupId, String userId)
			throws Exception {
		String sql = ISQL.INSERT_GROUP_USER_REF;
		environment.logDebug("SQL "+sql+"\n"+groupId+" "+userId);
		Object [] obj = new Object[2];
		obj[0] = groupId;
		obj[1] = userId;
		conn.beginTransaction(r);
		conn.executeSQL(sql, r, obj);
		conn.endTransaction(r);
	}

	void insertUserTagReference(IPostgresConnection conn, IResult r, String tagId, String userId)
			throws Exception {
		String sql = ISQL.INSERT_USER_TAG_REF;
		environment.logDebug("SQL "+sql+"\n"+tagId+" "+userId);
		Object [] obj = new Object[2];
		obj[0] = tagId;
		obj[1] = userId;
		conn.beginTransaction(r);
		conn.executeSQL(sql, r, obj);
		conn.endTransaction(r);
	}


	void insertDocument(IPostgresConnection conn, IResult r, String docId, String resource, 
				String title, String created, String userId)
			throws Exception {
		String sql = ISQL.INSERT_DOCUMENT; //(document_id, url, title, created)
		environment.logDebug("SQL "+sql+"\n"+docId+" "+resource+" "+created);
		Object [] obj = new Object[4];
		obj[0] = docId;
		obj[1] = resource;
		obj[2] = title;
		obj[3] = created;
		conn.beginTransaction(r);
		conn.executeSQL(sql, r, obj);
		if (r.hasError())
			environment.logError("A "+ r.getErrorString(), null);
		conn.endTransaction(r); // commits
		sql = ISQL.INSERT_USER_DOC_REF;
		environment.logDebug("SQL "+sql+"\n"+docId+" "+userId);
		obj = new Object[2];
		obj[0] = docId;
		obj[1] = userId;
		conn.beginTransaction(r);
		conn.executeSQL(sql, r, obj);
		conn.endTransaction(r);
		if (r.hasError())
			environment.logError("B "+ r.getErrorString(), null);
	}
	
	void insertTag(IPostgresConnection conn, IResult r, String tagId, String tag, String groupId)
			throws Exception {
		String sql = ISQL.INSERT_TAG;
		environment.logDebug("SQL "+sql+"\n"+tagId+" "+tag);
		Object [] obj = new Object[2];
		obj[0] = tagId;
		obj[1] = tag;
		conn.beginTransaction(r);
		conn.executeSQL(sql, r, obj);
		conn.endTransaction(r);
		sql = ISQL.INSERT_GROUP_TAG_REF;
		environment.logDebug("SQL "+sql+"\n"+tagId+" "+groupId);
		obj = new Object[2];
		obj[0] = tagId;
		obj[1] = groupId;
		conn.beginTransaction(r);
		conn.executeSQL(sql, r, obj);
		conn.endTransaction(r);
	}
	
	void insertAnnotation(IPostgresConnection conn, IResult r, String docId, String text)
			throws Exception {
		String sql = ISQL.INSERT_ANNOTATION;
		environment.logDebug("SQL "+sql+"\n"+docId+"\n"+text);
		Object [] obj = new Object[3];
		obj[0] = docId;
		obj[1] = text;
		obj[2] = "en";
		conn.beginTransaction(r);
		conn.executeSQL(sql, r, obj);
		conn.endTransaction(r);
	}
/*
	void insertText(IPostgresConnection conn, IResult r, String docId, String text)
			throws Exception {
		String sql = ISQL.INSERT_TEXT;
		environment.logDebug("SQL "+sql+"\n"+docId+"\n"+text);
		Object [] obj = new Object[2];
		obj[0] = docId;
		obj[1] = text;
		conn.beginTransaction(r);
		conn.executeSQL(sql, r, obj);
		conn.endTransaction(r);
	}
*/
}
