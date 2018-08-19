package org.genesis.javacollector.mybatis.train.mapper2;

import org.genesis.javacollector.mybatis.train.pojo2.User2;

import java.util.List;

public interface UserMapper2 {

    User2 getUser(Long id);

    List<User2> findUserByRoleId(Long roleId);
}
