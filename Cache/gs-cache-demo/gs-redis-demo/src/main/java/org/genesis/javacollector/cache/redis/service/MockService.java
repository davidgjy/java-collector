package org.genesis.javacollector.cache.redis.service;

import org.genesis.javacollector.common.domain.User;

import java.util.List;

/**
 * @author: KG
 * @description:
 * @date: Created in 下午4:52 2019/7/13
 * @modified by:
 */

public interface MockService {
    List<User> mockUsers(int capacity);
}

