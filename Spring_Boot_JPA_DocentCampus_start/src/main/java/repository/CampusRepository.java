package repository;

import domain.Campus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampusRepository extends CrudRepository<Campus, Integer>
{
	    Campus findByCampusNaam(String naam);
}
