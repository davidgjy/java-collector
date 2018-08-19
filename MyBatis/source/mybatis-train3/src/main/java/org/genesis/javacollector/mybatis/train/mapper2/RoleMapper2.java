package org.genesis.javacollector.mybatis.train.mapper2;

import org.genesis.javacollector.mybatis.train.pojo2.Role2;

import java.util.List;

public interface RoleMapper2 {
	
	Role2 getRole(Long id);
	
	List<Role2> findRoleByUserId(Long userId);
}
