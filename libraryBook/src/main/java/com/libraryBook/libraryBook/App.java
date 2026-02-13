package com.libraryBook.libraryBook;

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
            Book newBook =
                    new Book(1,"Can We be Stranger again?","Shreijeet Shandliya","Romance", 599.90,"Availabel",2022);;
            em.persist(newBook);

            // READ
            Book foundBook =
                    em.find(Book.class, 13);

            System.out.println("Found book: " + foundBook);

            // UPDATE
            if (foundBook != null) {
                foundBook.setTitle("Can we be Strangers Again?");
                foundBook.setAuthorName("Shrijeet Shandilya");
                em.merge(foundBook);
            }

            // DELETE
            Book bookToDelete =
                    em.find(Book.class, 2);

            if (bookToDelete != null) {
                em.remove(bookToDelete);
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
