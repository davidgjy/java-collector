package org.genesis.javacollector.cache.redis.controller;

import io.swagger.annotations.ApiOperation;
import org.genesis.javacollector.cache.redis.service.UserCacheService;
import org.genesis.javacollector.common.domain.User;
import org.genesis.javacollector.common.util.log.LogUtil;
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

        Long start = System.currentTimeMillis();

        userCacheService.setUsersToCahce();

        Long end = System.currentTimeMillis();

        LogUtil.info("耗时：" + (end - start) + "毫秒");
    }

    @ApiOperation(value = "Pinelined Get Users from Redis")
    @RequestMapping(value = "/pipeline-get", method = RequestMethod.POST)
    public List<String> getUsersPipeline() {

        Long start = System.currentTimeMillis();

        List<String> users = userCacheService.getUsersFromCache();

        Long end = System.currentTimeMillis();

        LogUtil.info("耗时：" + (end - start) + "毫秒");

        return users;
    }
}
