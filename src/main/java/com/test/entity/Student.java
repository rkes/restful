package com.test.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
@Entity
@Table(name = "student")
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="roll")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int roll;
	
	@Column(name="className")
	private String className;
	
	@Column(name="name")
	private String name;
	
	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
