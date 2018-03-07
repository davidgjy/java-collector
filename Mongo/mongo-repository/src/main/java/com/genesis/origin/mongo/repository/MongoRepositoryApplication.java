package com.genesis.origin.mongo.repository;

import com.genesis.origin.mongo.repository.dao.JobRepository;
import com.genesis.origin.mongo.repository.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MongoRepositoryApplication implements CommandLineRunner {

	@Autowired
	private JobRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(MongoRepositoryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Job> jobs = repository.findAll();
		for (Job job:jobs) {
			System.out.println(job);
		}
		System.out.println("------------------------------------");
	}
}
