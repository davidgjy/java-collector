package org.genesis.javacollector.springcloud.oauth.service;

import org.genesis.javacollector.springcloud.oauth.entity.User;
import org.genesis.javacollector.springcloud.oauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author KG
 * @data 2018/11/04 22:30
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }


}
