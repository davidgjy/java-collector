package org.genesis.javacollector.mybatis.train.mapper;

import org.genesis.javacollector.mybatis.train.pojo.Employee;

public interface EmployeeMapper {

    Employee getEmployee(Long id);

    Employee getEmployee2(Long id);
}

