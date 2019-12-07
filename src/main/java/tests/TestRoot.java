/**
 * 
 */
package tests;

import org.topicquests.ks.tagomizer.HypothesisClient;
import org.topicquests.ks.tagomizer.TagomizerClientEnvironment;
import org.topicquests.ks.tagomizer.JSONProcessor;
import org.topicquests.ks.tagomizer.PivotSuite;
import org.topicquests.pg.PostgresConnectionFactory;

/**
 * @author jackpark
 * Extend this class for tests
 */
public class TestRoot {
	protected TagomizerClientEnvironment environment;
	protected HypothesisClient client;
	protected JSONProcessor processor;
	protected PivotSuite pivotSuite;
	protected PostgresConnectionFactory provider;

	/**
	 * 
	 */
	public TestRoot() {
		environment = new TagomizerClientEnvironment();
		client = environment.getClient();
		processor = environment.getProcessor();
		pivotSuite = environment.getPivotSuite();
		provider = environment.getProvider();
	}

}
