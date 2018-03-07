package com.genesis.collector.mongo.template.dao;

import com.genesis.collector.mongo.template.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: KG
 * @Description:
 * @Date: Created in 下午4:10 2018/3/7
 * @Modified by:
 */

@Repository
public class JobDaoImpl implements JobDao {
    @Autowired
    private MongoOperations mongoOps;

    @Override
    public List<Job> findAll() {
        List<Job> jobs = mongoOps.findAll(Job.class);

        return jobs;
    }
}
