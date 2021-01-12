package tekup.jee.restaurant.controller;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tekup.jee.restaurant.model.Client;
import tekup.jee.restaurant.model.Met;
import tekup.jee.restaurant.model.dto.MetDTO;
import tekup.jee.restaurant.service.MetService;

/**
 * {@link MetController } class.
 *
 * @author AhmedBenyahia
 * @since 0.0.1
 */
@RestController
@RequestMapping("/met")
@AllArgsConstructor
public class MetController {

	/** The Met service. */
	private final MetService metService;

	/** The model mapper */
	private final ModelMapper mapper;

	@DeleteMapping("/delete/{id}")
	public void deleteClient(@PathVariable("id") String nomMet) {
		metService.deleteMet(nomMet);
	}

	@GetMapping("/getAll")
	public List<Met> getAllMets() {
		return metService.getMets();
	}

	@GetMapping("/getMostSold/{start}/{end}")
	public Met getAllMets(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end,
						  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @PathVariable LocalDateTime start) {
		return metService.getMostSoldMet(start, end);
	}

	@GetMapping("/get/{id}")
	public Met getMet(@PathVariable("id") String nomMet) {
		return metService.getMetById(nomMet);
	}

	@PostMapping("/createUpdate")
	public Met createOrUpdate(@RequestBody @Valid MetDTO metDTO) {
		return metService.saveOrUpdate(mapper.map(metDTO, Met.class));
	}
}
