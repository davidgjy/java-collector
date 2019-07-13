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
    public List<User> getUserList() {

        List<User> users = new ArrayList<>();

        users.add(new User(1, "Peter"));
        users.add(new User(2, "David"));
        users.add(new User(3, "Kelvin"));

        return users;
    }
}
