package org.genesis.javacollector.mybatis.train.demo;

import org.apache.ibatis.session.SqlSession;
import org.genesis.javacollector.mybatis.train.mapper.RoleMapper;
import org.genesis.javacollector.mybatis.train.pojo.Role;
import org.genesis.javacollector.mybatis.train.utils.SqlSessionFactoryUtils;

import java.util.List;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: FindRolesByAnnotationDemo
 * @Package org.genesis.javacollector.mybatis.train.demo
 * @Description: FindRolesByAnnotation demo
 * @date 2018/8/19 17:32
 */
public class FindRolesByAnnotationDemo {
    public static void main(String[] args) {
        testFindRolesByAnnotation();
    }

    public static void testFindRolesByAnnotation() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            List<Role> roles = roleMapper.findRolesByAnnotation("1", "1");
            System.out.println(roles.size());
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
