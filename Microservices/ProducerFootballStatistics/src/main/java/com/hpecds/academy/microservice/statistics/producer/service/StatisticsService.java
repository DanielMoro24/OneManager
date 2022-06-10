package com.hpecds.academy.microservice.statistics.producer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hpecds.academy.microservice.statistics.producer.model.ApiResponseModel;

@Service
public class StatisticsService {

	private Integer season = 2021, league = 61;
	private UriComponents builder;

	private static final Logger LOGGER = LoggerFactory.getLogger(StatisticsService.class);

	@Autowired
	RestTemplate restTemplate;

	private HttpHeaders headers = new HttpHeaders();
	private ObjectMapper objectMapper = new ObjectMapper();

	public String[] getStatistics() {

		builder = UriComponentsBuilder.fromHttpUrl("https://v3.football.api-sports.io/players/topscorers")
				.queryParam("season", season).queryParam("league", league).build();

		headers.add("x-rapidapi-host", "v3.football.api-sports.io");
		headers.add("x-rapidapi-key", "68a01e74a5b9d3dcde5d755c48453e70");

		HttpEntity<?> entity = new HttpEntity<>(headers);
		ResponseEntity<ApiResponseModel> response = restTemplate.exchange(builder.toString(), HttpMethod.GET, entity,
				ApiResponseModel.class);
		ApiResponseModel res = response.getBody();

		try {
			String[] JsonRes = new String[res.getResponse().length];
			for (int i = 0; i < res.getResponse().length; i++) {

				JsonRes[i] = objectMapper.writeValueAsString(res.getResponse()[i]);
				LOGGER.info(JsonRes[i]);
			}

			return JsonRes;

		} catch (JsonProcessingException e) {
			LOGGER.error(e.getStackTrace().toString());

			return null;
		}

	}

	public String sendStatistics(String[] objects) {
		ResponseEntity<String> response = restTemplate.postForEntity("http://producerkafka:8181/send", objects,
				String.class);
		if (response.getBody().equals("ok")) {
			return "ok";
		} else {
			return "ko";
		}
	}
}
