package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class Main {
    private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544_w2d1");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Doctor doctor = new Doctor("Eye doctor", "Frank", "Brown");
        em.persist(doctor);

        Patient patient = new Patient("John Doe", "100 Main Street", "23114", "Boston");
        em.persist(patient);

        Payment payment = new Payment("12/06/08", 100);
        Appointment appointment = new Appointment("15/05/08", patient, payment, doctor);
        em.persist(appointment);

        em.getTransaction().commit();
        em.close();
    }
}