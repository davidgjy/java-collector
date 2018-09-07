package org.chris.demo.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaTemplateMessageProducer implements MessageProducer {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void produceMessage(String messageText) {
		kafkaTemplate.sendDefault(messageText);
	}
}
