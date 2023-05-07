package main;

import domain.Docent;
import jakarta.persistence.EntityManager;
import util.JPAUtil;

public class MAINOef2 {

    //create
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

        entityManager.getTransaction().begin();

        Docent docent = entityManager.find(Docent.class, 2L);

        if(docent != null){
        docent.opslag(new java.math.BigDecimal(200));
        } else {
            System.out.println("domain.Docent niet gevonden");
        }

        entityManager.getTransaction().commit();

        entityManager.close();
        JPAUtil.getEntityManagerFactory().close();
    }
}
