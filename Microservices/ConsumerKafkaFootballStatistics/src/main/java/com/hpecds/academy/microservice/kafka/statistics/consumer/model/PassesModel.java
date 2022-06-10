package com.hpecds.academy.microservice.kafka.statistics.consumer.model;

import java.io.Serializable;


public class PassesModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1055453673057875333L;
	private int total;
	private int key;
	private int accuracy;

	public PassesModel() {
		super();
	}

	public PassesModel(int total, int key, int accuracy) {

		this.total = total;
		this.key = key;
		this.accuracy = accuracy;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

}
