package com.jeffersonlupinacci.App.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

/**
 * The MongoDB Configuration
 *
 * @author jeffersonlupinacci
 */
@Configuration
public class MongoConfig {

  @Value("${app.databaseName}")
  private String databaseName;

  @Bean
  public MongoClient mongoClient() {
    return MongoClients.create();
  }

  @Bean
  public ReactiveMongoTemplate reactiveMongoTemplate() {
    return new ReactiveMongoTemplate(mongoClient(), databaseName);
  }
}
