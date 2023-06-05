package org.example.first;

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

        Customer customer1 = new Customer("firstname1", "lastname1");
        Order order1 = new Order("01/01/2022");
        OrderLine orderLine1 = new OrderLine(2);
        Product product1 = new Product("TV", "Television");

        orderLine1.setProduct(product1);
        order1.addOrderLine(orderLine1);
        customer1.addOrder(order1);

        em.persist(customer1);

        em.getTransaction().commit();
        em.close();


        em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Customer> query = em.createQuery("from Customer ", Customer.class);

        List<Customer> customerList = query.getResultList();
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
        em.getTransaction().commit();
        em.close();
    }
}