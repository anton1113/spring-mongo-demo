package com.arash.thymeleafdemo.config;

import com.mongodb.MongoClientURI;
import com.mongodb.WriteConcern;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.net.UnknownHostException;

/**
 * Created by anton1113 on 19.02.18.
 */
@Configuration
@ComponentScan(basePackages = {"com.arash.thymeleafdemo"})
@EnableMongoRepositories(
        basePackages = "com.arash.thymeleafdemo.repository",
        mongoTemplateRef = "demoMongoTemplate"
)
public class MongoDbConfig {

    @Value("${mongo.db.uri}")
    private String uri;

    @Bean
    public MongoDbFactory demoMongoDbFactory() throws UnknownHostException {
        MongoClientURI mongoClientURI = new MongoClientURI(uri);
        return new SimpleMongoDbFactory(mongoClientURI);
    }

    @Bean
    public MongoTemplate demoMongoTemplate() throws Exception {
        MongoTemplate demoMongoTemplate = new MongoTemplate(demoMongoDbFactory());
        demoMongoTemplate.setWriteConcern(WriteConcern.MAJORITY);
        return demoMongoTemplate;
    }
}
