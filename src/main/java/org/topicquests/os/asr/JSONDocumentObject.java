/*
 * Copyright 2018 TopicQuests Foundation
 *  This source code is available under the terms of the Affero General Public License v3.
 *  Please see LICENSE.txt for full license terms, including the availability of proprietary exceptions.
 */
package org.topicquests.os.asr;
import java.util.*;

import org.topicquests.ks.api.INodeTypes;
//import org.topicquests.hyperbrane.AuthorPojo;
//import org.topicquests.hyperbrane.PublicationPojo;
//import org.topicquests.hyperbrane.api.IAuthor;
//import org.topicquests.hyperbrane.api.IPublication;
//import org.topicquests.hyperbrane.api.IHarvestingOntology;
import org.topicquests.ks.api.ITQCoreOntology;

import net.minidev.json.JSONObject;


/**
 * @author park
 * cut-down version specific to Tagomizer
 */
public class JSONDocumentObject {
	public static final String
		_DOCID				= "id",
		_NODE_TYPE			= "type",
		_DATE_STRING		= "dateString",
		_PMID				= "pmid", //
		_PMCID				= "pmcid",
		_PUBMED_PREFIX 		= "PubMed",
		_TITLE				= "title",
		_CITATIONS			= "citations",
		_COPYRIGHT			= "cpyright",
		_ABSTRACT			= "abstract",
		_PARAGRAPH_LIST		= "paragraphs",
		_CONTENT			= "content",
		_LANGUAGE			= "language",
		_URL				= "url",
		_AUTHORS			= "authors",
		_PUBLICATION 		= "publication",
		_ISO_ABBREV			= "isoA",
		_EDITORS			= "editors",
		_CLUSTER_LOCATOR	= "clusterLocator",
		_CLUSTER_TITLE		= "clusterTitle",
		_CLUSTER_DATA_LIST	= "clusterDataList",
		_TAG_LIST			= "tagList",
		_SUBSTANCE_LIST		= "substList",
		_TFIDF_MAP			= "tfidfMap";
	
	private JSONObject data;
	
	//public JSONDocumentObject(JSONObject jo) {
	//	data = jo;
	//}
	/**
	 * @param userId
	 */
	public JSONDocumentObject(String userId) {
		data = new JSONObject();
		data.put(ITQCoreOntology.CREATOR_ID_PROPERTY, userId);
		setNodeType(INodeTypes.ANNOTATION_TYPE);
	}
	
	public JSONObject getData() {
		return data;
	}
	
	public void setDocumentId(String id) {
		data.put(_DOCID, id);
	}
	
	public String getDocumentId() {
		return data.getAsString(_DOCID);
	}
	
	public void setNodeType(String type) {
		data.put(_NODE_TYPE, type);
	}
	
	public String getNodeType() {
		return data.getAsString(_NODE_TYPE);
	}
	
	public void setDateString(String date) {
		data.put(_DATE_STRING, date);
	}
	
	public String getDateString() {
		return data.getAsString(_DATE_STRING);
	}
	
	public void setDocumentTitle(String title) {
		data.put(_TITLE, title);
	}
	
	public String getDocumentTitle() {
		return data.getAsString(_TITLE);
	}

	/**
	 * For pubmed docs
	 * @param pmid
	 */
	public void setPMID(String pmid) {
		data.put(_PMID, pmid);
		setLocator(_PUBMED_PREFIX+pmid);
	}
	
	/**
	 * For pubmed docs with a PMC document
	 * @return
	 */
	public String getPMID() {
		return data.getAsString(_PMID);
	}
	
	public void setPMCID(String pmid) {
		data.put(_PMCID, pmid);
	}
	
	public String getPMCID() {
		return data.getAsString(_PMCID);
	}
	/**
	 * Set the document's topic <em>locator</em>
	 * @param locator
	 */
	public void setLocator(String locator) {
		data.put(ITQCoreOntology.LOCATOR_PROPERTY, locator);
	}
	/**
	 * Return the document's topic <em>locator</em>
	 * @return can return <code>null</code>
	 */
	public String getLocator() {
		String result = data.getAsString(ITQCoreOntology.LOCATOR_PROPERTY);
		if (result == null)
			result = data.getAsString("locator"); // old version
		return result;
	}
	
	public void setPublicationISOAbbreviation(String a) {
		data.put(_ISO_ABBREV, a);
	}
	
	public String getPublicationISOAbbreviation() {
		return data.getAsString(_ISO_ABBREV);
	}
	
	public void setCopyright(String copyright) {
		data.put(_COPYRIGHT, copyright);
	}
	
