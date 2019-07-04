/**
 * 
 */
package tests;

import java.util.List;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.topicquests.es.api.IClient;
import org.topicquests.es.api.IQueryDSL;
import org.topicquests.support.api.IResult;

import net.minidev.json.JSONObject;

/**
 * @author jackpark
 *
 */
public class ListTags extends TestRoot {
	private IQueryDSL dsl;
	private final String INDEX = "annotations";
	private IClient esClient;
	
	/**
	 * 
	 */
	public ListTags() {
		dsl = environment.getElasticSearchProvider().getQueryDSL();
		esClient = environment.getElasticSearchProvider().getProvider();
		SearchSourceBuilder bldr = new SearchSourceBuilder();
		bldr = bldr.from(10);
		bldr = bldr.size(99);
		SearchRequest query = new SearchRequest(INDEX);
		query = query.source(bldr);
		IResult r = esClient.listSearch(query, INDEX);
		System.out.println("A "+r.getErrorString());
		List<JSONObject> l = (List<JSONObject>)r.getResultObject();
		System.out.println("B "+l.size());
		environment.shutDown();
		System.exit(0);
	}

}
/**
A 
B []  that didn't work
 */
