/**
 * 
 */
package org.topicquests.ks.hypothesis;

import java.io.File;

import org.topicquests.ks.hypothesis.api.IAnalyzerListener;
import org.topicquests.pg.PostgresConnectionFactory;
import org.topicquests.support.RootEnvironment;
import org.topicquests.support.util.TextFileHandler;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;

/**
 * @author jackpark
 *
 */
public class HypothesisHarvesterEnvironment extends RootEnvironment {
	private final String CURSOR_FILE = "Cursor.json";
	private HypothesisClient client;
	private JSONProcessor processor;
	private JSONObject cursors;

	private File cursorFile;
	private Analyzer analyzer;
	private IAnalyzerListener listener;
	private TextFileHandler h;
	private PostgresConnectionFactory provider;
	private PivotModel2 pivotModel;
	
	/**
	 * 
	 */
	public HypothesisHarvesterEnvironment() {
		super("harvester-props.xml", "logger.properties");
		h = new TextFileHandler();
		try {
			startCursor();
		} catch (Exception e) {
			// bombed trying to start cursor
			throw new RuntimeException(e);
		}
	    String dbName = getStringProperty("DatabaseName");
	    String schema = getStringProperty("DatabaseSchema");
	    
	    provider = new PostgresConnectionFactory(dbName, schema);
		client = new HypothesisClient(this);
	    pivotModel = new PivotModel2(this);
		listener = new AnalyzerListener(this);
		analyzer = new Analyzer(this, listener);
		processor = new JSONProcessor(this, analyzer);
		client.setProcessor(processor);
	}

	public PivotModel2 getPivotModel() {
		return pivotModel;
	}
	public PostgresConnectionFactory getProvider() {
		return provider;
	}
	
	/**
	 * Return processor which handles annotation downloads
	 * @return
	 */
	public JSONProcessor getProcessor() {
		return processor;
	}
	
	public IAnalyzerListener getListener() {
		return listener;
	}
	/**
	 * Return client which performs bulk annotation downloads
	 * @return
	 */
	public HypothesisClient getClient() {
		return client;
	}
	
	/**
	 * Polling requires a cursor which must be persistent
	 * @param groupId TODO
	 * @return
	 */
	public long getCursor(String groupId) {
		Number n = cursors.getAsNumber(groupId);
		if (n != null)
			return n.longValue();
		return 0;
	}
	
	public void updateCursor(long newCursor, String groupId) {
		logDebug("UPDATECURSORS "+newCursor+" "+groupId+"\n"+cursors);
		cursors.put(groupId, new Long(newCursor));
		//save it
		saveCursor();
	}
	
	private void startCursor() throws Exception {
		cursorFile = new File(CURSOR_FILE);
		if (cursorFile.exists()) {
			String s = h.readFile(cursorFile);
			if (s != null) {
				JSONParser p = new JSONParser(JSONParser.MODE_JSON_SIMPLE);
				cursors = (JSONObject)p.parse(s);
			} else
				cursors = new JSONObject();
		} else {
			cursors = new JSONObject();
		}
		System.out.println("ABC "+cursors);
	}
	
	private void saveCursor() {
		logDebug("SAVECURSORS "+cursorFile+"\n"+cursors);
		if (cursorFile != null) {
			h.writeFile(cursorFile, cursors.toJSONString());
		} else {
			h.writeFile(CURSOR_FILE, cursors.toJSONString());
		}
	}
	
	public void shutDown() {
		System.out.println("Shutting down");
		saveCursor();
		analyzer.shutDown();
	}
}
