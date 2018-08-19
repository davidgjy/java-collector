package org.genesis.javacollector.mybatis.train.demo;

import org.apache.ibatis.session.SqlSession;
import org.genesis.javacollector.mybatis.train.mapper.RoleMapper;
import org.genesis.javacollector.mybatis.train.pojo.Role;
import org.genesis.javacollector.mybatis.train.utils.SqlSessionFactoryUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: FindRolesByMapDemo
 * @Package org.genesis.javacollector.mybatis.train.demo
 * @Description: find roles by map
 * @date 2018/8/19 17:24
 */
public class FindRolesByMapDemo {
    public static void main(String[] args) {
        testFindRolesByMap();
    }

    public static void testFindRolesByMap() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Map<String, Object> parameterMap = new HashMap<String, Object>();
            parameterMap.put("roleName", "1");
            parameterMap.put("note", "1");
            List<Role> roles = roleMapper.findRolesByMap(parameterMap);
            System.out.println("roles size: " + roles.size());
            for (Role role : roles) {
                System.out.println(role);
                System.out.println("-------------------------------");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
