package tekup.jee.restaurant.service.Impl;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tekup.jee.restaurant.model.Client;
import tekup.jee.restaurant.model.RestaurantTable;
import tekup.jee.restaurant.service.RestaurantTableService;
import tekup.jee.restaurant.repository.RestaurantTableRepository;

/**
 * {@link RestaurantTableServiceImpl } class.
 *
 * @author AhmedBenyahia
 * @since 0.0.1
 */
@Service
@AllArgsConstructor
public class RestaurantTableServiceImpl implements RestaurantTableService {

	/** The RestaurantTable service. */
	private final RestaurantTableRepository restaurantTableRepository;

	/** The model mapper */
	private final ModelMapper mapper;

	@Override
	public List<RestaurantTable> getRestaurantTables() {
		return restaurantTableRepository.findAll();
	}

	@Override
	public void deleteRestaurantTable(Long id) {
		restaurantTableRepository.deleteById(id);

	}

	@Override
	public RestaurantTable getRestaurantTableById(Long id) {

		return restaurantTableRepository.findById(id)
				.orElseThrow(NoSuchElementException::new);
	}

	@Override
	public RestaurantTable saveOrUpdate(RestaurantTable ticket) {
		return restaurantTableRepository.save(ticket);

	}

	@Override
	public RestaurantTable getMostReservedTable() {
		List<RestaurantTable> restaurantTables = getRestaurantTables();
		return restaurantTables.stream().max(Comparator.comparingInt(restaurantTable -> restaurantTable.getTickets().size())).orElse(null);
	}

}
