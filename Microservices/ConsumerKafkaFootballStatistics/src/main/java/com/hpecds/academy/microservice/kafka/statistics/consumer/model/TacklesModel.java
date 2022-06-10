package com.hpecds.academy.microservice.kafka.statistics.consumer.model;

import java.io.Serializable;


public class TacklesModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1061307363881972519L;
	private int total;
	private int blocks;
	private int interceptions;

	public TacklesModel() {
		super();
	}

	public TacklesModel(int total, int blocks, int interceptions) {

		this.total = total;
		this.blocks = blocks;
		this.interceptions = interceptions;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getBlocks() {
		return blocks;
	}

	public void setBlocks(int blocks) {
		this.blocks = blocks;
	}

	public int getInterceptions() {
		return interceptions;
	}

	public void setInterceptions(int interceptions) {
		this.interceptions = interceptions;
	}

}
