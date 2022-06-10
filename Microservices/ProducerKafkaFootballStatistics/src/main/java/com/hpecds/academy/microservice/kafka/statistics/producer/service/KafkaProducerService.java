package com.hpecds.academy.microservice.kafka.statistics.producer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
	private String playerStatistics;

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerService.class);

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Value("${kafka.topic}")
	private String topic;

	public void sendStatisticsToKafka(String[] statistics) {
		for (int i = 0; i < statistics.length; i++) {
			try {
				playerStatistics = statistics[i];
				kafkaTemplate.send(topic, playerStatistics);
				LOGGER.info(playerStatistics);
			} catch (Exception e) {
				LOGGER.error(e.getStackTrace().toString());
			}

		}

	}

}
