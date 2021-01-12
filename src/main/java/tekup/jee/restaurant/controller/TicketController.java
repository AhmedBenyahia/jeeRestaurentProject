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
import tekup.jee.restaurant.model.Met;
import tekup.jee.restaurant.model.Ticket;
import tekup.jee.restaurant.model.dto.RevenuReport;
import tekup.jee.restaurant.model.dto.TicketDTO;
import tekup.jee.restaurant.service.TicketService;

/**
 * {@link TicketController } class.
 *
 * @author AhmedBenyahia
 * @since 0.0.1
 */
@RestController
@RequestMapping("/ticket")
@AllArgsConstructor
public class TicketController {

	/** The Ticket service. */
	private final TicketService ticketService;

	/** The model mapper */
	private final ModelMapper mapper;

	@DeleteMapping("/delete/{id}")
	public void deleteTicket(@PathVariable("id") Long ticketId) {
		ticketService.deleteTicket(ticketId);
	}

	@GetMapping("/getAll")
	public List<Ticket> getAllTickets() {
		return ticketService.getTickets();
	}

	@GetMapping("/get/{id}")
	public Ticket getTicket(@PathVariable("id") Long id) {
		return ticketService.getTicketById(id);
	}

	@PostMapping("/createUpdate")
	public Ticket createOrUpdate(@RequestBody @Valid TicketDTO ticketDTO) {
		return ticketService.saveOrUpdate(mapper.map(ticketDTO, Ticket.class));
	}

	@GetMapping("/revenu/{start}/{end}")
	public Double getRevenuInRange(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end,
						  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @PathVariable LocalDateTime start) {
		return ticketService.getRevenuInRange(start, end);
	}

	@GetMapping("/revenuReport")
	public RevenuReport getRevenuReport() {
		return ticketService.getRevenuReport();
	}
}
