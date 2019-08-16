/**
 * 
 */
package org.topicquests.ks.hypothesis;

import java.io.File;

import org.topicquests.es.ProviderEnvironment;
import org.topicquests.ks.hypothesis.api.IAnalyzerListener;
import org.topicquests.pg.PostgresConnectionFactory;
import org.topicquests.support.RootEnvironment;
import org.topicquests.support.util.TextFileHandler;

/**
 * @author jackpark
 *
 */
public class HypothesisHarvesterEnvironment extends RootEnvironment {
	private final String CURSOR_FILE = "Cursor";
	private HypothesisClient client;
	private JSONProcessor processor;
	//private RealtimeSocket socket;
	private File cursorFile;
	private long cursor = 0;
	private Analyzer analyzer;
	private IAnalyzerListener listener;
	private TextFileHandler h;
	private ProviderEnvironment esProvider;  // Elasticsearch provider
	private PostgresConnectionFactory provider;
	private PivotModel2 pivotModel;
	/**
	 * 
	 */
	public HypothesisHarvesterEnvironment() {
		super("harvester-props.xml", "logger.properties");
		client = new HypothesisClient(this);
	    esProvider = new ProviderEnvironment();
	    String dbName = getStringProperty("DatabaseName");
	    String schema = getStringProperty("DatabaseSchema");
	    provider = new PostgresConnectionFactory(dbName, schema);
	    pivotModel = new PivotModel2(this);
		listener = new AnalyzerListener(this);
		analyzer = new Analyzer(this, listener);
		processor = new JSONProcessor(this, analyzer);
		client.setProcessor(processor);
		//socket = new RealtimeSocket(this);
		h = new TextFileHandler();
		startCursor();
	}

	public PivotModel2 getPivotModel() {
		return pivotModel;
	}
	public PostgresConnectionFactory getProvider() {
		return provider;
	}
	/**
	 * Return the ElasticSearch Environment
	 * @return
	 */
	public ProviderEnvironment getElasticSearchProvider() {
		return esProvider;
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
	 * @return
	 */
	public long getCursor() {
		return cursor;
	}
	
	public void updateCursor(long newCursor) {
		cursor = newCursor;
		//save it
		saveCursor();
	}
	
	private void startCursor() {
		cursorFile = new File(CURSOR_FILE);
		if (cursorFile.exists()) {
			String s = h.readFile(cursorFile);
			if (s != null) {
				cursor = Long.parseLong(s);
			} else
				cursor = 0;
		} else {
			cursor = 0;
		}
	}
	
	private void saveCursor() {
		if (cursorFile != null) {
			h.writeFile(cursorFile, Long.toString(cursor));
		} else {
			h.writeFile(CURSOR_FILE, Long.toString(cursor));
		}
	}
	
	public void shutDown() {
		System.out.println("Shutting down");
		saveCursor();
		analyzer.shutDown();
	}
}
