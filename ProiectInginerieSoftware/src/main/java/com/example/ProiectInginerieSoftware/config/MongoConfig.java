package com.example.ProiectInginerieSoftware.config;


import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClientFactory;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.config.MongoConfigurationSupport;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;

@Configuration
@EnableMongoRepositories
@ConfigurationProperties("foo")
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Value("${spring.data.mongodb.host}")
    private String host;
    @Value("${spring.data.mongodb.port}")
    private int port;
    @Value("${spring.data.mongodb.database}")
    private String database;
    @Value("${spring.data.mongodb.authentication-database}")
    private String authDb;
    @Value("${spring.data.mongodb.username}")
    private String username;
    @Value("${spring.data.mongodb.password}")
    private String password;
    @Value("${spring.data.mongodb.auto-index-creation}")
    private String aid;

    @Override
    protected String getDatabaseName() {
        return database;
    }


    @Override
    public MongoClient mongoClient(){

        MongoCredential credential = MongoCredential.createCredential(username, database, password.toCharArray());

        MongoClientSettings settings = MongoClientSettings.builder()
                .credential(credential)
                .applyToSslSettings(builder -> builder.enabled(true))
                .applyToClusterSettings(builder ->
                        builder.hosts(Arrays.asList(new ServerAddress(host, port))))
                .build();

        MongoClient mongoClient = MongoClients.create(settings);
        return mongoClient;
    }

}