package org.genesis.javacollector.mybatis.train.demo;

import org.apache.ibatis.session.SqlSession;
import org.genesis.javacollector.mybatis.train.helper.RoleHelper;
import org.genesis.javacollector.mybatis.train.mapper.RoleMapper;
import org.genesis.javacollector.mybatis.train.param.PageParams;
import org.genesis.javacollector.mybatis.train.param.RoleParams;
import org.genesis.javacollector.mybatis.train.pojo.Role;
import org.genesis.javacollector.mybatis.train.utils.SqlSessionFactoryUtils;

import java.util.List;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: FindByMixDemo
 * @Package org.genesis.javacollector.mybatis.train.demo
 * @Description: FindByMix demo
 * @date 2018/8/19 17:47
 */
public class FindByMixDemo {
    public static void main(String[] args) {
        testFindByMix();
    }

    public static void testFindByMix() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            RoleParams roleParam = new RoleParams();
            roleParam.setNote("1");
            roleParam.setRoleName("1");
            PageParams pageParams = new PageParams();
            pageParams.setStart(0);
            pageParams.setLimit(100);
            List<Role> roles = roleMapper.findByMix(roleParam, pageParams);

            RoleHelper.displayRoles(roles);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
