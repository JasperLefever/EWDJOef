package repository;

import domain.Werkruimte;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WerkruimteRepository extends CrudRepository<Werkruimte, String> {
}