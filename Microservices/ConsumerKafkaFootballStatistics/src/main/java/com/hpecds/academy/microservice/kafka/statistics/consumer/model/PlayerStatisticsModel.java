package com.hpecds.academy.microservice.kafka.statistics.consumer.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "playerStatistics")
public class PlayerStatisticsModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3921310690058418787L;
	private PlayerModel player;
	private StatisticsModel[] statistics;

	public PlayerStatisticsModel() {
		super();
	}

	public PlayerStatisticsModel(PlayerModel player, StatisticsModel[] statistics) {

		this.player = player;
		this.statistics = statistics;
	}

	public PlayerModel getPlayer() {
		return player;
	}

	public void setPlayer(PlayerModel player) {
		this.player = player;
	}

	public StatisticsModel[] getStatistics() {
		return statistics;
	}

	public void setStatistics(StatisticsModel[] statistics) {
		this.statistics = statistics;
	}

}
