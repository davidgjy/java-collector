package org.genesis.javacollector.mybatis.train.helper;

import org.genesis.javacollector.mybatis.train.pojo.Employee;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: EmployeeHelper
 * @Package org.genesis.javacollector.mybatis.train.helper
 * @Description: employee helper for display
 * @date 2018/8/19 20:03
 */
public class EmployeeHelper {
    public static void displayEmployee(Employee employee) {
        System.out.println("*************************** Employee ***************************");
        System.out.println(employee);
        System.out.println("****************************************************************");
    }
}

