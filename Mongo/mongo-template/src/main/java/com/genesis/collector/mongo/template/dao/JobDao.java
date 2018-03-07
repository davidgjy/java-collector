package com.genesis.collector.mongo.template.dao;

import com.genesis.collector.mongo.template.model.Job;

import java.util.List;

/**
 * @Author: KG
 * @Description:
 * @Date: Created in 下午4:09 2018/3/7
 * @Modified by:
 */

public interface JobDao {
    List<Job> findAll();
}
