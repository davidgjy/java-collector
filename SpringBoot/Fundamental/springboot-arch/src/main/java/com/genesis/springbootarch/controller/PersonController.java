package com.genesis.springbootarch.controller;

import com.genesis.springbootarch.domain.response.PersonResponse;
import com.genesis.springbootarch.service.PersonService;
import com.genesis.springbootarch.util.LogUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: KG
 * @description:
 * @date: Created in 5:18 PM 2019/4/13
 * @modified by:
 */

@Api("Person Crontroller")
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @ApiOperation(value = "Get One Person")
    @PostMapping(value = "/get")
    public @ResponseBody
    PersonResponse get() {

        LogUtil.info("/person/get called...");

        return personService.getPerson();
    }
}

