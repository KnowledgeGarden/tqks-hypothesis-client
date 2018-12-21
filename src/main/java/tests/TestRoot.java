/**
 * 
 */
package tests;

import org.topicquests.ks.hypothesis.HypothesisClient;
import org.topicquests.ks.hypothesis.HypothesisHarvesterEnvironment;

/**
 * @author jackpark
 * Extend this class for tests
 */
public class TestRoot {
	protected HypothesisHarvesterEnvironment environment;
	protected HypothesisClient client;
	/**
	 * 
	 */
	public TestRoot() {
		environment = new HypothesisHarvesterEnvironment();
		client = environment.getClient();
	}

}
