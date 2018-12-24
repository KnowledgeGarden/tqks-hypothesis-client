/**
 * 
 */
package tests;

import org.topicquests.support.api.IResult;

import net.minidev.json.JSONObject;

/**
 * @author jackpark
 *
 */
public class FirstProcessorTest extends TestRoot {

	/**
	 * 
	 */
	public FirstProcessorTest() {
		IResult r = client.loadSomeAnnotations();
		JSONObject jo = (JSONObject)r.getResultObject();
		System.out.println("A "+r.getErrorString());
		System.out.println("B "+jo);
		processor.processJSON(jo);
		environment.shutDown();
		System.exit(0);
	}

}
//NumRows 20 | 143
//Note: exterior array size does not == total number of annotations
//JX {"hidden":false,"created":"2018-12-15T16:16:12.225402+00:00","document":{"title":["Study shows magnesium optimizes vitamin D status"]},"uri":"https:\/\/medicalxpress.com\/news\/2018-12-magnesium-optimizes-vitamin-d-status.html","target":[{"selector":[{"endOffset":426,"startOffset":0,"endContainer":"\/article[1]\/div[1]\/p[3]","type":"RangeSelector","startContainer":"\/article[1]\/div[1]\/p[3]"},{"start":2950,"end":3376,"type":"TextPositionSelector"},{"prefix":"3098146&avms=ampa\"}}\n\t\t\t\t\t\n\t\n\t\t\t","exact":"The study reported in the December issue of The American Journal of Clinical Nutrition is important because of controversial findings from ongoing research into the association of vitamin D levels with colorectal cancer and other diseases, including a recent report from the VITAL trial. It gave confirmation to a prior observational study in 2013 by the researchers that linked low magnesium levels with low vitamin D levels.","type":"TextQuoteSelector","suffix":"\nThe trial also revealed somethi"}],"source":"https:\/\/medicalxpress.com\/news\/2018-12-magnesium-optimizes-vitamin-d-status.html"}],"tags":["Magnesium","Vitamin D"],"flagged":false,"user_info":{"display_name":null},"permissions":{"read":["group:n9iXjarQ"],"admin":["acct:Gardener@hypothes.is"],"update":["acct:Gardener@hypothes.is"],"delete":["acct:Gardener@hypothes.is"]},"links":{"incontext":"https:\/\/hyp.is\/vU6pMACEEem9PdtjGwIgQw\/medicalxpress.com\/news\/2018-12-magnesium-optimizes-vitamin-d-status.html","json":"https:\/\/hypothes.is\/api\/annotations\/vU6pMACEEem9PdtjGwIgQw","html":"https:\/\/hypothes.is\/a\/vU6pMACEEem9PdtjGwIgQw"},"text":"","id":"vU6pMACEEem9PdtjGwIgQw","updated":"2018-12-15T16:16:12.225402+00:00","user":"acct:Gardener@hypothes.is","group":"n9iXjarQ"}

/*
 * 
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
*/
