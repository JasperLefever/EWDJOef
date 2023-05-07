package repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import domain.Guest;

public interface GuestRepository extends CrudRepository<Guest, Long> {

	List<Guest> findByName(String name);

    List<Guest> findByFirstname(String firstname);
    

    @Query("SELECT g FROM Guest g WHERE g.name LIKE CONCAT(:username,'%')")
    List<Guest> findByNameStartingWith(@Param("username") String username);
    
  //NamedQuery: Guest.findByNameStartingWith2
    List<Guest> findByNameStartingWith2(@Param("username") String username);

}
