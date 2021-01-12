package tekup.jee.restaurant.controller;

import javax.validation.Valid;
import java.util.List;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tekup.jee.restaurant.model.RestaurantTable;
import tekup.jee.restaurant.model.dto.RestaurantTableDTO;
import tekup.jee.restaurant.service.RestaurantTableService;

/**
 * {@link RestaurantTableController } class.
 *
 * @author AhmedBenyahia
 * @since 0.0.1
 */
@RestController
@RequestMapping("/restauranttable")
@AllArgsConstructor
public class RestaurantTableController {

	/** The RestaurantTable service. */
	private final RestaurantTableService restaurantTableService;

	/** The model mapper */
	private final ModelMapper mapper;

	@DeleteMapping("/delete/{id}")
	public void deleteRestaurantTable(@PathVariable("id") Long clientId) {
		restaurantTableService.deleteRestaurantTable(clientId);
	}

	@GetMapping("/getAll")
	public List<RestaurantTable> getAllRestaurantTables() {
		return restaurantTableService.getRestaurantTables();
	}

	@GetMapping("/getMostReserved")
	public RestaurantTable getMostReservedTable() {
		return restaurantTableService.getMostReservedTable();
	}

	@GetMapping("/get/{id}")
	public RestaurantTable getRestaurantTable(@PathVariable("id") Long id) {
		return restaurantTableService.getRestaurantTableById(id);
	}

	@PostMapping("/createUpdate")
	public RestaurantTable createOrUpdate(@RequestBody @Valid RestaurantTableDTO restaurantTableDTO) {
		return restaurantTableService.saveOrUpdate(mapper.map(restaurantTableDTO, RestaurantTable.class));
	}
}
