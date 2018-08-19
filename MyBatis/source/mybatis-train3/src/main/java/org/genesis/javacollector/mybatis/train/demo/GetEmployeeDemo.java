package org.genesis.javacollector.mybatis.train.demo;

import org.apache.ibatis.session.SqlSession;
import org.genesis.javacollector.mybatis.train.helper.EmployeeHelper;
import org.genesis.javacollector.mybatis.train.mapper.EmployeeMapper;
import org.genesis.javacollector.mybatis.train.pojo.Employee;
import org.genesis.javacollector.mybatis.train.utils.SqlSessionFactoryUtils;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: GetEmployeeDemo
 * @Package org.genesis.javacollector.mybatis.train.demo
 * @Description: GetEmployee demo
 * @date 2018/8/19 19:38
 */
public class GetEmployeeDemo {
    public static void main(String[] args) {
        testGetEmployee();
    }

    public static void testGetEmployee() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = employeeMapper.getEmployee(1L);

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
