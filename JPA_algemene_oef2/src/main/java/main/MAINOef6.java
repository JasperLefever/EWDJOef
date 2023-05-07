package main;

import domain.Campus;
import domain.Docent;
import domain.Werkruimte;
import jakarta.persistence.EntityManager;
import util.JPAUtil;

import java.util.List;

public class MAINOef6 {

    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

        entityManager.getTransaction().begin();


        Werkruimte werkruimte = entityManager.find(Werkruimte.class, "SCH555");


        Campus campusGent = entityManager.createNamedQuery("Campus.findByName", Campus.class)
                .setParameter("name", "Gent")
                .getSingleResult();

        Campus campusAalst = entityManager.createNamedQuery("Campus.findByName", Campus.class)
                .setParameter("name", "Aalst")
                .getSingleResult();

        List<Docent> docentList;
        if (campusGent != null && campusAalst != null && werkruimte != null) {
            docentList = entityManager.createNamedQuery("Docent.docentenInTweeCampussen", Docent.class)
                    .setParameter("campus1", campusGent)
                    .setParameter("campus2", campusAalst)
                    .getResultList();
            docentList.forEach(docent -> {
                docent.setWerkruimte(werkruimte);
            });
        }

        entityManager.getTransaction().commit();

        entityManager.close();

        JPAUtil.getEntityManagerFactory().close();
    }
}
