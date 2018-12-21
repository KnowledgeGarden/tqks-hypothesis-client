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
	private JSONProcessor processor;
	private RealtimeSocket socket;
	/**
	 * 
	 */
	public HypothesisHarvesterEnvironment() {
		super("harvester-props.xml", "logger.properties");
		client = new HypothesisClient(this);
		processor = new JSONProcessor(this);
		socket = new RealtimeSocket(this);
	}

	/**
	 * Return a socket client-server for realtime monitoring annotation events
	 * @return
	 */
	public RealtimeSocket getSocket() {
		return socket;
	}
	
	/**
	 * Return processor which handles annotation downloads
	 * @return
	 */
	public JSONProcessor getProcessor() {
		return processor;
	}
	
	/**
	 * Return client which performs bulk annotation downloads
	 * @return
	 */
	public HypothesisClient getClient() {
		return client;
	}
	
	public void shutDown() {
		System.out.println("Shutting down");
	}
}
