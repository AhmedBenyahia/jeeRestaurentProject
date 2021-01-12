package tekup.jee.restaurant.model.dto;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDTO {

	private Long numeroTicket;

	@Future
	private LocalDateTime date;

	@Range(max = 12, min = 1)
	private Integer nbCouvert;

	private Double addition;

	@NotNull
	private RestaurantTableDTO tables;

	@NotNull
	private ClientDTO client;

	private Set<MetDTO> mets;
}
