/**
 * 
 */
package org.topicquests.ks.hypothesis;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
	 * @param tags can be <code>null</code> or empty
	 */
	public void processPivotData(String id,
								 String user,
								 String resource, //url
								 String title,
								 List<String>tags) {
		
		environment.logDebug("PM.processPivotData "+resource+" | "+user+" | "+tags);
		IPostgresConnection conn = null;
		IResult r = new ResultPojo();
		boolean validTags = (tags != null && !tags.isEmpty());
		Iterator<String> itr;
		String theTag;
		try {
			 conn = provider.getConnection();
		     conn.setProxyRole(r);
		     // resource --document
		     insertDocument(conn, r, resource, title);
		     // user
		     insertUser(conn, r, user);
		     // tags
		     if (validTags) {
		    	 itr = tags.iterator();
		    	 while (itr.hasNext()) {
		    		theTag = itr.next();
		    		insertTag(conn, r, theTag);
		    	 }
		     }
		     //pivots--references
		     //tq_tagomizer.reference
		     // wants id, docId from doc table, userid from user table
		     int docId = getDocId(conn, r, resource);
		     int userId = getUserId(conn, r, user);
		     insertReference(conn, r, docId, userId, id);
		     //tq_tagomizer.tag_ref
		     // forloop on each tag
		     // wants tagid from tag table, id
		     itr = tags.iterator();
		     int tagid;
	    	 while (itr.hasNext()) {
	    		theTag = itr.next();
	    		tagid = getTagId(conn, r, theTag);
	    		insertTagReference(conn, r, tagid, id);
	    	 }
		     
		} catch (Exception e) {
			environment.logError(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			conn.closeConnection(r);
		}
	}

	int getTagId(IPostgresConnection conn, IResult r, String tag) 
			throws Exception {
		int result = -1;
		String sql = "SELECT id FROM tq_tagomizer.tag where name=?";
		Object [] obj = new Object[1];
		obj[0] = tag;
		conn.executeSelect(sql, r, obj);
		ResultSet rs = (ResultSet)r.getResultObject();
		if (rs != null && rs.next())
			result = rs.getInt("id");
		return result;
	}

	int getDocId(IPostgresConnection conn, IResult r, String url) 
			throws Exception {
		int result = -1;
		String sql = "SELECT id FROM tq_tagomizer.document where url=?";
		Object [] obj = new Object[1];
		obj[0] = url;
		conn.executeSelect(sql, r, obj);
		ResultSet rs = (ResultSet)r.getResultObject();
		if (rs != null && rs.next())
			result = rs.getInt("id");
		return result;
	}

	int getUserId(IPostgresConnection conn, IResult r, String user) 
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
	}
	
	void insertTagReference(IPostgresConnection conn, IResult r, int tagId, String id)
			throws Exception {
		String sql = "INSERT  into tq_tagomizer.tag_ref VALUES ( ?, ? ) ON CONFLICT DO NOTHING";
		Object [] obj = new Object[2];
		obj[0] = tagId;
		obj[1] = id;
		conn.beginTransaction(r);
		conn.executeSQL(sql, r, obj);
		conn.endTransaction(r);
	}

	void insertReference(IPostgresConnection conn, IResult r, int docId, int userId, String id)
			throws Exception {
		String sql = "INSERT  into tq_tagomizer.reference VALUES ( ?, ?, ? ) ON CONFLICT DO NOTHING";
		Object [] obj = new Object[3];
		obj[0] = id;
		obj[1] = docId;
		obj[2] = userId;
		conn.beginTransaction(r);
		conn.executeSQL(sql, r, obj);
		conn.endTransaction(r);
	}

	void insertDocument(IPostgresConnection conn, IResult r, String resource, String title)
			throws Exception {
		String sql = "INSERT  into tq_tagomizer.document (url, title) VALUES ( ?, ? ) ON CONFLICT DO NOTHING";
		Object [] obj = new Object[2];
		obj[0] = resource;
		obj[1] = title;
		conn.beginTransaction(r);
		conn.executeSQL(sql, r, obj);
		conn.endTransaction(r);
	}
	
	void insertUser(IPostgresConnection conn, IResult r, String user)
			throws Exception {
		String sql = "INSERT  into tq_tagomizer.huser (hyp_uid) VALUES ( ? ) ON CONFLICT DO NOTHING";
		Object [] obj = new Object[1];
		obj[0] = user;
		conn.beginTransaction(r);
		conn.executeSQL(sql, r, obj);
		conn.endTransaction(r);
	}
	
	void insertTag(IPostgresConnection conn, IResult r, String tag)
			throws Exception {
		String sql = "INSERT  into tq_tagomizer.tag (name) VALUES ( ? ) ON CONFLICT DO NOTHING";
		Object [] obj = new Object[1];
		obj[0] = tag;
		conn.beginTransaction(r);
		conn.executeSQL(sql, r, obj);
		conn.endTransaction(r);
	}
}
