package com.employeeAndLocker.employeeAndLocker;



import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	private int employeeId;

	private String name;
	private String department;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "locker_id", unique = true)
	private Locker locker;

	public Employee() {
	}

	public Employee(int employeeId, String name, String department, Locker locker) {
		this.employeeId = employeeId;
		this.name = name;
		this.department = department;
		this.locker = locker;
	}

	// Getters and Setters
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Locker getLocker() {
		return locker;
	}

	public void setLocker(Locker locker) {
		this.locker = locker;
	}
}
