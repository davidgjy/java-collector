package org.genesis.javacollector.mybatis.train.demo;

import org.apache.ibatis.session.SqlSession;
import org.genesis.javacollector.mybatis.train.helper.EmployeeHelper;
import org.genesis.javacollector.mybatis.train.mapper.EmployeeMapper;
import org.genesis.javacollector.mybatis.train.pojo.Employee;
import org.genesis.javacollector.mybatis.train.utils.SqlSessionFactoryUtils;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: GetEmployee2Demo
 * @Package org.genesis.javacollector.mybatis.train.demo
 * @Description: GetEmployee2 demo
 * @date 2018/8/19 20:10
 */
public class GetEmployee2Demo {
    public static void main(String[] args) {
        testGetEmployee2();
    }

    public static void testGetEmployee2() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = employeeMapper.getEmployee2(1L);

            EmployeeHelper.displayEmployee(employee);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
