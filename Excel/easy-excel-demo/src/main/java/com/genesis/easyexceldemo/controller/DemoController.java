package com.genesis.easyexceldemo.controller;

import com.alibaba.excel.EasyExcel;
import com.genesis.easyexceldemo.entity.User;
import com.genesis.easyexceldemo.listener.UserExcelListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : KG
 * description:
 * create date: 3:04 PM 2019/12/25
 * modified by:
 */
@RestController
@RequestMapping("/demo")
@Slf4j
public class DemoController {

    @PostMapping("read")
    public void read() {
        String fileName = "/Users/jgu55/develop/github/java/java-collector/Excel/easy-excel-demo/src/main/resources/excel/users.xlsx";
        EasyExcel.read(fileName, User.class, new UserExcelListener()).sheet().doRead();
    }
}


