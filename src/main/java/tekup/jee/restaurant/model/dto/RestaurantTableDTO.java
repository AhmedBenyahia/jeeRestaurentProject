package tekup.jee.restaurant.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantTableDTO {

	private Long numeroTable;

	@Range(max = 12, min = 2)
	private Integer nbCouvert;

	@NotBlank(message = "type must not be Empty")
	private String type;

	private Double supplement;

	private List<TicketDTO> tickets;
}
