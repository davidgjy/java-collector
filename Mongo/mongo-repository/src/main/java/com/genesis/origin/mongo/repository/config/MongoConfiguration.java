/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.origin.mongo.repository.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;

@Configuration
@EnableMongoRepositories
public class MongoConfiguration extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "scrape51";
    }

    @Override
    public MongoClient mongoClient() {
        //return new MongoClient("192.168.8.118", 27017);

        MongoCredential credential = MongoCredential.createCredential("scraper", "scrape51", "51job".toCharArray());
        MongoClient mongoClient = new MongoClient(new ServerAddress("192.168.8.118", 27017), Arrays.asList(credential));

        return mongoClient;
    }

    @Override
    protected String getMappingBasePackage() {
        return "com.genesis.origin.mongo.repository.dao";
    }
}
