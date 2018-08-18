package org.genesis.javacollector.mybatis.train.dao;

import org.apache.ibatis.annotations.Select;

import org.genesis.javacollector.mybatis.train.pojo.Role;

public interface RoleMapper2 {
	
	@Select("select id, role_name as roleName, note from t_role where id=#{id}")
	public Role getRole(Long id);
}
