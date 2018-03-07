package com.genesis.origin.mongo.repository.dao;

import com.genesis.origin.mongo.repository.model.Job;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * @Author: KG
 * @Description:
 * @Date: Created in 下午3:25 2018/3/7
 * @Modified by:
 */

@RepositoryRestResource(collectionResourceRel = "scrape51", path = "jobs")
public interface JobRepository extends MongoRepository<Job, String> {
    public List<Job> findByPosition(@Param("position") String position);
    public List<Job> findByLocation(@Param("location") String location);
    public List<Job> findBySalary(@Param("salary") String salary);
}
