package org.genesis.javacollect.mustache.mustachespring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: HomeController
 * @Package org.genesis.javacollect.mustache.mustachespring.controller
 * @Description: home controller
 * @date 2018/8/6 20:44
 */

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String home() {
        return "index";
    }
}
