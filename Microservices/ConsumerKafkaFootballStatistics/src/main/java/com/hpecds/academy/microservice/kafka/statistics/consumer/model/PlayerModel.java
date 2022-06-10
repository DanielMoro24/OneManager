package com.hpecds.academy.microservice.kafka.statistics.consumer.model;

import java.io.Serializable;


public class PlayerModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6273415895895955233L;

	private int id;
	private String name;
	private String firstname;
	private String lastname;
	private int age;
	private BirthModel birth;
	private String nationality;
	private String height;
	private String weight;
	private boolean injured;
	private String photo;

	public PlayerModel() {
		super();
	}

	public PlayerModel(int id, String name, String firstname, String lastname, int age, BirthModel birth,
			String nationality, String height, String weight, boolean injured, String photo) {

		this.id = id;
		this.name = name;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.birth = birth;
		this.nationality = nationality;
		this.height = height;
		this.weight = weight;
		this.injured = injured;
		this.photo = photo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public BirthModel getBirth() {
		return birth;
	}

	public void setBirth(BirthModel birth) {
		this.birth = birth;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public boolean isInjured() {
		return injured;
	}

	public void setInjured(boolean injured) {
		this.injured = injured;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
