package org.chris.demo.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

@Configuration
@EnableKafka
@ComponentScan({ "org.chris.demo.kafka" })
@PropertySource("kafka.properties")
public class KafkaConfiguration {

	@Autowired
	private Environment env;

	@Bean
	public KafkaTemplate<String, String> kafkaTemplate(DefaultKafkaProducerFactory<String, String> producerFactory) {
		KafkaTemplate<String, String> kafkaTemplate = new KafkaTemplate<>(producerFactory, true);
		kafkaTemplate.setDefaultTopic(env.getProperty("kafka.topic", "replicated-topic"));
		return kafkaTemplate;
	}

	@Bean
	public DefaultKafkaProducerFactory<String, String> producerFactory() {
		StringSerializer keySerializer = new StringSerializer();
		StringSerializer valueSerializer = new StringSerializer();
		Map<String, Object> kafkaConfigs = kafkaConfigs();
		DefaultKafkaProducerFactory<String, String> producerFactory = new DefaultKafkaProducerFactory<>(kafkaConfigs,
				keySerializer, valueSerializer);
		return producerFactory;
	}

	@Bean
	public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<Integer, String>> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<Integer, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		factory.setConcurrency(3);
		factory.getContainerProperties().setPollTimeout(3000);
		return factory;
	}

	@Bean
	public ConsumerFactory<Integer, String> consumerFactory() {
		Map<String, Object> kafkaConfigs = kafkaConfigs();
		kafkaConfigs.put(ConsumerConfig.GROUP_ID_CONFIG, env.getProperty("group.id", "spring-test-group"));
		return new DefaultKafkaConsumerFactory<>(kafkaConfigs);
	}

	@Bean
	public Map<String, Object> kafkaConfigs() {
		Map<String, Object> factoryConfig = new HashMap<>();
		factoryConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
				env.getProperty("bootstrap.servers", "localhost:9092"));
		factoryConfig.put("acks", env.getProperty("acks", "all"));
		factoryConfig.put("retries", env.getProperty("retries", "0"));
		factoryConfig.put("batch.size", env.getProperty("batch.size", "16384"));
		factoryConfig.put("linger.ms", env.getProperty("linger.ms", "1"));
		factoryConfig.put("request.timeout.ms", env.getProperty("request.timeout.ms", "30000"));
		factoryConfig.put("buffer.memory", env.getProperty("buffer.memory", "33554432"));
		factoryConfig.put("kafka.topic", env.getProperty("kafka.topic", "replicated-topic"));
		factoryConfig.put("key.serializer",
				env.getProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer"));
		factoryConfig.put("value.deserializer",
				env.getProperty("value.serializer", "org.apache.kafka.common.serialization.StringSerializer"));
		factoryConfig.put("key.deserializer",
				env.getProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer"));
		factoryConfig.put("value.deserializer",
				env.getProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer"));
		return factoryConfig;
	}
}
