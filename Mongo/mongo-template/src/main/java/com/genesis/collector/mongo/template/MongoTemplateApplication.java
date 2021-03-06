package com.genesis.collector.mongo.template;

import com.genesis.collector.mongo.template.dao.JobDao;
import com.genesis.collector.mongo.template.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MongoTemplateApplication implements CommandLineRunner {

	@Autowired
	private JobDao jobDao;

	public static void main(String[] args) {
		SpringApplication.run(MongoTemplateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Job> jobs = jobDao.findAll();
		for (Job job:jobs) {
			System.out.println(job);
		}
	}
}
