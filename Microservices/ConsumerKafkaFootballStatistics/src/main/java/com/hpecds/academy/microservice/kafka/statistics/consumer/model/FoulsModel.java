package com.hpecds.academy.microservice.kafka.statistics.consumer.model;

import java.io.Serializable;


public class FoulsModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4561006936097257853L;
	private int drawn;
	private int committed;

	public FoulsModel() {
		super();
	}

	public FoulsModel(int drawn, int committed) {

		this.drawn = drawn;
		this.committed = committed;
	}

	public int getDrawn() {
		return drawn;
	}

	public void setDrawn(int drawn) {
		this.drawn = drawn;
	}

	public int getCommitted() {
		return committed;
	}

	public void setCommitted(int committed) {
		this.committed = committed;
	}

}
