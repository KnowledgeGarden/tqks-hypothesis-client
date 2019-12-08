/**
 * 
 */
package org.topicquests.ks.tagomizer;

import java.sql.ResultSet;
import java.util.*;

import org.topicquests.ks.identity.TagIdentifier;
import org.topicquests.ks.tagomizer.api.ISQL;
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
	private TagomizerClientEnvironment environment;
	private PostgresConnectionFactory provider;

	/**
	 * 
	 */
	public PivotSuite(TagomizerClientEnvironment env) {
		environment = env;
		provider = environment.getProvider();
	}
	
	///////////////////////////
	// List All
	///////////////////////////
	public IResult listAllGroups() {
		IResult result = new ResultPojo();
		List<JSONObject> l = new ArrayList<JSONObject>();
		result.setResultObject(l);
		IPostgresConnection conn = null;
		IResult r = new ResultPojo();
		try {
			 conn = provider.getConnection();
		     conn.setProxyRole(r);
		     String sql = ISQL.LIST_GROUPS;
				Object [] obj = new Object[0];
				conn.executeSelect(sql, r, obj);
				ResultSet rs = (ResultSet)r.getResultObject();
				if (rs != null) {
					JSONObject jo;
					while (rs.next()) {
						jo = new JSONObject();
						jo.put("id", rs.getString(1));
						jo.put("name", rs.getString(2));
						l.add(jo);
					}
				}
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
		List<String> l = new ArrayList<String>();
		result.setResultObject(l);
		IPostgresConnection conn = null;
		IResult r = new ResultPojo();
		try {
			 conn = provider.getConnection();
		     conn.setProxyRole(r);
		     String sql = ISQL.LIST_USERS;
				Object [] obj = new Object[0];
				conn.executeSelect(sql, r, obj);
				ResultSet rs = (ResultSet)r.getResultObject();
				if (rs != null) {
					while (rs.next()) {
						l.add(rs.getString(1));
					}
				}
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
		List<JSONObject> l = new ArrayList<JSONObject>();
		result.setResultObject(l);
		IPostgresConnection conn = null;
		IResult r = new ResultPojo();
		try {
			 conn = provider.getConnection();
		     conn.setProxyRole(r);
				String sql = ISQL.LIST_TAGS;
				Object [] obj = new Object[2];
				obj[0] = new Integer(count); // limit
				obj[1] = new Integer(offset); // offset
				conn.executeSelect(sql, r, obj);
				ResultSet rs = (ResultSet)r.getResultObject();
				if (rs != null) {
					JSONObject jo;
					while (rs.next()) {
						jo = new JSONObject();
						jo.put("id", rs.getString(1));
						jo.put("name", rs.getString(2));
						l.add(jo);
					}
				}
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
		List<JSONObject> l = new ArrayList<JSONObject>();
		result.setResultObject(l);
		IPostgresConnection conn = null;
		IResult r = new ResultPojo();
		try {
			 conn = provider.getConnection();
		     conn.setProxyRole(r);
			String sql = ISQL.LIST_RESOURCES;
			Object [] obj = new Object[2];
			obj[0] = new Integer(count); // limit
			obj[1] = new Integer(offset); // offset
			conn.executeSelect(sql, r, obj);
			ResultSet rs = (ResultSet)r.getResultObject();
			if (rs != null) {
				JSONObject jo = null;
				String id;
				while (rs.next()) {
					id = rs.getString(2);
					if (jo == null) {
						jo = new JSONObject();
						jo.put("title", rs.getString(1));
						jo.put("docId", id);
						jo.put("url", rs.getString(3));
						addToTextList(jo, rs.getString(4));
					} else if (id.equals(jo.getAsString("docId")))
						addToTextList(jo, rs.getString(4));
					else {
						l.add(jo);
						jo = new JSONObject();
						jo.put("title", rs.getString(1));
						jo.put("docId", id);
						jo.put("url", rs.getString(3));
						addToTextList(jo, rs.getString(4));
					}
				}
				if (jo != null)
					l.add(jo);
			}
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
	
	///////////////////////////
	// Pivots
	///////////////////////////

	public IResult listPivotsByGroup(String groupId, int start, int count) {
		IResult result = new ResultPojo();
		JSONObject pivots = new JSONObject();
		result.setResultObject(pivots);
		IPostgresConnection conn = null;
		IResult r = new ResultPojo();
		List<String> users;
		List<JSONObject> tags;
		List<JSONObject> documents;
		IResult x;
		try {
			 conn = provider.getConnection();
		     conn.setProxyRole(r);
		     x = this.listUsersByGroup(conn, r, groupId);
		     users = (List<String>)x.getResultObject();
		     x = this.listTagsByGroup(conn, r, groupId, start, count);
		     tags = (List<JSONObject>)x.getResultObject();
		     x = this.listResourcesByGroup(conn, r, groupId, start, count);
		     documents = (List<JSONObject>)x.getResultObject();
		     pivots.put("users", users);
		     pivots.put("documents", documents);
		     pivots.put("tags", tags);
		     x = this.getGroupName(conn, r, groupId);
		     pivots.put("name", (String)x.getResultObject());

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
		List<JSONObject> groups;
		List<JSONObject> documents;
		List<JSONObject> tags;
		IResult x;
		try {
			 conn = provider.getConnection();
		     conn.setProxyRole(r);
		     x = this.listGroupsByUser(conn, r, userId);
		     groups = (List<JSONObject>)x.getResultObject();
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
	 * Must return not only the pivots, but the tagName for display
	 * @param tagId
	 * @param start
	 * @param count
	 * @return
	 */
	public IResult listPivotsByTag(String tagId, int start, int count) {
		IResult result = new ResultPojo();
		JSONObject pivots = new JSONObject();
		result.setResultObject(pivots);
		IPostgresConnection conn = null;
		IResult r = new ResultPojo();
		List<JSONObject> groups;
		List<JSONObject> documents;
		List<String> users;
		try {
			IResult x;
			 conn = provider.getConnection();
		     conn.setProxyRole(r);
		     x = this.listGroupsByTag(conn, r, tagId);
		     groups = (List<JSONObject>)x.getResultObject();
		     x = this.listResourcesByTag(conn, r, tagId, start, count);
		     documents = (List<JSONObject>)x.getResultObject();
		     x = this.listUsersByTag(conn, r, tagId);
		     users = (List<String>)x.getResultObject();
		     pivots.put("groups", groups);
		     pivots.put("documents", documents);
		     pivots.put("users", users);
		     x = this.getTagName(conn, r, tagId);
		     pivots.put("label", (String)x.getResultObject());


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
	
	
	public IResult listPivotsByResource(String docId, int start, int count) {
		IResult result = new ResultPojo();
		JSONObject pivots = new JSONObject();
		result.setResultObject(pivots);
		IPostgresConnection conn = null;
		IResult r = new ResultPojo();
		List<JSONObject> groups;
		List<JSONObject> tags;
		List<String> users;
		List<String> text;
		try {
			IResult x;
			 conn = provider.getConnection();
		     conn.setProxyRole(r);
		     x = this.listGroupsByResource(conn, r, docId);
		     groups = (List<JSONObject>)x.getResultObject();
		     x = this.listTagsByResource(conn, r, docId, start, count);
		     tags = (List<JSONObject>)x.getResultObject();
		     x = this.listUsersByResource(conn, r, docId);
		     users = (List<String>)x.getResultObject();
		     x = this.getTextByResourceAndLanguage(conn, r, docId, "en");
		     text = (List<String>)x.getResultObject();
		     pivots.put("text", text);
		     pivots.put("groups", groups);
		     pivots.put("users", users);
		     pivots.put("tags", tags);
		     x = this.getDocTitleAndUrl(conn, r, docId);
		     pivots.put("title", (String)x.getResultObject());
		     pivots.put("url", (String)x.getResultObjectA());
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

	///////////////////////////
	// Test Search
	///////////////////////////

	public IResult listTextBySearch(String query, int start, int count) {
		IResult result = new ResultPojo();
		IPostgresConnection conn = null;
		IResult r = new ResultPojo();
		try {
			 conn = provider.getConnection();
		     conn.setProxyRole(r);
		     IResult x = textSearchByQuery(conn, r, query, start, count);
		     List<JSONObject> l = (List<JSONObject>)x.getResultObject();
		     result.setResultObject(l);
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
	
	///////////////////////////
	// Utilities
	///////////////////////////
	
	IResult getTextByResourceAndLanguage(IPostgresConnection conn, IResult r, String docId, String language) throws Exception {
		IResult result = new ResultPojo();
		List<String> l = new ArrayList<String>();
		result.setResultObject(l);
		String sql = ISQL.GET_TEXT_BY_RESOURCE;
		Object [] obj = new Object[2];
		obj[0] = language;
		obj[1] = docId;
		conn.executeSelect(sql, r, obj);
		ResultSet rs = (ResultSet)r.getResultObject();
		if (rs != null) {
			JSONObject jo;
			if (rs.next()) {
				l.add(rs.getString(1));
			}
		}
		return result;
	}

	IResult getDocTitleAndUrl(IPostgresConnection conn, IResult r, String docId) throws Exception {
		IResult result = new ResultPojo();
		String sql = ISQL.GET_DOC_HEADER;
		Object [] obj = new Object[1];
		obj[0] = docId;
		conn.executeSelect(sql, r, obj);
		ResultSet rs = (ResultSet)r.getResultObject();
		if (rs != null) {
			JSONObject jo;
			if (rs.next()) {
				result.setResultObject(rs.getString(1)); // title
				result.setResultObjectA(rs.getString(2)); // url
			}
		}
		return result;
	}
	
	IResult getTagName(IPostgresConnection conn, IResult r, String tagId) throws Exception {
		IResult result = new ResultPojo();
		String sql = ISQL.GET_TAG_HEADER;
		Object [] obj = new Object[1];
		obj[0] = tagId;
		conn.executeSelect(sql, r, obj);
		ResultSet rs = (ResultSet)r.getResultObject();
		if (rs != null) {
			JSONObject jo;
			if (rs.next()) {
				result.setResultObject(rs.getString(1)); // name
			}
		}
		return result;
	}
	IResult getGroupName(IPostgresConnection conn, IResult r, String groupId) throws Exception {
		IResult result = new ResultPojo();
		String sql = ISQL.GET_GROUP_HEADER;
		Object [] obj = new Object[1];
		obj[0] = groupId;
		conn.executeSelect(sql, r, obj);
		ResultSet rs = (ResultSet)r.getResultObject();
		if (rs != null) {
			JSONObject jo;
			if (rs.next()) {
				result.setResultObject(rs.getString(1)); // name
			}
		}
		return result;
	}

	IResult textSearchByQuery(IPostgresConnection conn, IResult r, String query, int start, int count) throws Exception {
		IResult result = new ResultPojo();
		List<JSONObject> l = new ArrayList<JSONObject>();
		result.setResultObject(l);
		String sql = ISQL.GET_TEXT_BY_QUERY;
		Object [] obj = new Object[3];
		obj[0] = query;
		obj[1] = count;
		obj[2] = start;
		conn.executeSelect(sql, r, obj);
		ResultSet rs = (ResultSet)r.getResultObject();
		if (rs != null) {
			JSONObject jo;
			while (rs.next()) {
				jo = new JSONObject();
				jo.put("docId", rs.getString(1));
				jo.put("label", rs.getString(2));
				l.add(jo);
			}
		}
		return result;
	}

	/**
	 * Serves pagination as well as pivots
	 * @param conn
	 * @param r
	 * @param tagId
	 * @param start
	 * @param count
	 * @return
	 * @throws Exception
	 */
	public IResult listResourcesByTag(IPostgresConnection conn, IResult r, String tagId, int start, int count) throws Exception {
		IResult result = new ResultPojo();
		List<JSONObject> l = new ArrayList<JSONObject>();
		result.setResultObject(l);
		String sql = ISQL.GET_RESOURCES_BY_TAG;
		Object [] obj = new Object[3];
		obj[0] = tagId;
		obj[1] = count; // limit
		obj[2] = start; // offset
		conn.executeSelect(sql, r, obj);
		ResultSet rs = (ResultSet)r.getResultObject();
		if (rs != null) {
			JSONObject jo = null;
			String id;
			while (rs.next()) {
				id = rs.getString(2);
				if (jo == null) {
					jo = new JSONObject();
					jo.put("title", rs.getString(1));
					jo.put("docId", id);
					jo.put("url", rs.getString(3));
					addToTextList(jo, rs.getString(4));
				} else if (id.equals(jo.getAsString("docId")))
					addToTextList(jo, rs.getString(4));
				else {
					l.add(jo);
					jo = new JSONObject();
					jo.put("title", rs.getString(1));
					jo.put("docId", id);
					jo.put("url", rs.getString(3));
					addToTextList(jo, rs.getString(4));
				}
			}
			if (jo != null)
				l.add(jo);
		}
		return result;
	}
	/**
	 * Serves pagination as well as pivots
	 * <p>Listing unique resources is the same as listing documents by user</p>
	 * @param conn
	 * @param r
	 * @param userId
	 * @param start
	 * @param count
	 * @return
	 * @throws Exception
	 */
	public IResult listResourcesByUser(IPostgresConnection conn, IResult r, String userId, int start, int count) throws Exception {
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
			JSONObject jo = null;
			String id;
			while (rs.next()) {
				id = rs.getString(2);
				if (jo == null) {
					jo = new JSONObject();
					jo.put("title", rs.getString(1));
					jo.put("docId", id);
					jo.put("url", rs.getString(3));
					addToTextList(jo, rs.getString(4));
				} else if (id.equals(jo.getAsString("docId")))
					addToTextList(jo, rs.getString(4));
				else {
					l.add(jo);
					jo = new JSONObject();
					jo.put("title", rs.getString(1));
					jo.put("docId", id);
					jo.put("url", rs.getString(3));
					addToTextList(jo, rs.getString(4));
				}
			}
			if (jo != null)
				l.add(jo);
		}
		return result;
	}
	
	void addToTextList(JSONObject jo, String text) {
		if (text == null) return;
		List<String> l = (List<String>)jo.get("text");
		if (l == null) l = new ArrayList<String>();
		l.add(text);
		jo.put("text", l);
	}
	
	/**
	 * Serves pagination as well as pivots
	 * @param conn
	 * @param r
	 * @param groupId
	 * @param start
	 * @param count
	 * @return
	 * @throws Exception
	 */
	public IResult listResourcesByGroup(IPostgresConnection conn, IResult r, String groupId, int start, int count) throws Exception {
		IResult result = new ResultPojo();
		List<JSONObject> l = new ArrayList<JSONObject>();
		result.setResultObject(l);
		String sql = ISQL.GET_RESOURCES_BY_GROUP;
		Object [] obj = new Object[3];
		obj[0] = groupId;
		obj[1] = count; // limit
		obj[2] = start; // offset
		conn.executeSelect(sql, r, obj);
		ResultSet rs = (ResultSet)r.getResultObject();
		if (rs != null) {
			JSONObject jo = null;
			String id;
			while (rs.next()) {
				id = rs.getString(2);
				if (jo == null) {
					jo = new JSONObject();
					jo.put("title", rs.getString(1));
					jo.put("docId", id);
					jo.put("url", rs.getString(3));
					addToTextList(jo, rs.getString(4));
				} else if (id.equals(jo.getAsString("docId")))
					addToTextList(jo, rs.getString(4));
				else {
					l.add(jo);
					jo = new JSONObject();
					jo.put("title", rs.getString(1));
					jo.put("docId", id);
					jo.put("url", rs.getString(3));
					addToTextList(jo, rs.getString(4));
				}
			}
			if (jo != null)
				l.add(jo);
		}
		return result;
	}

	/**
	 * Serves pagination as well as pivots
	 * @param conn
	 * @param r
	 * @param docId
	 * @param start
	 * @param count
	 * @return
	 * @throws Exception
	 */
	public IResult listTagsByResource(IPostgresConnection conn, IResult r, String docId, int start, int count) throws Exception {
		IResult result = new ResultPojo();
		List<JSONObject> l = new ArrayList<JSONObject>();
		result.setResultObject(l);
		String sql = ISQL.GET_TAGS_BY_RESOURCE;
		Object [] obj = new Object[3];
		obj[0] = docId;
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

	/**
	 * Serves pagination as well as pivots
	 * @param conn
	 * @param r
	 * @param userId
	 * @param start
	 * @param count
	 * @return
	 * @throws Exception
	 */
	public IResult listTagsByUser(IPostgresConnection conn, IResult r, String userId, int start, int count) throws Exception {
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

	/**
	 * Serves pagination as well as pivots
	 * @param conn
	 * @param r
	 * @param groupId
	 * @param start
	 * @param count
	 * @return
	 * @throws Exception
	 */
	public IResult listTagsByGroup(IPostgresConnection conn, IResult r, String groupId, int start, int count) throws Exception {
		IResult result = new ResultPojo();
		List<JSONObject> l = new ArrayList<JSONObject>();
		result.setResultObject(l);
		String sql = ISQL.GET_TAGS_BY_GROUP;
		Object [] obj = new Object[3];
		obj[0] = groupId;
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

	/**
	 * Serves pagination as well as pivots
	 * @param conn
	 * @param r
	 * @param tagName
	 * @return
	 * @throws Exception
	 * /
	public IResult listResourcesByTag(IPostgresConnection conn, IResult r, String tagName) throws Exception {
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
*/




	//////////////////////////////
	// Queries without paging
	// If the system grows, they can be modified for paging
	//////////////////////////////

	IResult listUsersByTag(IPostgresConnection conn, IResult r, String tagId) throws Exception {
		IResult result = new ResultPojo();
		List<String> l = new ArrayList<String>();
		result.setResultObject(l);
		String sql = ISQL.GET_USERS_BY_TAG;
		Object [] obj = new Object[1];
		obj[0] = tagId;
		conn.executeSelect(sql, r, obj);
		ResultSet rs = (ResultSet)r.getResultObject();
		if (rs != null) {
			while (rs.next()) {
				l.add(rs.getString(1));
			}
		}
		return result;
	}

	IResult listUsersByResource(IPostgresConnection conn, IResult r, String docId) throws Exception {
		IResult result = new ResultPojo();
		List<String> l = new ArrayList<String>();
		result.setResultObject(l);
		String sql = ISQL.GET_USERS_BY_RESOURCE;
		Object [] obj = new Object[1];
		obj[0] = docId;
		conn.executeSelect(sql, r, obj);
		ResultSet rs = (ResultSet)r.getResultObject();
		if (rs != null) {
			while (rs.next()) {
				l.add(rs.getString(1));
			}
		}
		return result;
	}

	IResult listGroupsByTag(IPostgresConnection conn, IResult r, String tagId) throws Exception {
		IResult result = new ResultPojo();
		List<JSONObject> usrs = new ArrayList<JSONObject>();
		result.setResultObject(usrs);
	    String sql = ISQL.GET_GROUPS_BY_TAG;
		Object [] obj = new Object[1];
		obj[0] = tagId;
		conn.executeSelect(sql, r, obj);
		ResultSet rs = (ResultSet)r.getResultObject();
		if (rs != null) {
			JSONObject jo;
			while (rs.next()) {
				jo = new JSONObject();
				jo.put("groupId", rs.getString(1));
				jo.put("name", rs.getString(2));
				usrs.add(jo);
			}
		}		
		if (r.hasError())
			result.addErrorString(r.getErrorString());
		return result;
	}

	IResult listGroupsByResource(IPostgresConnection conn, IResult r, String docId) throws Exception {
		IResult result = new ResultPojo();
		List<JSONObject> usrs = new ArrayList<JSONObject>();
		result.setResultObject(usrs);
	    String sql = ISQL.GET_GROUPS_BY_RESOURCE;
		Object [] obj = new Object[1];
		obj[0] = docId;
		conn.executeSelect(sql, r, obj);
		ResultSet rs = (ResultSet)r.getResultObject();
		if (rs != null) {
			JSONObject jo;
			while (rs.next()) {
				jo = new JSONObject();
				jo.put("groupId", rs.getString(1));
				jo.put("name", rs.getString(2));
				usrs.add(jo);
			}
		}		
		if (r.hasError())
			result.addErrorString(r.getErrorString());
		return result;
	}

	IResult listGroupsByUser(IPostgresConnection conn, IResult r, String userId) throws Exception {
		IResult result = new ResultPojo();
		List<JSONObject> usrs = new ArrayList<JSONObject>();
		result.setResultObject(usrs);
	    String sql = ISQL.GET_GROUPS_BY_USER;
		Object [] obj = new Object[1];
		obj[0] = userId;
		conn.executeSelect(sql, r, obj);
		ResultSet rs = (ResultSet)r.getResultObject();
		if (rs != null) {
			JSONObject jo;
			while (rs.next()) {
				jo = new JSONObject();
				jo.put("groupId", rs.getString(1));
				jo.put("name", rs.getString(2));
				usrs.add(jo);
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
