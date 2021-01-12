package tekup.jee.restaurant.service;

import java.time.LocalDateTime;
import java.util.List;

import tekup.jee.restaurant.model.Ticket;
import tekup.jee.restaurant.model.dto.RevenuReport;

/**
 * {@link TicketService } class.
 *
 * @author AhmedBenyahia
 * @since 0.0.1
 */
public interface TicketService {

	List<Ticket> getTickets();

	void deleteTicket(Long id);

	Ticket getTicketById(Long id);

	Ticket saveOrUpdate(Ticket ticket);

	List<Ticket> getTicketInRange(LocalDateTime start, LocalDateTime end);

	Double getRevenuInRange(LocalDateTime start, LocalDateTime end);

	RevenuReport getRevenuReport();
}
