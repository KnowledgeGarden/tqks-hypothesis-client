/**
 * 
 */
package org.topicquests.ks.hypothesis;

import org.topicquests.pg.PostgresConnectionFactory;
import org.topicquests.support.ResultPojo;
import org.topicquests.support.api.IResult;

/**
 * @author jackpark
 *
 */
public class PivotSuite {
	private HypothesisHarvesterEnvironment environment;
	private PostgresConnectionFactory provider;

	/**
	 * 
	 */
	public PivotSuite(HypothesisHarvesterEnvironment env) {
		environment = env;
		provider = environment.getProvider();
	}
	
	public IResult listAllGroups() {
		IResult result = new ResultPojo();
		
		return result;
	}
	
	public IResult listAllUsers() {
		IResult result = new ResultPojo();
		
		return result;
	}
	
	public IResult listAllTags(int offset, int count) {
		IResult result = new ResultPojo();
		
		return result;
	}


	public IResult listAllResources(int offset, int count) {
		IResult result = new ResultPojo();
		
		return result;
	}

	public IResult listPivotsByGroup(String groupId) {
		IResult result = new ResultPojo();
		
		return result;
	}

	public IResult listPivotsByUser(String userId) {
		IResult result = new ResultPojo();
		
		return result;
	}

	public IResult listPivotsByTag(String tagName) {
		IResult result = new ResultPojo();
		
		return result;
	}
	
	public IResult listPivotsByResource(String url) {
		IResult result = new ResultPojo();
		
		return result;
	}



}
