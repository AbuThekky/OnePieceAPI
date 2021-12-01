package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class API {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer strength_id;
	private String name;
	private String bounty;
	private String devil_fruit;
	private String crew;
	private String position;
	
	public API() {
		
	}

	public API(Integer id, Integer strength_id, String name, String bounty, String devil_fruit, String crew, String position) {
		super();
		this.id = id;
		this.strength_id = strength_id;
		this.name = name;
		this.bounty = bounty;
		this.devil_fruit = devil_fruit;
		this.crew = crew;
		this.position = position;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBounty() {
		return bounty;
	}

	public void setBounty(String bounty) {
		this.bounty = bounty;
	}

	public String getDevil_fruit() {
		return devil_fruit;
	}

	public void setDevil_fruit(String devil_fruit) {
		this.devil_fruit = devil_fruit;
	}

	public String getCrew() {
		return crew;
	}

	public void setCrew(String crew) {
		this.crew = crew;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Integer getStrength_id() {
		return strength_id;
	}

	public void setStrength_id(Integer strength_id) {
		this.strength_id = strength_id;
	}
	
	
	
	
	

}
