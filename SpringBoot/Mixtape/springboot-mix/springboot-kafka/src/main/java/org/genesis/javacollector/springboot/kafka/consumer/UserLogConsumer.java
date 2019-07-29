package org.genesis.javacollector.springboot.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.genesis.javacollector.common.util.log.LogUtil;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author: KG
 * @description:
 * @date: Created in 10:56 AM 2019/7/29
 * @modified by:
 */

@Component
public class UserLogConsumer {
    @KafkaListener(topics = {"user-log"})
    public void consumer(ConsumerRecord<?,?> consumerRecord){
        //判断是否为null
        Optional<?> kafkaMessage = Optional.ofNullable(consumerRecord.value());
        LogUtil.info(">>>>>>>>>> record =" + kafkaMessage);
        if(kafkaMessage.isPresent()){
            //得到Optional实例中的值
            Object message = kafkaMessage.get();
            System.err.println("消费消息:"+message);
        }
    }
}

