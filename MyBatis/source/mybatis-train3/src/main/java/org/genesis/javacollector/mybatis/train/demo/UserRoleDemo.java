package org.genesis.javacollector.mybatis.train.demo;

import org.apache.ibatis.session.SqlSession;
import org.genesis.javacollector.mybatis.train.mapper2.RoleMapper2;
import org.genesis.javacollector.mybatis.train.mapper2.UserMapper2;
import org.genesis.javacollector.mybatis.train.pojo2.Role2;
import org.genesis.javacollector.mybatis.train.pojo2.User2;
import org.genesis.javacollector.mybatis.train.utils.SqlSessionFactoryUtils;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: UserRoleDemo
 * @Package org.genesis.javacollector.mybatis.train.demo
 * @Description: UserRole demo
 * @date 2018/8/19 20:12
 */
public class UserRoleDemo {
    public static void main(String[] args) {
        testUserRole();
    }

    public static void testUserRole() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper2 roleMapper2 = sqlSession.getMapper(RoleMapper2.class);
            Role2 role2 = roleMapper2.getRole(1L);
            System.out.println(role2.getUserList().size());

            UserMapper2 userMapper2 = sqlSession.getMapper(UserMapper2.class);
            User2 user2 = userMapper2.getUser(1L);
            System.out.println(user2.getRoleList().size());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
