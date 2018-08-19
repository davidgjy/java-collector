package org.genesis.javacollector.mybatis.train.demo;

import org.apache.ibatis.session.SqlSession;
import org.genesis.javacollector.mybatis.train.mapper.RoleMapper;
import org.genesis.javacollector.mybatis.train.pojo.Role;
import org.genesis.javacollector.mybatis.train.utils.SqlSessionFactoryUtils;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: InsertRoleDemo
 * @Package org.genesis.javacollector.mybatis.train.demo
 * @Description: InsertRole demo
 * @date 2018/8/19 19:07
 */
public class InsertRoleDemo {
    public static void main(String[] args) {
        testInsertRole();
    }

    public static void testInsertRole() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = new Role();
            role.setRoleName("role_name_5");
            role.setNote("note_5");
            roleMapper.insertRole(role);
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
