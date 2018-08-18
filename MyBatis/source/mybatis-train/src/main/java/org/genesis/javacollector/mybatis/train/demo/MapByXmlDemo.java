package org.genesis.javacollector.mybatis.train.demo;

import org.apache.ibatis.session.SqlSession;
import org.genesis.javacollector.mybatis.train.dao.RoleMapper;
import org.genesis.javacollector.mybatis.train.pojo.Role;
import org.genesis.javacollector.mybatis.train.utils.SqlSessionFactoryUtils;

import org.apache.log4j.Logger;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: MapByXmlDemo
 * @Package org.genesis.javacollector.mybatis.train.demo
 * @Description: mapping by xml
 * @date 2018/8/18 11:37
 */
public class MapByXmlDemo {
    public static void main(String[] args) {
        testRoleMapper();
    }

    private static void testRoleMapper() {
        Logger log = Logger.getLogger(MapByXmlDemo.class);

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


