package com.employeeAndLocker.employeeAndLocker;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App 
{

	    public static void main(String[] args) {

	        EntityManagerFactory emf =
	                Persistence.createEntityManagerFactory("mypersistenceunit");

	        EntityManager em = emf.createEntityManager();

	        em.getTransaction().begin();

	        // Create Locker
	        Locker locker = new Locker(101, "L-01", 2);

	        // Create Employee and assign locker
	        Employee emp = new Employee(1, "Supriya", "IT", locker);

	        em.persist(emp);   // Locker also saved due to CascadeType.ALL

	        em.getTransaction().commit();

	        // Retrieve Employee
	        Employee fetchedEmp = em.find(Employee.class, 1);

	        System.out.println("Employee Name: " + fetchedEmp.getName());
	        System.out.println("Department: " + fetchedEmp.getDepartment());
	        System.out.println("Locker Number: " + fetchedEmp.getLocker().getLockerNumber());
	        System.out.println("Locker Floor: " + fetchedEmp.getLocker().getFloor());

	        em.close();
	        emf.close();
	    }
	}


