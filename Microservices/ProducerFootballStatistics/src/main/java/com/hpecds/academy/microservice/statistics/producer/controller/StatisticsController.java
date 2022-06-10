package com.hpecds.academy.microservice.statistics.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hpecds.academy.microservice.statistics.producer.service.StatisticsService;

@RestController
public class StatisticsController {
	private StatisticsService statisticsService;

	@Autowired
	public StatisticsController(StatisticsService statisticsService) {
		super();
		this.statisticsService = statisticsService;
	}

	@GetMapping(value = "/players/topscorers")
	public String getStatistics() {

		return statisticsService.sendStatistics(statisticsService.getStatistics());
	}

}
