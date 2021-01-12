package tekup.jee.restaurant.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tekup.jee.restaurant.model.Ticket;

/**
 * {@link TicketRepository } class.
 *
 * @author AhmedBenyahia
 * @since 0.0.1
 */
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>,
		CrudRepository<Ticket, Long> {
	Optional<List<Ticket>> findByDateBetween(LocalDateTime startDate, LocalDateTime endDate);
}
