package com.hpecds.academy.microservice.kafka.statistics.consumer.model;

import java.io.Serializable;


public class PenaltyModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5998199406036104188L;
	private int won;
	private int commited;
	private int scored;
	private int missed;
	private int saved;

	public PenaltyModel() {
		super();
	}

	public PenaltyModel(int won, int commited, int scored, int missed, int saved) {

		this.won = won;
		this.commited = commited;
		this.scored = scored;
		this.missed = missed;
		this.saved = saved;
	}

	public int getWon() {
		return won;
	}

	public void setWon(int won) {
		this.won = won;
	}

	public int getCommited() {
		return commited;
	}

	public void setCommited(int commited) {
		this.commited = commited;
	}

	public int getScored() {
		return scored;
	}

	public void setScored(int scored) {
		this.scored = scored;
	}

	public int getMissed() {
		return missed;
	}

	public void setMissed(int missed) {
		this.missed = missed;
	}

	public int getSaved() {
		return saved;
	}

	public void setSaved(int saved) {
		this.saved = saved;
	}

}
