package org.genesis.javacollector.mybatis.train.demo;

import org.apache.ibatis.session.SqlSession;
import org.genesis.javacollector.mybatis.train.dao.RoleMapper2;
import org.genesis.javacollector.mybatis.train.pojo.Role;
import org.genesis.javacollector.mybatis.train.utils.SqlSessionFactoryUtils;
import org.apache.log4j.Logger;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: MapByAnnotationDemo
 * @Package org.genesis.javacollector.mybatis.train.demo
 * @Description: mapping by annotation
 * @date 2018/8/18 21:21
 */
public class MapByAnnotationDemo {
    public static void main(String[] args) {
        testRoleMapper2();
    }

    private static void testRoleMapper2() {
        Logger log = Logger.getLogger(MapByAnnotationDemo.class);

        SqlSession sqlSession = null;

        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper2 roleMapper2 = sqlSession.getMapper(RoleMapper2.class);
            Role role = roleMapper2.getRole(1L);
            log.info(role.getRoleName());
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
