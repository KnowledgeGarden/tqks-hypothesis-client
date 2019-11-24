/**
 * 
 */
package org.topicquests.ks.hypothesis.api;

/**
 * @author jackpark
 *
 */
public interface ISQL {

	///////////////////////////
	// These are for used in PivotModel2
	///////////////////////////

	public static final String INSERT_TAG_REF =
			"INSERT  into tq_tagomizer.tag_ref VALUES ( ?, ?, ?) ON CONFLICT DO NOTHING";
	
	
	public static final String SELECT_DOC_ID_BY_URL_GROUP =
			"SELECT document_id FROM tq_tagomizer.document WHERE url=? AND group_id=?";
	
	public static final String INSERT_REFERENCE =
			"INSERT  into tq_tagomizer.reference VALUES ( ?, ?) ON CONFLICT DO NOTHING";
	
	public static final String INSERT_DOCUMENT =
			"INSERT  into tq_tagomizer.document (document_id, url, title, created, group_id, user_id) VALUES ( ?, ? ) ON CONFLICT DO NOTHING";
	
	public static final String INSERT_USER =
			"INSERT  into tq_tagomizer.huser (id, document_id, group_id) VALUES ( ?, ?, ? ) ON CONFLICT DO NOTHING";
	
	public static final String INSERT_TAG =
			"INSERT  into tq_tagomizer.tag VALUES ( ?, ?, ? ) ON CONFLICT DO NOTHING";
	
	public static final String INSERT_GROUP =
			"INSERT  into tq_tagomizer.groups (name) VALUES ( ?, ? ) ON CONFLICT DO NOTHING";

	///////////////////////////
	// These are for testing code for the backside server
	///////////////////////////
	/**
	 * Gather Annotations by URL
	 */
	public static final String GATHER_RESOURCE_BY_URL = 
			"SELECT text from tq_tagomizer.annotations where document_id IN "+
			"( SELECT document_id from tq_tagomizer.documents where url=?)";
	
	/**
	 * Gather Resources (documents) by Tag
	 */
	public static final String GATHER_RESOURCES_BY_TAG =
			"SELECT DISTINCT document_id, title from tq_tagomizer.document where document_id IN "+
			"( SELECT document_id from tq_tagomizer.tag_ref where tag_id=?)";
	// from JavalinHypothesis HypothesisDao
	public static final String GET_RESOURCES_BY_USER =
			"SELECT DISTINCT tq_tagomizer.document.url, tq_tagomizer.document.title FROM tq_tagomizer.document "+
					"JOIN tq_tagomizer.reference ON tq_tagomizer.document.id = tq_tagomizer.reference.document_id "+
					"JOIN tq_tagomizer.huser ON tq_tagomizer.reference.user_id = tq_tagomizer.huser.id "+
					"WHERE tq_tagomizer.huser.hyp_uid = ? " +
					"ORDER BY tq_tagomizer.document.title ASC LIMIT ? OFFSET ?";
	
	public static final String GET_RESOURCES_BY_TAG =
			"SELECT DISTINCT tq_tagomizer.document.url, tq_tagomizer.document.title FROM tq_tagomizer.document "+
					"JOIN tq_tagomizer.reference ON tq_tagomizer.document.id = tq_tagomizer.reference.document_id "+
					"JOIN tq_tagomizer.tag_ref ON tq_tagomizer.reference.hyp_id = tq_tagomizer.tag_ref.ref_id "+
					"JOIN tq_tagomizer.tag ON tq_tagomizer.tag_ref.tag_id = tq_tagomizer.tag.id "+
					"WHERE tq_tagomizer.tag.name = ? " +
					"ORDER BY tq_tagomizer.document.title ASC LIMIT ? OFFSET ?";
	
	public static final String GET_USERS_BY_RESOURCE =
			"SELECT DISTINCT tq_tagomizer.huser.hyp_uid FROM tq_tagomizer.huser "+
					"JOIN tq_tagomizer.reference ON tq_tagomizer.huser.id = tq_tagomizer.reference.user_id "+
					"JOIN tq_tagomizer.document ON tq_tagomizer.reference.document_id = tq_tagomizer.document.id "+
					"WHERE tq_tagomizer.document.url = ? "+
					"ORDER BY tq_tagomizer.huser.hyp_uid ASC LIMIT ? OFFSET ?";
	
	public static final String GET_USERS_BY_TAG =
			"SELECT DISTINCT tq_tagomizer.huser.hyp_uid FROM tq_tagomizer.huser "+
					"JOIN tq_tagomizer.reference ON tq_tagomizer.huser.id = tq_tagomizer.reference.user_id "+
					"JOIN tq_tagomizer.document ON tq_tagomizer.reference.document_id = tq_tagomizer.document.id "+
					"JOIN tq_tagomizer.tag_ref ON tq_tagomizer.reference.hyp_id = tq_tagomizer.tag_ref.ref_id "+
					"JOIN tq_tagomizer.tag ON tq_tagomizer.tag_ref.tag_id = tq_tagomizer.tag.id "+
					"WHERE tq_tagomizer.tag.name = ? "+
					"ORDER BY tq_tagomizer.huser.hyp_uid ASC LIMIT ? OFFSET ?";
	
	public static final String GET_TAGS_BY_USER =
			"SELECT DISTINCT tq_tagomizer.tag.name FROM tq_tagomizer.tag "+
					"JOIN tq_tagomizer.tag_ref ON tq_tagomizer.tag.id = tq_tagomizer.tag_ref.tag_id "+
					"JOIN tq_tagomizer.reference ON tq_tagomizer.tag_ref.ref_id = tq_tagomizer.reference.hyp_id "+
					"JOIN tq_tagomizer.huser ON tq_tagomizer.reference.user_id = tq_tagomizer.huser.id "+
					"WHERE tq_tagomizer.huser.hyp_uid = ? "+
					"ORDER BY tq_tagomizer.tag.name ASC LIMIT ? OFFSET ?";

	public static final String GET_TAGS_BY_RESOURCE =
			"SELECT DISTINCT tq_tagomizer.tag.name FROM tq_tagomizer.tag "+
					"JOIN tq_tagomizer.tag_ref ON tq_tagomizer.tag.id = tq_tagomizer.tag_ref.tag_id "+
					"JOIN tq_tagomizer.reference ON tq_tagomizer.tag_ref.ref_id = tq_tagomizer.reference.hyp_id "+
					"JOIN tq_tagomizer.document ON tq_tagomizer.reference.document_id = tq_tagomizer.document.id "+
					"WHERE tq_tagomizer.document.url = ? "+
					"ORDER BY tq_tagomizer.tag.name ASC LIMIT ? OFFSET ?";
	
	public static final String GET_RESOURCE_PIVOT =
			"SELECT tq_tagomizer.reference.hyp_id from tq_tagomizer.reference "+
		    		"JOIN tq_tagomizer.document ON tq_tagomizer.reference.document_id = tq_tagomizer.document.id "+
		    		"WHERE tq_tagomizer.document.url = ?";

	//////////
	//TODO
	// Groups
	public static final String GET_USERS_BY_GROUP =
			"";

	public static final String GET_TAGS_BY_GROUP =
			"";

	public static final String GET_RESOURCES_BY_GROUP =
			"";


	
}
