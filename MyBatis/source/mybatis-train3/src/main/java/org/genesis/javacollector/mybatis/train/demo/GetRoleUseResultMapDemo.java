package org.genesis.javacollector.mybatis.train.demo;

import org.apache.ibatis.session.SqlSession;
import org.genesis.javacollector.mybatis.train.mapper.RoleMapper;
import org.genesis.javacollector.mybatis.train.pojo.Role;
import org.genesis.javacollector.mybatis.train.utils.SqlSessionFactoryUtils;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: GetRoleUseResultMapDemo
 * @Package org.genesis.javacollector.mybatis.train.demo
 * @Description: GetRoleUseResultMap demo
 * @date 2018/8/19 17:51
 */
public class GetRoleUseResultMapDemo {
    public static void main(String[] args) {
        testGetRoleUseResultMap();
    }

    public static void testGetRoleUseResultMap() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = roleMapper.getRoleUseResultMap(1L);
            System.out.println(role);
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

}
