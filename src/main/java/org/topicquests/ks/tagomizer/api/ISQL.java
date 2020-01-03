/**
 * 
 */
package org.topicquests.ks.tagomizer.api;

/**
 * @author jackpark
 *
 */
public interface ISQL {

	///////////////////////////
	// These are for used in PivotModel
	///////////////////////////

	// ### tq_tagomizer.tag_ref
	public static final String INSERT_DOC_TAG_REF =
			"INSERT  into tq_tagomizer.doc_tag_ref (tag_id, document_id) VALUES ( ?, ? ) ON CONFLICT DO NOTHING";

	public static final String INSERT_USER_TAG_REF =
			"INSERT  into tq_tagomizer.user_tag_ref (tag_id, user_id) VALUES ( ?, ? ) ON CONFLICT DO NOTHING";

	//tq_tagomizer.user_doc_ref
	public static final String INSERT_USER_DOC_REF =
			"INSERT  into tq_tagomizer.user_doc_ref (document_id, user_id) VALUES ( ?, ? ) ON CONFLICT DO NOTHING";

	public static final String INSERT_GROUP_TAG_REF =
			"INSERT  into tq_tagomizer.group_tag_ref (tag_id, group_id) VALUES ( ?, ? ) ON CONFLICT DO NOTHING";

	//tq_tagomizer.group_user_ref
	public static final String INSERT_GROUP_USER_REF =
			"INSERT  into tq_tagomizer.group_user_ref (group_id, user_id) VALUES ( ?, ? ) ON CONFLICT DO NOTHING";
	
	//tq_tagomizer.group_doc_ref
	public static final String INSERT_GROUP_DOC_REF =
			"INSERT  into tq_tagomizer.group_doc_ref (group_id, document_id) VALUES ( ?, ? ) ON CONFLICT DO NOTHING";
	
	public static final String SELECT_DOC_ID_BY_URL_GROUP =
			"SELECT document_id FROM tq_tagomizer.document WHERE url=? AND group_id=?";

	//check before inserting
	public static final String INSERT_DOCUMENT =
			"INSERT  into tq_tagomizer.document (document_id, url, title, created) VALUES ( ?, ?, ?, ? ) ON CONFLICT DO NOTHING";
	
	public static final String INSERT_GROUP =
			"INSERT  into tq_tagomizer.group (id, name) VALUES ( ?, ? ) ON CONFLICT DO NOTHING";

	public static final String INSERT_USER =
			"INSERT  into tq_tagomizer.user (id) VALUES ( ? ) ON CONFLICT DO NOTHING";
	
	public static final String INSERT_TAG =
			"INSERT  into tq_tagomizer.tag VALUES ( ?, ? ) ON CONFLICT DO NOTHING";

	public static final String INSERT_ANNOTATION =
			"INSERT  into tq_tagomizer.annotations VALUES ( ?, ?, ? ) ON CONFLICT DO NOTHING";
//			"INSERT  into tq_tagomizer.annotations VALUES ( ?, ?, to_tsvector( ? )  ) ON CONFLICT DO NOTHING";

	//public static final String INSERT_TEXT =
	//		"INSERT  into tq_tagomizer.texts VALUES ( ?, ?, (to_tsvector( ? ) ) ON CONFLICT DO NOTHING";


	///////////////////////////
	// These are for testing code for the backside server
	///////////////////////////
	/**
	 * Gather Annotations by URL
	 */
//	public static final String GATHER_RESOURCE_BY_URL = 
//			"SELECT text from tq_tagomizer.annotations where document_id IN "+
//			"( SELECT document_id from tq_tagomizer.documents where url=?)";
	
	/**
	 * Gather Resources (documents) by Tag
	 * ### tq_tagomizer.tag_ref
	 */
//	public static final String GATHER_RESOURCES_BY_TAG =
//			"SELECT DISTINCT title, document_id from tq_tagomizer.document where document_id IN "+
//			"( SELECT document_id from tq_tagomizer.tag_ref where tag_id=?)";
	// from JavalinHypothesis HypothesisDao
	
