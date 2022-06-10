package com.hpecds.academy.microservice.kafka.statistics.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
@EnableMongoRepositories("com.hpecds.academy.microservice.kafka.statistics.consumer.repository")
public class ConsumerKafkaFootballStatisticsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerKafkaFootballStatisticsApplication.class, args);
	}

}
