package org.chris.demo.kafka;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.chris.demo.kafka.config.KafkaConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = KafkaConfiguration.class)
public class KafkaSendTest {

	@Autowired
	private MessageProducer producer;

	@Test
	public void sendToKafka() throws IOException {
		boolean finished = false;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (!finished) {
			System.out.print("> ");
			String msg = reader.readLine();
			if (msg != null) {
				if (msg.equals("stop")) {
					finished = true;
				}
				producer.produceMessage(msg);
			}
		}
		reader.close();
	}
}
