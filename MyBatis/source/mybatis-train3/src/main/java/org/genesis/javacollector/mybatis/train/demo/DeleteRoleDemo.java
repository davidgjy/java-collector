package org.genesis.javacollector.mybatis.train.demo;

import org.apache.ibatis.session.SqlSession;
import org.genesis.javacollector.mybatis.train.mapper.RoleMapper;
import org.genesis.javacollector.mybatis.train.utils.SqlSessionFactoryUtils;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: DeleteRoleDemo
 * @Package org.genesis.javacollector.mybatis.train.demo
 * @Description: DeleteRole demo
 * @date 2018/8/19 19:34
 */
public class DeleteRoleDemo {
    public static void main(String[] args) {
        testDeleteRole();
    }

    public static void testDeleteRole() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Long id = 3L;
            roleMapper.deleteRole(id);
            System.out.println("role id: " + id + " is successfully deleted!");
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
