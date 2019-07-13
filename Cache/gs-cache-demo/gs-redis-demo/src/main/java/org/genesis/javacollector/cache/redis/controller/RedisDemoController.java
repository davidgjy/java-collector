package org.genesis.javacollector.cache.redis.controller;

import io.swagger.annotations.ApiOperation;
import org.genesis.javacollector.cache.redis.service.UserCacheService;
import org.genesis.javacollector.common.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: KG
 * @description:
 * @date: Created in 下午5:14 2019/7/13
 * @modified by:
 */
@RestController
@RequestMapping("/redis-demo")
public class RedisDemoController {

    @Autowired
    private UserCacheService userCacheService;

    @ApiOperation(value = "Pinelined Set Users to Redis")
    @RequestMapping(value = "/pipeline-set", method = RequestMethod.POST)
    public void setUsersPipeline() {
        userCacheService.setUsersToCahce();
    }
}
