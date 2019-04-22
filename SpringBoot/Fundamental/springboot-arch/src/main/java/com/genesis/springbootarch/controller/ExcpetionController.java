package com.genesis.springbootarch.controller;

import com.genesis.springbootarch.domain.response.BaseResponse;
import com.genesis.springbootarch.domain.response.PersonResponse;
import com.genesis.springbootarch.util.LogUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author: KG
 * @description:
 * @date: Created in 8:31 PM 2019/4/22
 * @modified by:
 */
@Api("Person Crontroller")
@RestController
@RequestMapping("/exception")
public class ExcpetionController {
    @ApiOperation(value = "Test Null Pointer Exception")
    @PostMapping(value = "/null_pointer")
    public @ResponseBody
    BaseResponse<Integer> nullPointer() {

        ArrayList<String> students = null;

        Integer number = students.size();

        LogUtil.info("NullPointer Exception Continue...");

        BaseResponse<Integer> response = new BaseResponse<>();
        response.setData(number);

        return response;
    }
}




