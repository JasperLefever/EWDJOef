package repository;

import domain.Bier;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.NoResultException;

public class BierDaoJpa extends GenericDaoJpa<Bier> implements BierDao  {
    public BierDaoJpa() {
        super(Bier.class);
    }

    @Override
    public Bier getBierByName(String name) throws EntityNotFoundException {
        try {
            return em.createNamedQuery("Bier.findByName", Bier.class)
                 .setParameter("bierNaam", name)
                .getSingleResult();
        } catch (NoResultException ex) {
            throw new EntityNotFoundException();
        } 
    }
}