	public String getCopyright() {
		return data.getAsString(_COPYRIGHT);
	}
	public void setTagList(List<String> tags) {
		data.put(_TAG_LIST, tags);
	}
	public void addTag(String t) {
		List<String>l = (List<String>)data.get(_TAG_LIST);
		if (l == null)
			l = new ArrayList<String>();
		if (!l.contains(t)) {
			l.add(t);
			data.put(_TAG_LIST,l);
		}
	}
/*
	public void addKeyword(String t) {
		List<String>l = (List<String>)data.get(_KEYWORD_LIST);
		if (l == null)
			l = new ArrayList<String>();
		if (!l.contains(t)) {
			l.add(t);
			data.put(_KEYWORD_LIST,l);
		}
	}
	public List<String> listKeywords() {
		return (List<String>)data.get(_KEYWORD_LIST);
	}
*/
	public void addSubstance(String t) {
		
		List<String>l = (List<String>)data.get(_SUBSTANCE_LIST);
		if (l == null)
			l = new ArrayList<String>();
		if (!l.contains(t)) {
			l.add(t);
			data.put(_SUBSTANCE_LIST,l);
		}
	}
	public List<String> listSubstances() {
		return (List<String>)data.get(_SUBSTANCE_LIST);
	}

	/**
	 * Can return <code>null</code>
	 * @return
	 */
	public List<String> listTags() {
		return (List<String>)data.get(_TAG_LIST);
	}
	
	public void addParagraph(String para, String languge) {
		JSONObject p = new JSONObject();
		p.put("text", para);
		p.put("lang", languge);
		List<JSONObject> l = listParagraphs();
		if (l == null) l = new ArrayList<JSONObject>();
		l.add(p);
		data.put(_PARAGRAPH_LIST, l);

	}
	
	public List<JSONObject> listParagraphs() {
		return (List<JSONObject>)data.get(_PARAGRAPH_LIST);
	}
	/**
	 * Return userId
	 * @return
	 */
	public String getUserId() {
		return data.getAsString(ITQCoreOntology.CREATOR_ID_PROPERTY);
	}
	
	/**
	 * Metadata for the {@link IDocument}
	 * @param title
	 */
	public void setClusterTitle(String title) {
		data.put(_CLUSTER_TITLE, title);
	}
	
	public String getClusterTitle() {
		return data.getAsString(_CLUSTER_TITLE);
	}
	
	/**
	 * Metadata for the {@link IDocument}
	 * @param title
	 */
	//public void setClusterQuery(String title) {
	//	data.put(_CLUSTER_QUERY, title);
	//}
	
/*	public void addClusterData(String clusterLocator, String query, String clusterPhrase, String clusterScore) {
		Map<String,String>m = new HashMap<String,String>();
		m.put(_CLUSTER_LOCATOR, clusterLocator);
		m.put(IHarvestingOntology.CLUSTER_QUERY, query);
		m.put(_CLUSTER_TITLE, clusterPhrase);
		m.put(IHarvestingOntology.CLUSTER_WEIGHT, clusterScore);
		List<Map<String,String>>l = (List<Map<String,String>>)data.get(_CLUSTER_DATA_LIST);
		if (l == null)
			l = new ArrayList<Map<String,String>>();
		l.add(m);
		data.put(_CLUSTER_DATA_LIST, l);
	}
	
	public String getClusterQuery() {
		return data.getAsString(IHarvestingOntology.CLUSTER_QUERY);
	}
	
	public String getClusterWeight() {
		return data.getAsString(IHarvestingOntology.CLUSTER_WEIGHT);
	} */
	/**
	 * The full text to harvest
	 * @param content
	 * @param language defaults to "en"
	 */
	public void setContent(String content, String language) {
		data.put(_CONTENT, content);
		if (language != null)
			data.put(_LANGUAGE, language);
		else
			data.put(_LANGUAGE, "en");

	}
	
	
	/**
	 * Text of a document's abstract
	 * @param abs
	 */
	public void setAbstract(String abs) {
		data.put(_ABSTRACT, abs);
	}
	public void addDocAbstract(String a) {
		String ab = this.getAbstract();
		if (ab == null)
			setAbstract(a);
		else
			setAbstract(ab+" "+a);
	}

	public String getAbstract() {
		return data.getAsString(_ABSTRACT);
	}
	public String getLanguage() {
		return data.getAsString(_LANGUAGE);
	}
	
	public void setLanguage(String lang) {
		data.put(_LANGUAGE, lang);
	}
	public void setTFIDFData(SortedMap<Double,String>d) {
		data.put(_TFIDF_MAP, d);
	}
	
	public SortedMap<Double,String> getTFIDFData(Comparator c) {
		JSONObject jo = (JSONObject)data.get(_TFIDF_MAP);
		if (jo == null)
			return null;
		SortedMap<Double,String>result = new TreeMap(c);
		Iterator<String>itr = jo.keySet().iterator();
		String d;
		while (itr.hasNext()) {
			d = itr.next();
			result.put(new Double(d),(String)jo.get(d));
		}
		return result;
	}
	/**
	 * Return the content
	 * @return
	 */
	public String getContent() {
		return data.getAsString(_CONTENT);
	}
	
	public void setURL(String url) {
		data.put(_URL, url);
	}
	
	/**
	 * Return url or empty string
	 * @return
	 */
	public String getURL() {
		String result = data.getAsString(_URL);
		if (result == null)
			result = "";
		return result;
	}
	
