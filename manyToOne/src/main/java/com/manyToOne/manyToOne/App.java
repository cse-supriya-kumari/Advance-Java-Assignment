package com.manyToOne.manyToOne;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
            em = emf.createEntityManager();

            /* =========================
               CREATE
            ========================= */
            em.getTransaction().begin();

            Department dept = new Department("Electronics");

            Student s1 = new Student("Rohit", dept);
            Student s2 = new Student("Priya", dept);

            dept.setStudents(Arrays.asList(s1, s2));

            em.persist(dept); // cascade saves students

            em.getTransaction().commit();
            System.out.println("CREATE operation successful");

            /* =========================
               READ
            ========================= */
            System.out.println("\n--- READ OPERATION ---");

            Department fetchedDept = em.find(Department.class, dept.getId());
            System.out.println("Department: " + fetchedDept.getDeptName());

            List<Student> students = fetchedDept.getStudents();
            for (Student s : students) {
                System.out.println("Student: " + s.getName());
            }

            /* =========================
               UPDATE
            ========================= */
            em.getTransaction().begin();

            Student studentToUpdate = em.find(Student.class, s1.getId());
            studentToUpdate.setName("Rohit Sharma");

            em.getTransaction().commit();
            System.out.println("\nUPDATE operation successful");

            /* =========================
               DELETE
            ========================= */
            em.getTransaction().begin();

            Student studentToDelete = em.find(Student.class, s2.getId());
            em.remove(studentToDelete);

            em.getTransaction().commit();
            System.out.println("\nDELETE operation successful");

        } catch (Exception e) {

            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();

        } finally {

            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
            System.out.println("\nResources closed properly");
        }
    }
}
