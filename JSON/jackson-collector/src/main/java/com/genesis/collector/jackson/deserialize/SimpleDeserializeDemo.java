package com.genesis.collector.jackson.deserialize;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.genesis.collector.jackson.domain.User;

import java.io.IOException;
import java.text.ParseException;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: SimpleDeserializeDemo
 * @Package com.genesis.collector.jackson.deserialize
 * @Description: simple deserialize demo
 * @date 2018/5/25 14:12
 */
public class SimpleDeserializeDemo {
    public static void main(String[] args) throws ParseException, IOException {
        String json = "{\"name\":\"小民\",\"age\":20,\"birthday\":844099200000,\"mail\":\"xiaomin@sina.com\"}";

        /**
         * ObjectMapper支持从byte[]、File、InputStream、字符串等数据的JSON反序列化。
         */
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(json, User.class);
        System.out.println(user);
    }
}
