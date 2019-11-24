package com.genesis.defaultmemsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : KG
 * description:
 * create date: 10:57 AM 2019/11/24
 * modified by:
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello KG";
    }
}
