package com.employeeNests.employeeNests;

import jakarta.persistence.*;

import java.util.Arrays;
public class App 
{
	
    public static void main(String[] args) {

	        EntityManagerFactory emf =
	                Persistence.createEntityManagerFactory("myPersistenceUnit");

	        EntityManager em = emf.createEntityManager();

	        em.getTransaction().begin();

	  
	        Employee e1 = new Employee(101, "Rahul", "Developer", 60000);
	        Employee e2 = new Employee(102, "Priya", "Tester", 50000);
	        Employee e3 = new Employee(103, "Amit", "Manager", 80000);

	  
	        Department dept = new Department(
	                1,
	                "IT",
	                "Delhi",
	                Arrays.asList(e1, e2, e3)
	        );

	   
	        em.persist(dept);

	        em.getTransaction().commit();

	        System.out.println("Department and Employees saved successfully!");

	   

	        Department fetchedDept = em.find(Department.class, 1);

	        System.out.println("Department Name: " + fetchedDept.getName());

	        fetchedDept.getEmployees().forEach(emp ->
	                System.out.println(emp.getName() + " - " + emp.getDesignation())
	        );

	        em.close();
	        emf.close();
	    }
	}


