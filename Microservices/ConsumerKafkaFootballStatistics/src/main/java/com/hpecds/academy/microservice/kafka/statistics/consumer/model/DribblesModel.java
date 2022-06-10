package com.hpecds.academy.microservice.kafka.statistics.consumer.model;

import java.io.Serializable;


public class DribblesModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5527409605968194979L;
	private int attempts;
	private int success;
	private int past;

	public DribblesModel() {
		super();
	}

	public DribblesModel(int attempts, int success, int past) {

		this.attempts = attempts;
		this.success = success;
		this.past = past;
	}

	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public int getSuccess() {
		return success;
	}

	public void setSuccess(int success) {
		this.success = success;
	}

	public int getPast() {
		return past;
	}

	public void setPast(int past) {
		this.past = past;
	}

}
