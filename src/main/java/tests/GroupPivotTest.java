/**
 * 
 */
package tests;

import org.topicquests.support.api.IResult;

/**
 * @author jackpark
 *
 */
public class GroupPivotTest extends TestRoot {
	private final String GID = "6xkx19i3";

	/**
	 * 
	 */
	public GroupPivotTest() {
		IResult r = pivotSuite.listPivotsByGroup(GID, 0, 10);
	    System.out.println("A "+r.getResultObject());
		environment.shutDown();
		System.exit(0);
	}

}
