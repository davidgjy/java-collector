package org.genesis.javacollector.mybatis.train.mapper;

import org.genesis.javacollector.mybatis.train.pojo.WorkCard;

public interface WorkCardMapper {

    WorkCard getWorkCardByEmpId(Long empId);
}
