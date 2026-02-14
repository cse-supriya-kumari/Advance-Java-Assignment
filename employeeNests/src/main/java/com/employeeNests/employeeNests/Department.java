package com.employeeNests.employeeNests;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Department {

	@Id
	private int id;
	private String name;
	private String location;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "dept_id")

	private List<Employee> employees;

	public Department() {
	}

	public Department(int id, String name, String location, List<Employee> employees) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.employees = employees;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
