package org.genesis.javacollector.springboot.kafka.producer;

import com.alibaba.fastjson.JSON;
import org.genesis.javacollector.springboot.kafka.domain.UserLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author: KG
 * @description:
 * @date: Created in 10:50 AM 2019/7/29
 * @modified by:
 */

@Component
public class UserLogProducer {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    /**
     * 发送数据
     * @param userid
     */
    public void sendLog(String userid){
        UserLog userLog = new UserLog();
        userLog.setUsername("jhp");
        userLog.setUserid(userid);
        userLog.setState("0");
        System.err.println("发送用户日志数据:"+userLog);
        kafkaTemplate.send("user-log", JSON.toJSONString(userLog));
    }
}

