package tekup.jee.restaurant.service.Impl;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tekup.jee.restaurant.model.Met;
import tekup.jee.restaurant.model.Ticket;
import tekup.jee.restaurant.service.MetService;
import tekup.jee.restaurant.repository.MetRepository;
import tekup.jee.restaurant.service.TicketService;

/**
 * {@link MetServiceImpl } class.
 *
 * @author AhmedBenyahia
 * @since 0.0.1
 */
@Service
@AllArgsConstructor
public class MetServiceImpl implements MetService {

	/** The Met service. */
	private final MetRepository metRepository;

	/** The ticket service. */
	private final TicketService ticketService;

	/** The model mapper */
	private final ModelMapper mapper;

	@Override
	public List<Met> getMets() {
		return metRepository.findAll();
	}

	@Override
	public void deleteMet(String name) {
		metRepository.deleteById(name);

	}

	@Override
	public Met getMetById(String name) {

		return metRepository.findById(name)
				.orElseThrow(NoSuchElementException::new);
	}

	@Override
	public Met saveOrUpdate(Met met) {
		return metRepository.save(met);

	}

	@Override
	public Met getMostSoldMet(LocalDateTime start, LocalDateTime end) {
		List<Ticket> tickets = ticketService.getTicketInRange(start, end);
		Met mostSoldMet = null;
		if (tickets.size() != 0) {
			HashMap<String, Integer> metCount = new HashMap<>();
			tickets.forEach(ticket -> ticket.getMets().forEach(met -> {
				Integer occ = metCount.get(met.getNomMet());
				if (metCount.containsKey(met.getNomMet())) {
					metCount.put(met.getNomMet(), occ + 1);
				}
				else {
					metCount.put(met.getNomMet(), 1);
				}
			}));
			List<Map.Entry<String, Integer>> mets = metCount.entrySet().stream()
					.filter(entry -> entry.getValue().equals(Collections.max(metCount.values())))
					.collect(Collectors.toList());
			if (mets.size() != 0) {
				mostSoldMet = getMetById(mets.get(0).getKey());
			}
		}
		
		return mostSoldMet;
	}
}