	public void setPublication(String title, String publicationName,
			String volume, String number, String pages, String date, String year,
			String publisherName, String publisherLocation,
			String doi, String issn, String publicationType, String isoAbbreviation) {
/*		IPublication p = new PublicationPojo();
		if (title != null && !title.equals(""))
			p.setTitle(title);
		if (publicationName != null && !publicationName.equals(""))
			p.setPublicationName(publicationName);
		if (volume != null && !volume.equals(""))
			p.setPubicationVolume(volume);
		if (number != null && !number.equals(""))
			p.setPublicationNumber(number);
		if (pages != null && !pages.equals(""))
			p.setPages(pages);
		if (date != null && !date.equals(""))
			p.setPublicationDate(date);
		if (year != null && !year.equals(""))
			p.setPublicationYear(year);
		if (publisherName != null && !publisherName.equals(""))
			p.setPublisherName(publisherName);
		if (publisherLocation != null && !publisherLocation.equals(""))
			p.setPublisherLocation(publisherLocation);
		if (doi != null && !doi.equals(""))
			p.setDOI(doi);
		if (issn != null && !issn.equals(""))
			p.setISSN(issn);
		if (isoAbbreviation != null && !isoAbbreviation.equals(""))
			p.setISOAbbreviation(isoAbbreviation);
		setPublication(p);*/
	}
	
/*	public void setPublication(IPublication p) {
		data.put(_PUBLICATION, p);
	}
	
	public IPublication getPublication() {
		return (IPublication)data.get(_PUBLICATION);
	}*/

	public String toJSONString() {
		return data.toJSONString();
	}
	
	/**
	 * Citations I make of other documents
	 * @param t
	 */
	public void addCitation(String t) {
		List<String>l = (List<String>)data.get(_CITATIONS);
		if (l == null)
			l = new ArrayList<String>();
		l.add(t);
		data.put(_CITATIONS,l);
	}
	
	public List<String> listCitations() {
		return (List<String>)data.get(_CITATIONS);
	}
	
	/**
	 * 
	 * @param title
	 * @param initials
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param suffix e.g. jr, sr, II, III, ...
	 * @param degree e.g. M.D., PhD, ..
	 * @param fullName
	 * @param authorLocator
	 * @param publicationName
	 * @param publicationLocator
	 * @param publisherName
	 * @param publisherLocator
	 * @param affiliationName
	 * @param affiliationLocator
	 * @param funderName
	 * @param funderLocator
	 * @param fundingContractId
	 */
/*	public IAuthor addAuthor(String title, String initials, String firstName, String middleName, String lastName,
						  String suffix, String degree, String fullName, String authorLocator, 
						  String publicationName, String publicationLocator, 
						  String publisherName, String publisherLocator, 
						  String affiliationName, String affiliationLocator) {
		IAuthor a = new AuthorPojo();
		if (title != null && !title.equals(""))
			a.setAuthorTitle(title);
		if (initials != null && !initials.equals(""))
			a.setAuthorInitials(initials);
		if (firstName != null && !firstName.equals(""))
			a.addAuthorFirstName(firstName);
		if (middleName != null && !middleName.equals(""))
			a.setAuthorMiddleName(middleName);
		if (lastName != null && !lastName.equals(""))
			a.setAuthorLastName(lastName);
		if (suffix != null && !suffix.equals(""))
			a.setAuthorSuffix(suffix);
		if (degree != null && !degree.equals(""))
			a.setAuthorDegree(degree);
		if (fullName != null && !fullName.equals(""))
			a.setAuthorFullName(fullName);
		if (authorLocator != null && !authorLocator.equals(""))
			a.setAuthorLocator(authorLocator);
		if (publicationName != null && !publicationName.equals(""))
			a.setPublicationName(publicationName);
		if (publicationLocator != null && !publicationLocator.equals(""))
			a.setPublicationLocator(publicationLocator);
		if (publisherName != null && !publisherName.equals(""))
			a.setPublisherName(publisherName);
		if (publisherLocator != null && !publisherLocator.equals(""))
			a.setPublisherLocator(publisherLocator);
		if (affiliationName != null && !affiliationName.equals(""))
			a.addAffiliationName(affiliationName);
		if (affiliationLocator != null && !affiliationLocator.equals(""))
			a.setAffiliationLocator(affiliationLocator);
		this.addAuthor(a);
		return a;
	}	
	
	public void updateAuthor(IAuthor author) {
		
	}
	public void addAuthor(IAuthor author) {
		List<IAuthor>a = this.listAuthors();
		if (a == null)
			a = new ArrayList<IAuthor>();
		a.add(author);
		this.setAuthorList(a);
	}

	public void setAuthorList(List<IAuthor>authors) {
		data.put(_AUTHORS, authors);
	}
	/**
	 * List authors
	 * @return can return <code>null</code>
	 * /
	public List<IAuthor> listAuthors() {
		return (List<IAuthor>)data.get(_AUTHORS);
	}	
*/

}
