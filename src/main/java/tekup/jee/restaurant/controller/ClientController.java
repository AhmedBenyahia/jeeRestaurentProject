package tekup.jee.restaurant.controller;

import javax.validation.Valid;
import java.time.LocalDate;
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
import tekup.jee.restaurant.model.Client;
import tekup.jee.restaurant.model.dto.ClientDTO;
import tekup.jee.restaurant.service.ClientService;

/**
 * {@link ClientController } class.
 *
 * @author AhmedBenyahia
 * @since 0.0.1
 */
@RestController
@RequestMapping("/client")
@AllArgsConstructor
public class ClientController {

	/** The Client service. */
	private final ClientService clientService;

	/** The model mapper */
	private final ModelMapper mapper;

	@DeleteMapping("/delete/{id}")
	public void deleteClient(@PathVariable("id") Long clientId) {
		 clientService.deleteClient(clientId);
	}

	@GetMapping("/getAll")
	public List<Client> getAllClients() {
		 return clientService.getClients();
	}

	@GetMapping("/clientFidel")
	public Client getClientFidel() {
		 return clientService.getClientFidel();
	}

	@GetMapping("/mostReservedDate/{id}")
	public String getMostReservedDate(@PathVariable Long id) {
		 return clientService.getMostReservedDate(id);
	}

	@GetMapping("/get/{id}")
	public Client getClient(@PathVariable("id") Long id) {
		 return clientService.getClientById(id);
	}

	@PostMapping("/createUpdate")
	public Client createOrUpdate(@RequestBody @Valid ClientDTO clientDTO ) {
		return clientService.saveOrUpdate(mapper.map(clientDTO, Client.class));
	}
}
