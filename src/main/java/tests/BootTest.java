/**
 * 
 */
package tests;

import org.topicquests.ks.tagomizer.TagomizerClientEnvironment;

/**
 * @author jackpark
 *
 */
public class BootTest {
	private TagomizerClientEnvironment environment;

	/**
	 * 
	 */
	public BootTest() {
		environment = new TagomizerClientEnvironment();
		System.out.println("A "+environment.getProperties());
		environment.shutDown();
		System.exit(0);
	}

}
