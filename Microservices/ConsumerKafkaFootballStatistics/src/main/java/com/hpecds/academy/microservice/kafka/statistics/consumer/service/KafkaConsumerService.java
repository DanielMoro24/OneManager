package com.hpecds.academy.microservice.kafka.statistics.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hpecds.academy.microservice.kafka.statistics.consumer.model.PlayerStatisticsModel;
import com.hpecds.academy.microservice.kafka.statistics.consumer.repository.KafkaConsumerRepository;

@Service
public class KafkaConsumerService {
	@Autowired
	KafkaConsumerRepository ConsumerRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerService.class);

	@KafkaListener(topics = "${kafka.topic}")
	public void receiveStatistics(String statistics) {
		try {
			jsonToModel(statistics);
			LOGGER.info(statistics);
		} catch (Exception e) {
			LOGGER.error(e.getStackTrace().toString());
		}
	}

	public void jsonToModel(String playerStatisticsJson) {

		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(Feature.ALLOW_UNQUOTED_FIELD_NAMES);
		mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
		try {
			PlayerStatisticsModel playerStatistics = mapper.readValue(playerStatisticsJson,
					PlayerStatisticsModel.class);
			
			ConsumerRepository.save(playerStatistics);
		} catch (Exception e) {
			LOGGER.error(e.getStackTrace().toString());
			System.out.println(e);
		}
	}

}
