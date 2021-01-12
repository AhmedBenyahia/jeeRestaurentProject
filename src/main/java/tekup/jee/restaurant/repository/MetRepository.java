package tekup.jee.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tekup.jee.restaurant.model.Met;

/**
 * {@link MetRepository } class.
 *
 * @author AhmedBenyahia
 * @since 0.0.1
 */
@Repository
public interface MetRepository extends JpaRepository<Met, String>,
		CrudRepository<Met, String> {
}
