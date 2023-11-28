package com.manu.camel.kafka.shoppingcart.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

	//private final String connectionString = "mongodb://localhost:27017/shoppingcart";

	@Value("${spring.data.mongodb.host}")
	private String host;

	@Value("${spring.data.mongodb.port}")
	private Integer port;

	@Value("${spring.data.mongodb.database}")
	private String database;

	@Bean("mongoClient")
	MongoClient getMongoClient() {
		return new MongoClient(host, port);
	}

    
      @Bean MongoTemplate mongoTemplate(@Qualifier("mongoClient") MongoClient
      mongoClient) { return new MongoTemplate(mongoClient, database); 
      }
      
      }
     
	/*
	 * @Bean MongoTemplate mongoTemplate() { MongoClientSettings settings =
	 * MongoClientSettings.builder() .applyConnectionString(new
	 * ConnectionString(connectionString)).build();
	 * 
	 * return new MongoTemplate(MongoClients.create(settings), "shoppingcart"); }
	 }
	 */
