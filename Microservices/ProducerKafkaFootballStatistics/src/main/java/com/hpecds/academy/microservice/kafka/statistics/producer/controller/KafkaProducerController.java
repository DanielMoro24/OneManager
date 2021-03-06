package com.hpecds.academy.microservice.kafka.statistics.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hpecds.academy.microservice.kafka.statistics.producer.service.KafkaProducerService;

@RestController
public class KafkaProducerController {
	private KafkaProducerService kafkaProducerService;

	@Autowired
	public KafkaProducerController(KafkaProducerService kafkaProducerService) {
		super();
		this.kafkaProducerService = kafkaProducerService;
	}

	@PostMapping(value = "/send", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> sendStatistics(@RequestBody String[] statistics) {
		if (statistics != null) {
			kafkaProducerService.sendStatisticsToKafka(statistics);
			return new ResponseEntity<>("ok", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("ko", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
