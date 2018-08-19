package org.genesis.javacollector.mybatis.train.demo;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.genesis.javacollector.mybatis.train.mapper.RoleMapper;
import org.genesis.javacollector.mybatis.train.pojo.Role;
import org.genesis.javacollector.mybatis.train.utils.SqlSessionFactoryUtils;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: OneLevelCacheDemo
 * @Package org.genesis.javacollector.mybatis.train.demo
 * @Description: OneLevelCache demo
 * @date 2018/8/19 20:14
 */
public class OneLevelCacheDemo {
    public static void main(String[] args) {
        //testOneLevelCache();
        testOneLevelCache2();
    }

    public static void testOneLevelCache() {
        SqlSession sqlSession = null;
        Logger logger = Logger.getLogger(OneLevelCacheDemo.class);
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = roleMapper.getRole(1L);
            logger.info("再获取一次POJO......");
            Role role2 = roleMapper.getRole(1L);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public static void testOneLevelCache2() {
        Logger logger = Logger.getLogger(OneLevelCacheDemo.class);
        try (SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
             SqlSession sqlSession2 = SqlSessionFactoryUtils.openSqlSession()) {

            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = roleMapper.getRole(1L);

            // 需要提交，如果是一级缓存，MyBatis才会缓存对象到SqlSessionFactory层面
            sqlSession.commit();
            logger.info("不同sqlSession再获取一次POJO......");
            RoleMapper roleMapper2 = sqlSession2.getMapper(RoleMapper.class);
            Role role2 = roleMapper2.getRole(1L);

            // 需要提交，MyBatis才缓存对象到SQLSessionFactory
            sqlSession2.commit();
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }
    }
}
