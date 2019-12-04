/**
 * 
 */
package tests;

import org.topicquests.pg.api.IPostgresConnection;
import org.topicquests.support.ResultPojo;
import org.topicquests.support.api.IResult;

/**
 * @author jackpark
 *
 */
public class SearchTest extends TestRoot {
	private final String Q = "cardiovascular disease";
	
	/**
	 * 
	 */
	public SearchTest() {
		IPostgresConnection conn = null;
		IResult r = new ResultPojo();
		try {
			 conn = provider.getConnection();
		     conn.setProxyRole(r);
		     IResult rx = pivotSuite.textSearchByQuery(conn, r, Q);
		     System.out.println("A "+rx.getResultObject());
		} catch (Exception e) {
			environment.logError(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			conn.closeConnection(r);
		}
		environment.shutDown();
		System.exit(0);
		
	}

}
