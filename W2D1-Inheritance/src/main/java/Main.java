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
        OrderLine orderLine2 = new OrderLine(5);
        OrderLine orderLine3 = new OrderLine(9);
        Product product1 = new CD("CD", "Compact Disc", "Artist");
        Product product2 = new Book("Book", "My favourite book", "Title");
        Product product3 = new DVD("DVD", "Digital Versatile Disc", "Genre");

        orderLine1.setProduct(product1);
        orderLine2.setProduct(product2);
        orderLine3.setProduct(product3);

        order1.addOrderLine(orderLine1);
        order1.addOrderLine(orderLine2);
        order1.addOrderLine(orderLine3);

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