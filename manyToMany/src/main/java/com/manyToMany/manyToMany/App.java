package com.manyToMany.manyToMany;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
       EntityManager em = emf.createEntityManager();

       try {
       em.getTransaction().begin();
       
       Project p1 = new Project("Banking System");
       Project p2 = new Project("Insureance System");
       
       
       Set<Project> projectSet = new HashSet<>();
       Employee emp1 = new Employee("Jhon", projectSet);
       Employee emp2 = new Employee("Sup", projectSet);
       
       Set<Employee> employeeSet = new HashSet<>();
       employeeSet.add(emp1);
       employeeSet.add(emp2);
       
       p1.setEmployees(employeeSet);
       p2.setEmployees(employeeSet);
       
       em.persist(emp1);
       em.persist(emp2);
       
       em.getTransaction().commit();}
    catch(Exception e) {
    	System.out.println(e.getMessage());
    }finally {
    	em.close();
    	emf.close();
    }
    }
}
