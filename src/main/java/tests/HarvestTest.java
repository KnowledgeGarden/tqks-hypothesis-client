/**
 * 
 */
package tests;

import org.topicquests.ks.hypothesis.api.IAnalyzerListener;
import org.topicquests.support.api.IResult;
import org.topicquests.support.util.TextFileHandler;
import java.io.*;
import net.minidev.json.JSONArray;

/**
 * @author jackpark
 *
 */
public class HarvestTest extends TestRoot {

	/**
	 * 
	 */
	public HarvestTest() {
		IResult r = client.harvest();
		
		//saveResults(environment.getListener().getData());
	}
	
	void saveResults(JSONArray ja) {
		if (ja == null) return;
		String path = "test/"+System.currentTimeMillis()+".json";
		try {
			File f = new File(path);
			//FileOutputStream fos = new FileOutputStream(f);
			PrintWriter pw = new PrintWriter(f,"UTF-8");
			ja.writeJSONString(pw);
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
			environment.logError(e.getMessage(), e);
		}
		
	}

}
