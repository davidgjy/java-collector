package kafka.examples.consumer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

public class MultiThreadHLConsumer {

	private ExecutorService executor;

	private final ConsumerConnector consumer;

	private final String topic;

	/**
	 * Create consumer config.
	 * 
	 * @param zookeeper
	 * @param groupId
	 * @return
	 */
	private static ConsumerConfig createConsumerConfig(String zookeeper, String groupId) {
		Properties props = new Properties();
		props.put("zookeeper.connect", zookeeper);
		props.put("group.id", groupId);
		props.put("zookeeper.session.timeout.ms", "500");
		props.put("zookeeper.sync.time.ms", "250");
		props.put("auto.commit.interval.ms", "1000");
		return new ConsumerConfig(props);
	}

	public static void main(String[] args) {
		int argsCount = args.length;
		if (argsCount != 4) {
			throw new IllegalArgumentException(
					"Please provide ZooKeeper server, group ID, topic and thread count as arguments");
		}
		String zooKeeper = args[0];
		String groupId = args[1];
		String topic = args[2];
		int threadCount = Integer.parseInt(args[3]);
		MultiThreadHLConsumer multiThreadHLConsumer = new MultiThreadHLConsumer(zooKeeper, groupId, topic);
		multiThreadHLConsumer.testMultiThreadConsumer(threadCount);
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {

		}
		multiThreadHLConsumer.shutdown();
	}

	public MultiThreadHLConsumer(String zookeeper, String groupId, String topic) {
		consumer = Consumer.createJavaConsumerConnector(createConsumerConfig(zookeeper, groupId));
		this.topic = topic;
	}

	public void shutdown() {
		if (consumer != null) {
			consumer.shutdown();
		}
		if (executor != null) {
			executor.shutdown();
		}
	}

	/**
	 * Test multiple-thread consumer.
	 * 
	 * @param threadCount
	 */
	public void testMultiThreadConsumer(int threadCount) {
		Map<String, Integer> topicMap = new HashMap<String, Integer>();
		topicMap.put(topic, new Integer(threadCount)); // define thread count for each topic

		// here we have used a single topic but we can also add multiple topics to the
		// topic map
		Map<String, List<KafkaStream<byte[], byte[]>>> consumerStreamsMap = consumer.createMessageStreams(topicMap);
		List<KafkaStream<byte[], byte[]>> streamList = consumerStreamsMap.get(topic);

		// launching the thread pool
		executor = Executors.newFixedThreadPool(threadCount);

		// creating an object messages consumption
		int count = 0;
		for (final KafkaStream<byte[], byte[]> stream : streamList) {
			final int threadNumber = count;

			executor.submit(() -> {
				ConsumerIterator<byte[], byte[]> consumerIte = stream.iterator();
				while (consumerIte.hasNext()) {
					String message = new String(consumerIte.next().message());
					System.out.println("Thread number " + threadNumber + ": " + message);
					if (message.equals("quit")) {
						break;
					}
				}
				System.out.println("Shutting down thread number: " + threadNumber);
			});
			count++;
		}
	}
}
