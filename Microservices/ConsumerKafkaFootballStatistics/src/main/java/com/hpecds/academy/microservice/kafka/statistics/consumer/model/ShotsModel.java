package com.hpecds.academy.microservice.kafka.statistics.consumer.model;

import java.io.Serializable;


public class ShotsModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6915522733448852038L;
	private int total;
	private int on;

	public ShotsModel() {
		super();
	}

	public ShotsModel(int total, int on) {

		this.total = total;
		this.on = on;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getOn() {
		return on;
	}

	public void setOn(int on) {
		this.on = on;
	}

}
