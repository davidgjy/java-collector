package org.genesis.javacollector.springcloud.oauth.service;


import org.genesis.javacollector.springcloud.oauth.entity.User;
import org.springframework.data.domain.Page;

/**
 * @author KG
 * @data 2018/11/04 22:30
 */

public interface UserService {
    void save(User user);//保存用户


}
