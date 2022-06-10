package com.hpecds.academy.microservice.kafka.statistics.consumer.model;

import java.io.Serializable;


public class SubstitutesModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4732312001399264512L;
	private int in;
	private int out;
	private int bench;

	public SubstitutesModel() {
		super();
	}

	public SubstitutesModel(int in, int out, int bench) {

		this.in = in;
		this.out = out;
		this.bench = bench;
	}

	public int getIn() {
		return in;
	}

	public void setIn(int in) {
		this.in = in;
	}

	public int getOut() {
		return out;
	}

	public void setOut(int out) {
		this.out = out;
	}

	public int getBench() {
		return bench;
	}

	public void setBench(int bench) {
		this.bench = bench;
	}

}
