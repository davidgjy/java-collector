package org.genesis.javacollector.mybatis.train.mapper;

import org.genesis.javacollector.mybatis.train.pojo.EmployeeTask;

public interface EmployeeTaskMapper {

    EmployeeTask getEmployeeTaskByEmpId(Long empId);
}
