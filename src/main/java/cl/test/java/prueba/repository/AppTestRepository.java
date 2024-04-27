package cl.test.java.prueba.repository;

import cl.test.java.prueba.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AppTestRepository extends JpaRepository<Users, String> {

	@Query(value = "SELECT h FROM Users h where h.username= ?1")
	public Users findUser(String username);
	
}
