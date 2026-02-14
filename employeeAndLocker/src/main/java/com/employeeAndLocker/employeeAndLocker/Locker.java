package com.employeeAndLocker.employeeAndLocker;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "locker")
public class Locker {

	@Id
	private int lockerId;

	private String lockerNumber;
	private int floor;

	public Locker() {
	}

	public Locker(int lockerId, String lockerNumber, int floor) {
		this.lockerId = lockerId;
		this.lockerNumber = lockerNumber;
		this.floor = floor;
	}

	// Getters and Setters
	public int getLockerId() {
		return lockerId;
	}

	public void setLockerId(int lockerId) {
		this.lockerId = lockerId;
	}

	public String getLockerNumber() {
		return lockerNumber;
	}

	public void setLockerNumber(String lockerNumber) {
		this.lockerNumber = lockerNumber;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}
}
