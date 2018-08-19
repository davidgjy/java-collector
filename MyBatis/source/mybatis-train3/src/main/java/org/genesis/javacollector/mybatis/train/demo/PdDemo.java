package org.genesis.javacollector.mybatis.train.demo;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.genesis.javacollector.mybatis.train.mapper.PdRoleMapper;
import org.genesis.javacollector.mybatis.train.param.PdCountRoleParams;
import org.genesis.javacollector.mybatis.train.param.PdFindRoleParams;
import org.genesis.javacollector.mybatis.train.utils.SqlSessionFactoryUtils;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: PdDemo
 * @Package org.genesis.javacollector.mybatis.train.demo
 * @Description: Pd demo
 * @date 2018/8/19 20:21
 */
public class PdDemo {
    public static void main(String[] args) {
        //testPdCountRole();
        testPdFindRole();
    }

    public static void testPdCountRole() {
        PdCountRoleParams params = new PdCountRoleParams();
        SqlSession sqlSession = null;
        try {
            Logger logger = Logger.getLogger(PdDemo.class);
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            PdRoleMapper roleMapper = sqlSession.getMapper(PdRoleMapper.class);
            params.setRoleName("role_name");
            roleMapper.countRole(params);
            logger.info(params.getTotal());
            logger.info(params.getExecDate());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public static void testPdFindRole() {
        PdFindRoleParams params = new PdFindRoleParams();
        SqlSession sqlSession = null;
        try {
            Logger logger = Logger.getLogger(PdDemo.class);
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            PdRoleMapper roleMapper = sqlSession.getMapper(PdRoleMapper.class);
            params.setRoleName("role_name");
            params.setStart(0);
            params.setEnd(100);
            roleMapper.findRole(params);
            logger.info(params.getRoleList().size());
            logger.info(params.getTotal());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
