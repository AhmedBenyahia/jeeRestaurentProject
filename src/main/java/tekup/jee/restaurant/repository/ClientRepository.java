package tekup.jee.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tekup.jee.restaurant.model.Client;

/**
 * {@link ClientRepository } class.
 *
 * @author AhmedBenyahia
 * @since 0.0.1
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long>,
		CrudRepository<Client, Long> {
}
