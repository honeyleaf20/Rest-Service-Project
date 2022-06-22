package com.example.demo.controller;


import javax.persistence.Entity;


import org.springframework.data.annotation.Id;

@Entity
public class Employee {
    @Id
	private int id;
	private String name;
	private String place;
	private String role;
	private float salary;
	
	public Employee() {
		
	}
	public Employee(int id, String name, String place, String role, float salary) {
		this.id = id;
		this.name = name;
		this.place = place;
		this.role = role;
		this.salary = salary;
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
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	
}
