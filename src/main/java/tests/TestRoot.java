/**
 * 
 */
package tests;

import org.topicquests.ks.hypothesis.HypothesisClient;
import org.topicquests.ks.hypothesis.HypothesisHarvesterEnvironment;
import org.topicquests.ks.hypothesis.JSONProcessor;

/**
 * @author jackpark
 * Extend this class for tests
 */
public class TestRoot {
	protected HypothesisHarvesterEnvironment environment;
	protected HypothesisClient client;
	protected JSONProcessor processor;
	/**
	 * 
	 */
	public TestRoot() {
		environment = new HypothesisHarvesterEnvironment();
		client = environment.getClient();
		processor = environment.getProcessor();
	}

}
