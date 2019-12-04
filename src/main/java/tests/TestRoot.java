/**
 * 
 */
package tests;

import org.topicquests.ks.hypothesis.HypothesisClient;
import org.topicquests.ks.hypothesis.HypothesisHarvesterEnvironment;
import org.topicquests.ks.hypothesis.JSONProcessor;
import org.topicquests.ks.hypothesis.PivotSuite;
import org.topicquests.pg.PostgresConnectionFactory;

/**
 * @author jackpark
 * Extend this class for tests
 */
public class TestRoot {
	protected HypothesisHarvesterEnvironment environment;
	protected HypothesisClient client;
	protected JSONProcessor processor;
	protected PivotSuite pivotSuite;
	protected PostgresConnectionFactory provider;

	/**
	 * 
	 */
	public TestRoot() {
		environment = new HypothesisHarvesterEnvironment();
		client = environment.getClient();
		processor = environment.getProcessor();
		pivotSuite = environment.getPivotSuite();
		provider = environment.getProvider();
	}

}
