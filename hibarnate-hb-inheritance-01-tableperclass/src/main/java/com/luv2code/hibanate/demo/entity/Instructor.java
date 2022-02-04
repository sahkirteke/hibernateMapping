package com.luv2code.hibanate.demo.entity;

import javax.persistence.Entity;

@Entity 
public class Instructor extends User {

	
	private Double salary;
	
	
	public Instructor(String firstName, String lastName, String email, Double salary) {
		super(firstName, lastName, email);
		this.salary =salary;
		
	}

	public Instructor() {
		
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	

}
