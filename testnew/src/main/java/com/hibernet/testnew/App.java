package com.hibernet.testnew;

/**
 * Hello world!
 *
 */


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class App {
    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("myPersistenceUnit");

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // ---------------- CUSTOMER OPERATIONS ----------------

            // INSERT
            Customer newCustomer =
                    new Customer(13, "John Johnson", "Chicago");

            em.persist(newCustomer);

            // READ
            Customer foundCustomer =
                    em.find(Customer.class, 13);

            System.out.println("Found Customer: " + foundCustomer);

            // UPDATE
            if (foundCustomer != null) {
                foundCustomer.setName("Alice Updated");
                foundCustomer.setCity("Seattle");
                em.merge(foundCustomer);
            }

            // DELETE
            Customer customerToDelete =
                    em.find(Customer.class, 13);

            if (customerToDelete != null) {
                em.remove(customerToDelete);
            }

            // ---------------- EMPLOYEE OPERATIONS ----------------

            // Create Address
            Address address =
                    new Address("Delhi", "Delhi", "India");

            // Create Employee
            Employee employee =
                    new Employee(31, "Rahul", address);

            // Save Employee
            em.persist(employee);

            // Fetch Employee
            Employee foundEmployee =
                    em.find(Employee.class, 31);

            if (foundEmployee != null) {
                System.out.println("Employee: " +
                        foundEmployee.getName() +
                        ", City: " +
                        foundEmployee.getAddress().getCity());
            }

            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}