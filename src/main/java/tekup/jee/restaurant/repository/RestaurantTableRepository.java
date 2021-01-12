package tekup.jee.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tekup.jee.restaurant.model.RestaurantTable;

/**
 * {@link RestaurantTableRepository } class.
 *
 * @author AhmedBenyahia
 * @since 0.0.1
 */
@Repository
public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, Long>,
		CrudRepository<RestaurantTable, Long> {
}
