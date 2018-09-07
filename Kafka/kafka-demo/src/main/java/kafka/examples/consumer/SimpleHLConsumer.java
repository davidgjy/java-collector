package kafka.examples.consumer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

/**
 * Simple high level consumer.
 * 
 * @author Chris
 */
public class SimpleHLConsumer {

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
        if (argsCount != 3) {
            throw new IllegalArgumentException("Please provide ZooKeeper server, group ID and topic as arguments");
        }
        String zooKeeper = args[0];
        String groupId = args[1];
        String topic = args[2];
        SimpleHLConsumer simpleHLConsumer = new SimpleHLConsumer(zooKeeper, groupId, topic);
        simpleHLConsumer.testConsumer();
    }

    public SimpleHLConsumer(String zookeeper, String groupId, String topic) {
        consumer = Consumer.createJavaConsumerConnector(createConsumerConfig(zookeeper, groupId));
        this.topic = topic;
    }

    public void testConsumer() {
        Map<String, Integer> topicMap = new HashMap<String, Integer>();
        topicMap.put(topic, new Integer(1)); // define single thread for topic
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerStreamsMap = consumer.createMessageStreams(topicMap);
        List<KafkaStream<byte[], byte[]>> streamList = consumerStreamsMap.get(topic);
        for (final KafkaStream<byte[], byte[]> stream : streamList) {
            ConsumerIterator<byte[], byte[]> consumerIte = stream.iterator();
            while (consumerIte.hasNext()) {
                System.out.println("Message from single topic: " + new String(consumerIte.next().message()));
            }
        }
        if (consumer != null) {
            consumer.shutdown();
        }
    }
}
