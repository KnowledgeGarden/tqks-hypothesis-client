/**
 * 
 */
package org.topicquests.ks.kafka;

import java.util.Map;

import org.topicquests.ks.tagomizer.TagomizerClientEnvironment;
import org.topicquests.support.config.Configurator;

import net.minidev.json.JSONObject;

/**
 * @author jackpark
 *
 */
public class KafkaHandler {
	private TagomizerClientEnvironment environment;
	private KafkaProducer producer;
	private Map<String,Object>kafkaProps;
	private final String
		KAFKA_GROUP = "Tagomizer",
		KAFKA_TOPIC;
	/**
	 * 
	 */
	public KafkaHandler(TagomizerClientEnvironment env) {
		environment = env;
		producer = new KafkaProducer(environment, KAFKA_GROUP+Long.toString(System.currentTimeMillis()));
		kafkaProps = Configurator.getProperties("kafka-topics.xml");
		KAFKA_TOPIC = (String)kafkaProps.get("SentenceTagomizerTopic");
	}
	
	/**
	 * Turn {@code annotation} into a document for spacy and inject it into Kafka
	 * @param annotation
	 */
	public void acceptAnalyzedAnnotation(JSONObject annotation) {
		//send as is
		JSONObject kafkaObject = annotation;
		producer.sendMessage(KAFKA_TOPIC, kafkaObject.toJSONString(), "tagomizer", new Integer(0));
	}

}
