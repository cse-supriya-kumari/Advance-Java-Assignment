package com.mapingHibernate.mapingHibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
      
      Account account = new Account("ACC12345", "Saving");
      Account account2 = new Account("VFGf4374", "Salary");
      Account account3 = new Account("VFGf4374", "Salary");
      
      Customer customer = new Customer("Supriya",account);
      Customer customer2 = new Customer("Alok",account2);
      Customer customer3 = new Customer("Abdul",account3);
      
      account.setCustomer(customer);
      em.persist(customer);
      
      account.setCustomer(customer2);
      em.persist(customer2);
      
      account.setCustomer(customer3);
      em.persist(customer3);
      
      Customer foundCustomer = em.find(Customer.class,1 );
      System.out.println("Found Customer: "+foundCustomer);
      
      if(foundCustomer != null) {
    	  Account account4 = new Account("ACC123905", "Saving");
    	  foundCustomer.setAccount(account4);
    	  System.out.println("Update Account: "+ foundCustomer);
      }
      
      Customer customerToDelete = em.find(Customer.class,3);
      Account accountToDelete = em.find(Account.class,3);
      if(customerToDelete != null && accountToDelete != null) {
    	  em.remove(customerToDelete);
    	  em.remove(accountToDelete);
    	  System.out.println("Delete Customer: "+customerToDelete);
    	  System.out.println("Delete Account: "+accountToDelete);
      }
      else {
    	  System.out.println("Customer or Account Not found");
      }
      em.getTransaction().commit();
      System.out.println("Customer and account Saved Sucessfully!");
      }
      catch(Exception e) {
    	  e.printStackTrace();
    	  em.getTransaction().rollback();
      }
      finally {
    	  em.close();
    	  em.close();
      }
    }
}