	/* fixed */
	public static final String GET_RESOURCES_BY_USER =
			"SELECT DISTINCT tq_tagomizer.document.title, tq_tagomizer.document.document_id, url, text FROM tq_tagomizer.document "+
					"JOIN tq_tagomizer.annotations ON tq_tagomizer.document.document_id = tq_tagomizer.annotations.document_id "+
					"JOIN tq_tagomizer.user_doc_ref ON tq_tagomizer.document.document_id = tq_tagomizer.user_doc_ref.document_id "+
					"WHERE tq_tagomizer.user_doc_ref.user_id = ? " +
					"ORDER BY tq_tagomizer.document.title ASC LIMIT ? OFFSET ?";

	public static final String GET_RESOURCES_BY_TAG =
			"SELECT DISTINCT tq_tagomizer.document.title, tq_tagomizer.document.document_id, url, text FROM tq_tagomizer.document "+
					"JOIN tq_tagomizer.doc_tag_ref ON tq_tagomizer.document.document_id = tq_tagomizer.doc_tag_ref.document_id "+
					"JOIN tq_tagomizer.annotations ON tq_tagomizer.document.document_id = tq_tagomizer.annotations.document_id "+
					"WHERE tq_tagomizer.doc_tag_ref.tag_id  = ? " +
					"ORDER BY tq_tagomizer.document.title ASC LIMIT ? OFFSET ?";

	
	/**
	 * Given a url, find all the users from all the documents
	 * ### tq_tagomizer.reference huser
	 */
	public static final String GET_USERS_BY_RESOURCE =
			"SELECT DISTINCT user_id FROM tq_tagomizer.user_doc_ref "+
					"WHERE tq_tagomizer.user_doc_ref.document_id = ? ";
	
	public static final String GET_USERS_BY_TAG =
			"SELECT DISTINCT user_id FROM tq_tagomizer.user_tag_ref "+
					"WHERE tag_id = ? ";
	

	public static final String GET_TAGS_BY_USER =
			"SELECT DISTINCT tq_tagomizer.tag.name, tq_tagomizer.tag.id FROM tq_tagomizer.tag "+
					"JOIN tq_tagomizer.user_tag_ref ON tq_tagomizer.tag.id = tq_tagomizer.user_tag_ref.tag_id "+
					"WHERE tq_tagomizer.user_tag_ref.user_id = ? "+
					"ORDER BY tq_tagomizer.tag.name ASC LIMIT ? OFFSET ?";

	public static final String GET_TAGS_BY_RESOURCE =
			"SELECT DISTINCT tq_tagomizer.tag.name, tq_tagomizer.tag.id FROM tq_tagomizer.tag "+
					"JOIN tq_tagomizer.doc_tag_ref ON tq_tagomizer.tag.id = tq_tagomizer.doc_tag_ref.tag_id "+
					"WHERE tq_tagomizer.doc_tag_ref.document_id = ? "+
					"ORDER BY tq_tagomizer.tag.name ASC LIMIT ? OFFSET ?";
	
	public static final String GET_TEXT_BY_RESOURCE =
			"SELECT text FROM tq_tagomizer.annotations WHERE language=? AND document_id=?";

	// ### tq_tagomizer.reference
//	public static final String GET_RESOURCE_PIVOT =
//			"SELECT tq_tagomizer.reference.hyp_id from tq_tagomizer.reference "+
//		    		"JOIN tq_tagomizer.document ON tq_tagomizer.reference.document_id = tq_tagomizer.document.id "+
//		    		"WHERE tq_tagomizer.document.url = ?";

	// using tq_tagomizer.document to cluser user_id and group_id
	public static final String GET_USERS_BY_GROUP =
			"SELECT DISTINCT user_id from tq_tagomizer.group_user_ref where group_id=?";

	public static final String GET_GROUPS_BY_USER =
			"SELECT DISTINCT id, name from tq_tagomizer.group " +
		    "JOIN tq_tagomizer.group_user_ref ON tq_tagomizer.group.id = tq_tagomizer.group_user_ref.group_id "+
		    "where tq_tagomizer.group_user_ref.user_id=?";

