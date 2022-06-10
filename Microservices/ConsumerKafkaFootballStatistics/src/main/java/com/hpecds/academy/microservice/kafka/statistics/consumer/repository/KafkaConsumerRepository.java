package com.hpecds.academy.microservice.kafka.statistics.consumer.repository;

import org.springframework.stereotype.Repository;

import com.hpecds.academy.microservice.kafka.statistics.consumer.model.PlayerStatisticsModel;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface KafkaConsumerRepository extends MongoRepository<PlayerStatisticsModel, String> {

}
