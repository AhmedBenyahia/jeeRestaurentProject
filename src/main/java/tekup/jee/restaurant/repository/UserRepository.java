package tekup.jee.restaurant.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tekup.jee.restaurant.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, CrudRepository<User, Long> {

	Optional<User> findByUsername(String username);
	//Optional<User> findByEmail(String Email);

}
