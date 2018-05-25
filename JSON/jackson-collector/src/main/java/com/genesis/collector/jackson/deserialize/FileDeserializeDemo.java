package com.genesis.collector.jackson.deserialize;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.genesis.collector.jackson.domain.User;
import com.genesis.collector.jackson.util.FileUtil;

import java.io.IOException;
import java.text.ParseException;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: FileDeserializeDemo
 * @Package com.genesis.collector.jackson.deserialize
 * @Description: deserialize json file to object
 * @date 2018/5/25 14:26
 */
public class FileDeserializeDemo {
    public static void main(String[] args) throws ParseException, IOException {
        String filePath = "src/main/resources/data/user.json";
        String json = FileUtil.readToString(filePath);

        /**
         * ObjectMapper支持从byte[]、File、InputStream、字符串等数据的JSON反序列化。
         */
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(json, User.class);
        System.out.println("Deserialize from file: " + filePath);
        System.out.println(user);
    }
}
