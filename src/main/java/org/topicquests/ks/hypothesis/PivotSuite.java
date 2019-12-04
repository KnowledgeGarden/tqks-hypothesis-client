/**
 * 
 */
package org.topicquests.ks.hypothesis;

import java.sql.ResultSet;
import java.util.*;

import org.topicquests.ks.hypothesis.api.ISQL;
import org.topicquests.ks.identity.TagIdentifier;
import org.topicquests.pg.PostgresConnectionFactory;
import org.topicquests.pg.api.IPostgresConnection;
import org.topicquests.support.ResultPojo;
import org.topicquests.support.api.IResult;

import net.minidev.json.JSONObject;

/**
 * @author jackpark
 *
 */
public class PivotSuite {
	private HypothesisHarvesterEnvironment environment;
	private PostgresConnectionFactory provider;

	/**
	 * 
	 */
	public PivotSuite(HypothesisHarvesterEnvironment env) {
		environment = env;
		provider = environment.getProvider();
	}
	
	public IResult listAllGroups() {
		IResult result = new ResultPojo();
		IPostgresConnection conn = null;
		IResult r = new ResultPojo();
		try {
			 conn = provider.getConnection();
		     conn.setProxyRole(r);
		     //DO SOMETHING
		} catch (Exception e) {
			environment.logError(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			conn.closeConnection(r);
		}
		if (r.hasError())
			result.addErrorString(r.getErrorString());
		return result;
	}
	
	public IResult listAllUsers() {
		IResult result = new ResultPojo();
		IPostgresConnection conn = null;
		IResult r = new ResultPojo();
		try {
			 conn = provider.getConnection();
		     conn.setProxyRole(r);
		     //DO SOMETHING
		} catch (Exception e) {
			environment.logError(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			conn.closeConnection(r);
		}
		if (r.hasError())
			result.addErrorString(r.getErrorString());
		return result;
	}
	
	public IResult listAllTags(int offset, int count) {
		IResult result = new ResultPojo();
		IPostgresConnection conn = null;
		IResult r = new ResultPojo();
		try {
			 conn = provider.getConnection();
		     conn.setProxyRole(r);
		     //DO SOMETHING
		} catch (Exception e) {
			environment.logError(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			conn.closeConnection(r);
		}
		if (r.hasError())
			result.addErrorString(r.getErrorString());
		return result;
	}


	public IResult listAllResources(int offset, int count) {
		IResult result = new ResultPojo();
		IPostgresConnection conn = null;
		IResult r = new ResultPojo();
		try {
			 conn = provider.getConnection();
		     conn.setProxyRole(r);
		     //DO SOMETHING
		} catch (Exception e) {
			environment.logError(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			conn.closeConnection(r);
		}
		if (r.hasError())
			result.addErrorString(r.getErrorString());
		return result;
	}

	public IResult listPivotsByGroup(String groupId, int start, int count) {
		IResult result = new ResultPojo();
		IPostgresConnection conn = null;
		IResult r = new ResultPojo();
		try {
			 conn = provider.getConnection();
		     conn.setProxyRole(r);
		     //DO SOMETHING
		} catch (Exception e) {
			environment.logError(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			conn.closeConnection(r);
		}
		if (r.hasError())
			result.addErrorString(r.getErrorString());
		return result;
	}

	public IResult listPivotsByUser(String userId, int start, int count) {
		IResult result = new ResultPojo();
		JSONObject pivots = new JSONObject();
		result.setResultObject(pivots);
		IPostgresConnection conn = null;
		IResult r = new ResultPojo();
		List<String> groups;
		List<JSONObject> documents;
		List<JSONObject> tags;
		IResult x;
		try {
			 conn = provider.getConnection();
		     conn.setProxyRole(r);
		     x = this.listGroupsByUser(conn, r, userId);
		     groups = (List<String>)x.getResultObject();
		     x = this.listResourcesByUser(conn, r, userId, start, count);
		     documents = (List<JSONObject>)x.getResultObject();
		     x = this.listTagsByUser(conn, r, userId, start, count);
		     tags = (List<JSONObject>)x.getResultObject();
		     pivots.put("groups", groups);
		     pivots.put("documents", documents);
		     pivots.put("tags", tags);
		} catch (Exception e) {
			environment.logError(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			conn.closeConnection(r);
		}
		if (r.hasError())
			result.addErrorString(r.getErrorString());
		return result;
	}

	/**
	 * <p>Listing unique resources is the same as listing documents by user</p>
	 * @param conn
	 * @param r
	 * @param userId
	 * @param start
	 * @param count
	 * @return
	 * @throws Exception
	 */
	IResult listResourcesByUser(IPostgresConnection conn, IResult r, String userId, int start, int count) throws Exception {
		IResult result = new ResultPojo();
		List<JSONObject> l = new ArrayList<JSONObject>();
		result.setResultObject(l);
		String sql = ISQL.GET_RESOURCES_BY_USER;
		Object [] obj = new Object[3];
		obj[0] = userId;
		obj[1] = count; // limit
		obj[2] = start; // offset
		conn.executeSelect(sql, r, obj);
		ResultSet rs = (ResultSet)r.getResultObject();
		if (rs != null) {
			JSONObject jo;
			while (rs.next()) {
				jo = new JSONObject();
				jo.put("title", rs.getString(1));
				jo.put("docId", rs.getString(2));
				jo.put("url", rs.getString(3));
				l.add(jo);
			}
		}
		return result;
	}

	IResult listTagsByUser(IPostgresConnection conn, IResult r, String userId, int start, int count) throws Exception {
		IResult result = new ResultPojo();
		List<JSONObject> l = new ArrayList<JSONObject>();
		result.setResultObject(l);
		String sql = ISQL.GET_TAGS_BY_USER;
		Object [] obj = new Object[3];
		obj[0] = userId;
		obj[1] = count; // limit
		obj[2] = start; // offset
		conn.executeSelect(sql, r, obj);
		ResultSet rs = (ResultSet)r.getResultObject();
		if (rs != null) {
			JSONObject jo;
			while (rs.next()) {
				jo = new JSONObject();
				jo.put("label", rs.getString(1));
				jo.put("id", rs.getString(2));
				l.add(jo);
			}
		}
		return result;
	}

	IResult listResourcesByTag(IPostgresConnection conn, IResult r, String tagName) throws Exception {
		IResult result = new ResultPojo();
		List<JSONObject> l = new ArrayList<JSONObject>();
		result.setResultObject(l);
		String sql = ISQL.GATHER_RESOURCES_BY_TAG;
		Object [] obj = new Object[1];
		obj[0] = TagIdentifier.tagToId(tagName);
		conn.executeSelect(sql, r, obj);
		ResultSet rs = (ResultSet)r.getResultObject();
		if (rs != null) {
			JSONObject jo;
			while (rs.next()) {
				jo = new JSONObject();
				jo.put("title", rs.getString(1));
				jo.put("docId", rs.getString(2));
				l.add(jo);
			}
		}
		return result;
	}

	IResult listUsersByResource(IPostgresConnection conn, IResult r, String url) throws Exception {
		IResult result = new ResultPojo();
		List<JSONObject> l = new ArrayList<JSONObject>();
		result.setResultObject(l);
		String sql = ISQL.GET_USERS_BY_RESOURCE;
		Object [] obj = new Object[1];
		obj[0] = url;
		conn.executeSelect(sql, r, obj);
		ResultSet rs = (ResultSet)r.getResultObject();
		if (rs != null) {
			JSONObject jo;
			while (rs.next()) {
				jo = new JSONObject();
				jo.put("title", rs.getString(1));
				jo.put("docId", rs.getString(2));
				l.add(jo);
			}
		}
		return result;
	}
	
	public IResult textSearchByQuery(IPostgresConnection conn, IResult r, String query) throws Exception {
		IResult result = new ResultPojo();
		List<JSONObject> l = new ArrayList<JSONObject>();
		result.setResultObject(l);
		String sql = ISQL.GET_TEXT_BY_QUERY;
		Object [] obj = new Object[1];
		obj[0] = query;
		conn.executeSelect(sql, r, obj);
		ResultSet rs = (ResultSet)r.getResultObject();
		if (rs != null) {
			JSONObject jo;
			while (rs.next()) {
				jo = new JSONObject();
				jo.put("docId", rs.getString("document_id"));
				//jo.put("test", rs.getString("text"));
				l.add(jo);
			}
		}
		return result;
	}

	public IResult listPivotsByTag(String tagName) {
		IResult result = new ResultPojo();
		IPostgresConnection conn = null;
		IResult r = new ResultPojo();
		try {
			 conn = provider.getConnection();
		     conn.setProxyRole(r);
		     //DO SOMETHING
		} catch (Exception e) {
			environment.logError(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			conn.closeConnection(r);
		}
		if (r.hasError())
			result.addErrorString(r.getErrorString());
		return result;
	}
	
	
	public IResult listPivotsByResource(String url) {
		IResult result = new ResultPojo();
		IPostgresConnection conn = null;
		IResult r = new ResultPojo();
		try {
			 conn = provider.getConnection();
		     conn.setProxyRole(r);
		     //DO SOMETHING
		} catch (Exception e) {
			environment.logError(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			conn.closeConnection(r);
		}
		if (r.hasError())
			result.addErrorString(r.getErrorString());
		return result;
	}

	public IResult listTextBySearch(String query) {
		IResult result = new ResultPojo();
		IPostgresConnection conn = null;
		IResult r = new ResultPojo();
		try {
			 conn = provider.getConnection();
		     conn.setProxyRole(r);
		     //DO SOMETHING
		} catch (Exception e) {
			environment.logError(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			conn.closeConnection(r);
		}
		if (r.hasError())
			result.addErrorString(r.getErrorString());
		return result;
	}

	//////////////////////////////
	// Queries without paging
	//////////////////////////////
	
	IResult listGroupsByUser(IPostgresConnection conn, IResult r, String userId) throws Exception {
		IResult result = new ResultPojo();
		List<String> usrs = new ArrayList<String>();
		result.setResultObject(usrs);
	    String sql = ISQL.GET_GROUPS_BY_USER;
		Object [] obj = new Object[1];
		obj[0] = userId;
		conn.executeSelect(sql, r, obj);
		ResultSet rs = (ResultSet)r.getResultObject();
		if (rs != null) {
			while (rs.next()) {
				usrs.add(rs.getString(1));
			}
		}		
		if (r.hasError())
			result.addErrorString(r.getErrorString());
		return result;
	}

	IResult listUsersByGroup(IPostgresConnection conn, IResult r, String groupId) throws Exception {
		IResult result = new ResultPojo();
		List<String> usrs = new ArrayList<String>();
		result.setResultObject(usrs);
	    String sql = ISQL.GET_USERS_BY_GROUP;
		Object [] obj = new Object[1];
		obj[0] = groupId;
		conn.executeSelect(sql, r, obj);
		ResultSet rs = (ResultSet)r.getResultObject();
		if (rs != null) {
			while (rs.next()) {
				usrs.add(rs.getString(1));
			}
		}		
		if (r.hasError())
			result.addErrorString(r.getErrorString());
		return result;
	}
}
