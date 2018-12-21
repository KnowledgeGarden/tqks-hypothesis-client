/**
 * 
 */
package org.topicquests.ks.hypothesis;

import org.topicquests.support.RootEnvironment;

/**
 * @author jackpark
 *
 */
public class HypothesisHarvesterEnvironment extends RootEnvironment {
	private HypothesisClient client;
	/**
	 * 
	 */
	public HypothesisHarvesterEnvironment() {
		super("harvester-props.xml", "logger.properties");
		client = new HypothesisClient(this);
	}

	public HypothesisClient getClient() {
		return client;
	}
	
	public void shutDown() {
		System.out.println("Shutting down");
	}
}
