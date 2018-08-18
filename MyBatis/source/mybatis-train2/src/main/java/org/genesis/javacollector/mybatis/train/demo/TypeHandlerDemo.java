package org.genesis.javacollector.mybatis.train.demo;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import org.genesis.javacollector.mybatis.train.mapper.UserMapper;
import org.genesis.javacollector.mybatis.train.pojo.User;
import org.genesis.javacollector.mybatis.train.utils.SqlSessionFactoryUtils;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: TypeHandlerDemo
 * @Package org.genesis.javacollector.mybatis.train.demo
 * @Description: type handler demo
 * @date 2018/8/18 22:34
 */
public class TypeHandlerDemo {
    public static void main(String[] args) {
        testTypeHandler();
    }

    private static void testTypeHandler() {
        Logger log = Logger.getLogger(TypeHandlerDemo.class);

        SqlSession sqlSession = null;

        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUser(1L);
            System.out.println(user.getSex().getName());
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

}
