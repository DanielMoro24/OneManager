package com.hpecds.academy.microservice.kafka.statistics.consumer.model;

import java.io.Serializable;

public class CardsModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9175268324902601166L;
	private int yellow;
	private int yellowred;
	private int red;

	public CardsModel() {
		super();
	}

	public CardsModel(int yellow, int yellowred, int red) {

		this.yellow = yellow;
		this.yellowred = yellowred;
		this.red = red;
	}

	public int getYellow() {
		return yellow;
	}

	public void setYellow(int yellow) {
		this.yellow = yellow;
	}

	public int getYellowred() {
		return yellowred;
	}

	public void setYellowred(int yellowred) {
		this.yellowred = yellowred;
	}

	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		this.red = red;
	}

}
