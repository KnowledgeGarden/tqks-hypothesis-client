/**
 * 
 */
package tests;

import org.topicquests.support.ResultPojo;
import org.topicquests.support.api.IResult;

/**
 * @author jackpark
 *
 */
public class UserPivotTest extends TestRoot {
	private final String UID = "Gardener@hypothes.is";
	/**
	 * 
	 */
	public UserPivotTest() {
		IResult r = pivotSuite.listPivotsByUser(UID, 0, 10);
	    System.out.println("A "+r.getResultObject());
		environment.shutDown();
		System.exit(0);

	}

}
/**
{
	"documents": [{
		"docId": "u-_FIq2rEembBhsSDPirhg",
		"title": "",
		"url": "https:\/\/www.cghjournal.org\/article\/S1542-3565(08)00298-X\/pdf"
	}, {
		"docId": "klZsGCGVEemSQq-EVLvgXA",
		"title": "%%title%% | Garvan Institute of Medical Research",
		"url": "https:\/\/www.garvan.org.au\/"
	}, {
		"docId": "m9OHuEgOEemXlounhz5Phw",
		"title": "(18) (PDF) The Case for Alzheimer\u2019s Disease as Type 3 Diabetes",
		"url": "https:\/\/www.researchgate.net\/publication\/326699884_The_Case_for_Alzheimer's_Disease_as_Type_3_Diabetes"
	}, {
		"docId": "_MCe2h88EemfxyMDElTjmw",
		"title": "(21) (PDF) Wind and water: Feng Shui as complexity science",
		"url": "https:\/\/www.researchgate.net\/publication\/330554330_Wind_and_water_Feng_Shui_as_complexity_science"
	}, {
		"docId": "QrqcPCSsEemgH6MwvwvvSA",
		"title": "20150425-IoF_Framework-Basic.pdf",
		"url": "http:\/\/internet-of-food.org\/files\/2015\/08\/20150425-IoF_Framework-Basic.pdf"
	}, {
		"docId": "lMxucllHEemP7gfh2WbSSQ",
		"title": "26S Proteasomes are rapidly activated by diverse hormones and physiological states that raise cAMP and cause Rpn6 phosphorylation",
		"url": "https:\/\/www.pnas.org\/content\/116\/10\/4228"
	}, {
		"docId": "5vtTSFlHEemxDcNPX_Fqmg",
		"title": "26S Proteasomes are rapidly activated by diverse hormones and physiological states that raise cAMP and cause Rpn6 phosphorylation",
		"url": "https:\/\/www.pnas.org\/content\/116\/10\/4228"
	}, {
		"docId": "3I6nsBzkEemiSxfO-VkrMg",
		"title": "360_10755life0904_2431_2440.pdf",
		"url": "http:\/\/www.lifesciencesite.com\/lsj\/life0904\/360_10755life0904_2431_2440.pdf"
	}, {
		"docId": "JS3IxCGbEemtnt9yySHcpg",
		"title": "801267 1..3",
		"url": "https:\/\/www.nature.com\/articles\/0801267.pd"
	}, {
		"docId": "7_ZJNL4fEemlSz9pCN6Zxg",
		"title": "A New Clue to How Life Originated",
		"url": "https:\/\/www.theatlantic.com\/science\/archive\/2019\/08\/interlocking-puzzle-allowed-life-emerge\/595945\/"
	}],
	"groups": ["nkEJ7KNe", "6xkx19i3", "Y7qn8kQD"],
	"tags": [{
		"label": "10000 Steps",
		"id": "10000_steps"
	}, {
		"label": "26S Proteasome Activity",
		"id": "26s_proteasome_activity"
	}, {
		"label": "4400 Steps",
		"id": "4400_steps"
	}, {
		"label": "5-8Hz",
		"id": "5-8hz"
	}, {
		"label": "5-HT",
		"id": "5-ht"
	}, {
		"label": "5-hydroxytryptamine",
		"id": "5-hydroxytryptamine"
	}, {
		"label": "72 KDa Type IV Collagenase",
		"id": "72_kda_type_iv_collagenase"
	}, {
		"label": "7500 Steps",
		"id": "7500_steps"
	}, {
		"label": "ABB",
		"id": "abb"
	}, {
		"label": "AD",
		"id": "ad"
	}]
} 
 */
