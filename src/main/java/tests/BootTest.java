/**
 * 
 */
package tests;

import org.topicquests.ks.hypothesis.HypothesisHarvesterEnvironment;

/**
 * @author jackpark
 *
 */
public class BootTest {
	private HypothesisHarvesterEnvironment environment;

	/**
	 * 
	 */
	public BootTest() {
		environment = new HypothesisHarvesterEnvironment();
		System.out.println("A "+environment.getProperties());
		environment.shutDown();
		System.exit(0);
	}

}
