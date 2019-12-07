/**
 * 
 */
package tests;

import org.topicquests.pg.api.IPostgresConnection;
import org.topicquests.support.ResultPojo;
import org.topicquests.support.api.IResult;

/**
 * @author jackpark
 *
 */
public class SearchTest extends TestRoot {
	private final String Q = "cardiovascular disease";
	
	/**
	 * 
	 */
	public SearchTest() {
	     IResult rx = pivotSuite.listTextBySearch(Q, 0, 10);
	     System.out.println("A "+rx.getResultObject());
		environment.shutDown();
		System.exit(0);
		
	}

}
/*
[{
	"docId": "3I6nsBzkEemiSxfO-VkrMg",
	"label": "360_10755life0904_2431_2440.pdf"
}, {
	"docId": "zaQVivsvEemAugMVBerDOQ",
	"label": "Association between apolipoprotein E epsilon4 and sleep-disordered breathing in adults. - PubMed - NCBI"
}, {
	"docId": "jFwaIorEEemdi9cFvMOvPQ",
	"label": "CIAO Study \u2013 CIAO study"
}, {
	"docId": "jFwaIorEEemdi9cFvMOvPQ",
	"label": "CIAO Study \u2013 CIAO study"
}, {
	"docId": "q13jTHfSEemJ6iNyTlETaA",
	"label": "Fiber and Prebiotics: Mechanisms and Health Benefits"
}, {
	"docId": "hHs3nCltEeml95fmM454kw",
	"label": "Hunter\u2010gatherers as models in public health"
}, {
	"docId": "bOnwFDYGEemYI2-ykCRq6w",
	"label": "Nut Consumption in Relation to Cardiovascular Disease Incidence and Mortality among Patients with Diabetes Mellitus | Circulation Research"
}, {
	"docId": "1aCfmiGdEemWbjfEVarTtA",
	"label": "Obesity and adipokines: effects on sympathetic overactivity"
}, {
	"docId": "h81jSD6yEemfh2dlWejFTw",
	"label": "Primary Prevention of Cardiovascular Disease with a Mediterranean Diet Supplemented with Extra-Virgin Olive Oil or Nuts | NEJM"
}, {
	"docId": "jTi70GfTEemNfs8OIiASPA",
	"label": "Raw and Red-Hot"
}]
*/