/**
 * 
 */
package org.topicquests.ks.tagomizer;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.topicquests.support.api.IResult;

/**
 * @author jackpark
 *
 */
public class BaseHttpClient {
	protected TagomizerClientEnvironment environment;
	protected CloseableHttpClient client;

	/**
	 * 
	 */
	public BaseHttpClient(TagomizerClientEnvironment env) {
		environment = env;
		client = HttpClients.createDefault();
	}
	

}
