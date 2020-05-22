package org.genesis.dubbo.provider.impl;

import org.genesis.dubbo.provider.api.UserService;

/**
 * @author: KG
 * @description:
 * @date: Created in 3:05 下午 2020/5/22
 * @modified by:
 */

public class UserServiceImpl implements UserService {
    @Override
    public String getNameById(String id) {
        System.out.println("receive data: " + id);

        return "123456";
    }
}
