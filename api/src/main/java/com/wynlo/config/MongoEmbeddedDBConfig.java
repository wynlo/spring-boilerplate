package com.wynlo.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@Profile("local")
public class MongoEmbeddedDBConfig {

    @Value("${spring.data.mongodb.host}")
    private String mongoHost;

    @Value("${spring.data.mongodb.port}")
    private String mongoPort;

    /**
     * mongodb://ip:p
     */

    @Bean
    public MongoClient mongoClient() {
        String mongoURI = String.format(
                "mongodb://%s:%s",
                mongoHost,
                mongoPort
        );
        return MongoClients.create(mongoURI);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "database");
    }

}
