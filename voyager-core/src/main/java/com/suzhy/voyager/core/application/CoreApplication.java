package com.suzhy.voyager.core.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = "com.suzhy.voyager.core")
@EnableMongoRepositories(basePackages = {"com.suzhy.voyager.core.repository", "com.suzhy.voyager.core.mongo.repository"})
@EnableCaching
public class CoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}

}
