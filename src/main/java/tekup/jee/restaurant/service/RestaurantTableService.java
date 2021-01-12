package tekup.jee.restaurant.service;

import java.util.List;

import tekup.jee.restaurant.model.RestaurantTable;

/**
 * {@link RestaurantTableService } class.
 *
 * @author AhmedBenyahia
 * @since 0.0.1
 */
public interface RestaurantTableService {

	List<RestaurantTable> getRestaurantTables();

	void deleteRestaurantTable(Long id);

	RestaurantTable getRestaurantTableById(Long id);

	RestaurantTable saveOrUpdate(RestaurantTable ticket);

	RestaurantTable getMostReservedTable();
}
