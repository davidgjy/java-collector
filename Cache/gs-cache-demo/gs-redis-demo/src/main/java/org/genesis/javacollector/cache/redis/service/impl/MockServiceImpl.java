package org.genesis.javacollector.cache.redis.service.impl;

import org.genesis.javacollector.cache.redis.service.MockService;
import org.genesis.javacollector.common.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: KG
 * @description:
 * @date: Created in 下午4:52 2019/7/13
 * @modified by:
 */
@Service
public class MockServiceImpl implements MockService {
    @Override
    public List<User> mockUsers(int capacity) {

        List<User> users = new ArrayList<>();

        for (int i=1;i<=capacity;i++) {
            users.add(new User(i, String.format("User%d", i)));
        }

        return users;
    }
}
