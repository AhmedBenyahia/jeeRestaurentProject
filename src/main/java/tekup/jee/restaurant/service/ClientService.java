package tekup.jee.restaurant.service;

import java.util.List;

import tekup.jee.restaurant.model.Client;

/**
 * {@link ClientService } class.
 *
 * @author AhmedBenyahia
 * @since 0.0.1
 */
public interface ClientService {


	List<Client> getClients();

	void deleteClient(Long id);

	Client getClientById(Long id);

	Client saveOrUpdate(Client client);

	Client getClientFidel();

	String getMostReservedDate(Long id);
}
