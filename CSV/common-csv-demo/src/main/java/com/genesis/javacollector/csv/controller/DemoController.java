package com.genesis.javacollector.csv.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileReader;
import java.io.Reader;

/**
 * @author : KG
 * description:
 * create date: 2:16 PM 2019/12/31
 * modified by:
 */
@RestController
@RequestMapping("/demo")
@Slf4j
public class DemoController {

    @PostMapping("read")
    public void read() {
        String fileName = "/Users/jgu55/develop/github/java/java-collector/CSV/common-csv-demo/src/main/resources/users.csv";
        final String[] FILE_HEADER = {"姓名", "年龄", "性别", "出生日期", "是否已婚"};

        // 这里显式地配置一下CSV文件的Header，然后设置跳过Header（要不然读的时候会把头也当成一条记录）
        CSVFormat format = CSVFormat.DEFAULT.withHeader(FILE_HEADER).withSkipHeaderRecord();

        try (Reader in = new FileReader(fileName)) {
            Iterable<CSVRecord> records = format.parse(in);
            String name;
            String age;
            for (CSVRecord record : records) {
                name = record.get("姓名");
                age = record.get("年龄");
                log.info(name + " " + age);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
