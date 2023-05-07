package main;

import domain.Docent;
import jakarta.persistence.EntityManager;
import util.JPAUtil;

import java.math.BigDecimal;

public class MAINOef1 {

    //drop and create
    public static void main(String args[]) {

        Docent d1 = new Docent(123, "Jan", "Baard", new BigDecimal(8000));
        Docent d2 = new Docent(456, "Piet", "Baard", new BigDecimal(10000));
        Docent d3 = new Docent(789, "Joris", "ZonderBaard", new BigDecimal(12000));

        //vraag aan de factory een entityManager
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

                ////start een transactie
                entityManager.getTransaction().begin();

                        ////persisteer de 3 objecten
                        entityManager.persist(d1);
                        entityManager.persist(d2);
                        entityManager.persist(d3);
                        //commit
                        entityManager.getTransaction().commit();

                        //sluit de entityManager
                        entityManager.close();

                        //sluit de factory
                        JPAUtil.getEntityManagerFactory().close();
    }
}
