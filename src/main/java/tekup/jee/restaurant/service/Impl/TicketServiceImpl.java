package tekup.jee.restaurant.service.Impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tekup.jee.restaurant.model.Ticket;
import tekup.jee.restaurant.model.dto.RevenuReport;
import tekup.jee.restaurant.service.TicketService;
import tekup.jee.restaurant.repository.TicketRepository;

/**
 * {@link TicketService } class.
 *
 * @author AhmedBenyahia
 * @since 0.0.1
 */
@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {

	/**
	 * The Ticket service.
	 */
	private final TicketRepository ticketRepository;

	/**
	 * The model mapper
	 */
	private final ModelMapper mapper;

	@Override
	public List<Ticket> getTickets() {
		return ticketRepository.findAll();
	}

	@Override
	public void deleteTicket(Long id) {
		ticketRepository.deleteById(id);

	}

	@Override
	public Ticket getTicketById(Long id) {

		return ticketRepository.findById(id)
				.orElseThrow(NoSuchElementException::new);
	}

	@Override
	public Ticket saveOrUpdate(Ticket ticket) {
		ticket.setAddition((double) 0);
		if (ticket.getNumeroTicket() != null) {
			Ticket ticketOld = getTicketById(ticket.getNumeroTicket());
			ticket.getMets().addAll(ticketOld.getMets());
		}
		return ticketRepository.save(ticket);
	}

	@Override
	public List<Ticket> getTicketInRange(LocalDateTime start, LocalDateTime end) {
		return ticketRepository.findByDateBetween(start, end).orElse(new ArrayList<>());
	}
	
	@Override
	public Double getRevenuInRange(LocalDateTime start, LocalDateTime end) {
		return getTicketInRange(start, end).stream().mapToDouble(Ticket::getAddition).sum();
	}

	@Override
	public RevenuReport getRevenuReport() {

		RevenuReport revenuReport = new RevenuReport();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		LocalDateTime startTime = getLocalDateTime(cal);
		revenuReport.setDayRevenu(getRevenuInRange(startTime, startTime.plusDays(1)));

		cal.set(Calendar.DAY_OF_WEEK, 1);
		startTime = getLocalDateTime(cal);
		revenuReport.setWeekRevenu(getRevenuInRange(startTime, startTime.plusDays(6)));

		cal.set(Calendar.DAY_OF_MONTH, 1);
		startTime = getLocalDateTime(cal);
		revenuReport.setMonthRevenu(getRevenuInRange(startTime, startTime.plusDays(29)));

		return revenuReport;
	}

	private static LocalDateTime getLocalDateTime(Calendar calendar){

		return  LocalDateTime.ofInstant(calendar.toInstant(), calendar.getTimeZone().toZoneId());
	}

}
