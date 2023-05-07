package repository;

import domain.Campus;
import domain.Docent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DocentRepository extends CrudRepository<Docent, Integer>
{

    List<Docent> docentenInTweeCampussen(@Param("campusA") Campus campus1, @Param("campusB") Campus campus2);

	
}
