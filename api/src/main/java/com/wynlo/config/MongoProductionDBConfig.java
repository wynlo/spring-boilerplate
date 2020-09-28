package com.wynlo.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@Profile("production")
public class MongoProductionDBConfig {

    @Value("${spring.data.mongodb.host}")
    private String mongoHost;

    @Value("${spring.data.mongodb.port}")
    private String mongoPort;

    @Value("${spring.data.mongodb.authentication-database}")
    private String mongoAuthenticationDatabase;

    @Value("${spring.data.mongodb.username}")
    private String mongoUsername;

    @Value("${spring.data.mongodb.password}")
    private String mongoPassword;

    /**
     * mongodb://un:pw@ip:p/?authSource=admin
     */

    @Bean
    public MongoClient mongoClient() {
        String mongoURI = String.format(
                "mongodb://%s:%s@%s:%s/?authSource=%s",
                mongoUsername,
                mongoPassword,
                mongoHost,
                mongoPort,
                mongoAuthenticationDatabase
        );
        return MongoClients.create(mongoURI);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "database");
    }

}
