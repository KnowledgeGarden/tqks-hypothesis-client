/**
 * 
 */
package org.topicquests.ks.hypothesis;
import java.util.*;

import org.topicquests.ks.hypothesis.api.IAnalyzerListener;

import net.minidev.json.JSONObject;

/**
 * @author jackpark
 *
 */
public class Analyzer {
	private HypothesisHarvesterEnvironment environment;
	private IAnalyzerListener listener;
	private List<JSONObject> annotations;
	private boolean isRunning = true;
	private Worker thread;
	private Set<String> users;
	private Set<String> resources;
	private Set<String> tags;

	/**
	 * 
	 */
	public Analyzer(HypothesisHarvesterEnvironment env, IAnalyzerListener l) {
		environment = env;
		listener = l;
		annotations = new ArrayList<JSONObject>();
		users = new HashSet<String>();
		resources = new HashSet<String>();
		tags = new HashSet<String>();

		thread = new Worker();
		thread.start();
	}
	
	/**
	 * Deal with the  users/resources/tags collections
	 */
	public void finishHarvest() {
		listener.acceptMeta(this.users, this.resources, this.tags);
	}
	/**
	 * Adds between 1 and 20 annotations per <code>jo</code>
	 * @param jo
	 */
	public void addAnnotation(JSONObject jo) {
		synchronized(annotations) {
			System.out.println("ADDING "+jo);
			annotations.add(jo);
			annotations.notify();
		}
	}

	public void shutDown() {
		synchronized(annotations) {
			System.out.println("Analyzer Shutting Down");
			isRunning = false;
			annotations.notify();
		}
	}
	
	/**
	 * Split out individual annotations
	 * {
			"hidden": false,
			"created": "2018-12-15T16:16:12.225402+00:00",
			"document": {
				"title": ["Study shows magnesium optimizes vitamin D status"]
			},
			"uri": "https:\/\/medicalxpress.com\/news\/2018-12-magnesium-optimizes-vitamin-d-status.html",
			"target": [{
				"selector": [{
					"endOffset": 426,
					"startOffset": 0,
					"endContainer": "\/article[1]\/div[1]\/p[3]",
					"type": "RangeSelector",
					"startContainer": "\/article[1]\/div[1]\/p[3]"
				}, {
					"start": 2950,
					"end": 3376,
					"type": "TextPositionSelector"
				}, {
					"prefix": "3098146&avms=ampa\"}}\n\t\t\t\t\t\n\t\n\t\t\t",
					"exact": "The study reported in the December issue of The American Journal of Clinical Nutrition is important because of controversial findings from ongoing research into the association of vitamin D levels with colorectal cancer and other diseases, including a recent report from the VITAL trial. It gave confirmation to a prior observational study in 2013 by the researchers that linked low magnesium levels with low vitamin D levels.",
					"type": "TextQuoteSelector",
					"suffix": "\nThe trial also revealed somethi"
				}],
				"source": "https:\/\/medicalxpress.com\/news\/2018-12-magnesium-optimizes-vitamin-d-status.html"
			}],
			"tags": ["Magnesium", "Vitamin D"],
			"flagged": false,
			"user_info": {
				"display_name": null
			},
			"permissions": {
				"read": ["group:n9iXjarQ"],
				"admin": ["acct:Gardener@hypothes.is"],
				"update": ["acct:Gardener@hypothes.is"],
				"delete": ["acct:Gardener@hypothes.is"]
			},
			"links": {
				"incontext": "https:\/\/hyp.is\/vU6pMACEEem9PdtjGwIgQw\/medicalxpress.com\/news\/2018-12-magnesium-optimizes-vitamin-d-status.html",
				"json": "https:\/\/hypothes.is\/api\/annotations\/vU6pMACEEem9PdtjGwIgQw",
				"html": "https:\/\/hypothes.is\/a\/vU6pMACEEem9PdtjGwIgQw"
			},
			"text": "",
			"id": "vU6pMACEEem9PdtjGwIgQw",
			"updated": "2018-12-15T16:16:12.225402+00:00",
			"user": "acct:Gardener@hypothes.is",
			"group": "n9iXjarQ"
		}
	 * @param jo
	 */
	void processAnnotation(JSONObject jo) {
		JSONObject jx;
		List<JSONObject> ljo = null;
		try {
		System.out.println("Analyzing Annotation "+jo);
		String id = jo.getAsString("id");
		String created = jo.getAsString("created");
		JSONObject jt = (JSONObject)jo.get("document");
		List<String> tx = (List<String>)jt.get("title");
		String title = "";
		if (tx != null)
			title = tx.get(0); //TODO do we have more than one title?
		String user = jo.getAsString("user");
		user = user.substring(5);
		if (user != null && !user.equals(""))
			this.users.add(user);
		String text = jo.getAsString("text");
		String uri = jo.getAsString("uri");
		if (uri != null && !uri.equals(""))
			this.resources.add(uri);
		//debug
		if (uri.indexOf("biorxiv") > -1) {
			environment.logDebug("XXXX "+jo);
		}
		String group = jo.getAsString("group");
		ljo = (List<JSONObject>)jo.get("target");
		environment.logDebug("XXX "+ljo);
		String annotation = null;
		if (ljo != null) {
			jx = (JSONObject)ljo.get(0);
			ljo = (List<JSONObject>)jx.get("selector");
			environment.logDebug("LJO "+ljo);
			//NOTE: it is possible that there is no annotation
			// in which case, no "selector"
			if (ljo != null) {
				int where = 3;
				if (ljo.size() == 3)
					where = 2;
				else if (ljo.size() == 2)
					where = 1;
				jx = (JSONObject)ljo.get(where);
				annotation = jx.getAsString("exact");
			}
		}
		List<String> tgs= (List<String>)jo.get("tags");
		//if (uri.indexOf("biorxiv") > -1) {
		//	environment.logDebug("YYYY "+ljo);
		//}
		jx = new JSONObject();
		if (tgs != null && !tgs.isEmpty()) {
			jx.put("tags", tgs);
			this.tags.addAll(tgs);
		}
		//create a new object
		jx.put("id", id);
		jx.put("group", group);
		jx.put("uri", uri);
		jx.put("title", title);
		jx.put("annotation", annotation);
		jx.put("text", text);
		jx.put("created", created);
		jx.put("user", user);
		
		//we now have a processed object:
		// annotation, text note, tags, provenance
		// time to send it on its way for further processing
		//System.out.println("Analyzed Annotation "+jx);
		listener.acceptAnalyzedAnnotation(jx);
		} catch (Exception e) {
			environment.logError(e.getMessage()+" | "+ljo, e);
		}
	}
	
	class Worker extends Thread {
		
		public void run() {
			JSONObject jo = null;
			while (isRunning) {
				synchronized(annotations) {
					if (annotations.isEmpty()) {
						try {
							annotations.wait();
						} catch (Exception e) {}
					} else
						jo = annotations.remove(0);
				}
				if (isRunning && jo != null) {
					processAnnotation(jo);
					jo = null;
				}
			}
			System.out.println("AnalyzerWorker stopping");
		}
	}
}
