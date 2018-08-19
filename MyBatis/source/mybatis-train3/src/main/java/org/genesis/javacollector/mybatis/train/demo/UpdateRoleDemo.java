package org.genesis.javacollector.mybatis.train.demo;

import org.apache.ibatis.session.SqlSession;
import org.genesis.javacollector.mybatis.train.mapper.RoleMapper;
import org.genesis.javacollector.mybatis.train.pojo.Role;
import org.genesis.javacollector.mybatis.train.utils.SqlSessionFactoryUtils;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: UpdateRoleDemo
 * @Package org.genesis.javacollector.mybatis.train.demo
 * @Description: UpdateRole demo
 * @date 2018/8/19 19:31
 */
public class UpdateRoleDemo {
    public static void main(String[] args) {
        testUpdateRole();
    }

    public static void testUpdateRole() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = new Role();
            role.setRoleName("role_name_1_update");
            role.setNote("note_1_update");
            role.setId(1L);
            roleMapper.updateRole(role);
            System.out.println("role update successful!");
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
