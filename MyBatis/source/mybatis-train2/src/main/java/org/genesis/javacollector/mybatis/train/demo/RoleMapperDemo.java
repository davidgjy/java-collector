package org.genesis.javacollector.mybatis.train.demo;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import org.genesis.javacollector.mybatis.train.mapper.RoleMapper;
import org.genesis.javacollector.mybatis.train.pojo.Role;
import org.genesis.javacollector.mybatis.train.utils.SqlSessionFactoryUtils;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: RoleMapperDemo
 * @Package org.genesis.javacollector.mybatis.train.demo
 * @Description: role mapper demo
 * @date 2018/8/18 22:31
 */
public class RoleMapperDemo {
    public static void main(String[] args) {
        testRoleMapper();
    }

    private static void testRoleMapper() {
        Logger log = Logger.getLogger(RoleMapperDemo.class);

        SqlSession sqlSession = null;

        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = roleMapper.getRole(1L);
            log.info(role.getRoleName());
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
