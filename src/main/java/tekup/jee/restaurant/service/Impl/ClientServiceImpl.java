package tekup.jee.restaurant.service.Impl;

import javax.swing.*;
import java.time.DayOfWeek;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tekup.jee.restaurant.model.Client;
import tekup.jee.restaurant.service.ClientService;
import tekup.jee.restaurant.repository.ClientRepository;

/**
 * {@link ClientServiceImpl } class.
 *
 * @author AhmedBenyahia
 * @since 0.0.1
 */
@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

	/** The Client service. */
	private final ClientRepository clientRepository;

	/** The model mapper */
	private final ModelMapper mapper;


	@Override
	public List<Client> getClients() {
		return clientRepository.findAll();
	}

	@Override
	public void deleteClient(Long id) {
		clientRepository.deleteById(id);

	}

	@Override
	public Client getClientById(Long id) {

		return clientRepository.findById(id)
				.orElseThrow(NoSuchElementException::new);
	}

	@Override
	public Client saveOrUpdate(Client client) {
		return clientRepository.save(client);

	}

	@Override
	public Client getClientFidel() {
		List<Client> clients = getClients();
		return clients.stream().max(Comparator.comparingInt(client -> client.getTickets().size())).orElse(null);

	}

	@Override
	public String getMostReservedDate(Long id) {
		Client clientM = getClientById(id);
		HashMap<DayOfWeek, Integer> count = new HashMap<>();
		clientM.getTickets().forEach(ticket -> {
			count.merge(ticket.getDate().getDayOfWeek(), 1, Integer::sum);
		});
		return count.entrySet()
				.stream()
				.filter(dayOfWeekIntegerEntry -> dayOfWeekIntegerEntry.getValue().equals(Collections.max(count.values())))
				.findFirst().get().getKey().name();

	}


}
