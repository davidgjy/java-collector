package org.chris.demo.kafka;

import org.apache.log4j.Logger;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.KafkaNull;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@KafkaListener(topics = "${kafka.topic}")
@Service
public class KafkaMessageListener {

	private static Logger logger = Logger.getLogger(KafkaMessageListener.class);

	@KafkaHandler
	public void consumeMessage(@Payload String content, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
			@Header(KafkaHeaders.RECEIVED_TOPIC) String topic, @Header(KafkaHeaders.OFFSET) Long offset) {
		logger.info("\nReceived message: " + content + " from topic " + topic + ", partition " + partition
				+ ", Offset = " + offset);
	}

	@KafkaHandler
	public void handleNull(@Payload(required = false) KafkaNull nul) {
		// do nothing ...
	}

}