	public static final String GET_GROUPS_BY_TAG =
			"SELECT DISTINCT id, name from tq_tagomizer.group " +
		    "JOIN tq_tagomizer.group_tag_ref ON tq_tagomizer.group.id = tq_tagomizer.group_tag_ref.group_id "+
		    "where tq_tagomizer.group_tag_ref.tag_id=?";

	public static final String LIST_RESOURCES =
			"SELECT DISTINCT tq_tagomizer.document.title, tq_tagomizer.document.document_id, url, text FROM tq_tagomizer.document "+
					"JOIN tq_tagomizer.annotations ON tq_tagomizer.document.document_id = tq_tagomizer.annotations.document_id "+
					"ORDER BY tq_tagomizer.document.title ASC LIMIT ? OFFSET ?";

	public static final String LIST_TAGS =
			"SELECT DISTINCT id, name FROM tq_tagomizer.tag "+
					"ORDER BY name ASC LIMIT ? OFFSET ?";

	public static final String LIST_GROUPS =
			"SELECT DISTINCT id, name from tq_tagomizer.group";

	public static final String LIST_USERS =
			"SELECT DISTINCT id from tq_tagomizer.user";

	public static final String GET_DOC_HEADER =
			"SELECT title, url FROM tq_tagomizer.document WHERE document_id=?";

	public static final String GET_TAG_HEADER =
			"SELECT name FROM tq_tagomizer.tag WHERE id=?";

	public static final String GET_GROUP_HEADER =
			"SELECT name FROM tq_tagomizer.group WHERE id=?";

	//////////
	// Groups and text search

	public static final String GET_TAGS_BY_GROUP =
			"SELECT DISTINCT tq_tagomizer.tag.name, tq_tagomizer.tag.id FROM tq_tagomizer.tag "+
					"JOIN tq_tagomizer.group_tag_ref ON tq_tagomizer.tag.id = group_tag_ref.tag_id "+
					"WHERE tq_tagomizer.group_tag_ref.group_id = ? "+
					"ORDER BY tq_tagomizer.tag.name ASC LIMIT ? OFFSET ?";

	public static final String GET_RESOURCES_BY_GROUP =
			"SELECT DISTINCT tq_tagomizer.document.title, tq_tagomizer.document.document_id, url, text FROM tq_tagomizer.document "+
					"JOIN tq_tagomizer.annotations ON tq_tagomizer.document.document_id = tq_tagomizer.annotations.document_id "+
				    "JOIN tq_tagomizer.group_doc_ref ON tq_tagomizer.document.document_id = tq_tagomizer.group_doc_ref.document_id "+
					"WHERE tq_tagomizer.group_doc_ref.group_id = ? " +
					"ORDER BY tq_tagomizer.document.title ASC LIMIT ? OFFSET ?";

	public static final String GET_GROUPS_BY_RESOURCE =
			"SELECT DISTINCT id, name  FROM tq_tagomizer.group "+
				    "JOIN tq_tagomizer.group_doc_ref ON tq_tagomizer.group.id = tq_tagomizer.group_doc_ref.group_id "+
					"WHERE tq_tagomizer.group_doc_ref.document_id = ? ";
	
	// should return a List<String>
	public static final String GET_TEXT_BY_QUERY = 
			"select tq_tagomizer.annotations.document_id, tq_tagomizer.document.title from tq_tagomizer.annotations  "+
			"JOIN tq_tagomizer.document ON tq_tagomizer.annotations.document_id = tq_tagomizer.document.document_id " +
			"where tq_tagomizer.annotations.language = 'en' AND to_tsvector('english', tq_tagomizer.annotations.text) @@ phraseto_tsquery('english', ?) "+
			"ORDER BY tq_tagomizer.document.title ASC LIMIT ? OFFSET ?";


	////////////////////////
	// Triples
	////////////////////////
	public static final String LIST_TRIPLES =
			"SELECT  document_id, subject, predicate,object from tq_tagomizer.triples " +
					"ORDER BY tq_tagomizer.triples.document_id ASC LIMIT ? OFFSET ?";


}
