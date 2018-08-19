package org.genesis.javacollector.mybatis.train.demo;

import org.apache.ibatis.session.SqlSession;
import org.genesis.javacollector.mybatis.train.mapper.RoleMapper;
import org.genesis.javacollector.mybatis.train.pojo.Role;
import org.genesis.javacollector.mybatis.train.utils.SqlSessionFactoryUtils;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: InsertRole2Demo
 * @Package org.genesis.javacollector.mybatis.train.demo
 * @Description: InsertRole2 demo
 * @date 2018/8/19 19:28
 */
public class InsertRole2Demo {
    public static void main(String[] args) {
        testInsertRole2();
    }

    public static void testInsertRole2() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = new Role();
            role.setRoleName("role_name");
            role.setNote("note");
            roleMapper.insertRole2(role);
            // 回填
            System.out.println("role id: " + role.getId());
            sqlSession.commit();
        } catch (Exception ex) {
            sqlSession.rollback();
            ex.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
