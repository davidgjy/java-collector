package org.genesis.javacollector.mybatis.train.mapper;

import org.genesis.javacollector.mybatis.train.param.PdCountRoleParams;
import org.genesis.javacollector.mybatis.train.param.PdFindRoleParams;

public interface PdRoleMapper {

    void countRole(PdCountRoleParams pdCountRoleParams);

    void findRole(PdFindRoleParams pdFindRoleParams);
}
