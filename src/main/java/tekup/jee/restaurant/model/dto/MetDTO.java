package tekup.jee.restaurant.model.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tekup.jee.restaurant.model.TypeMet;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetDTO {

	@NotNull (message = "nomMet must not Null nor Empty")
	@NotEmpty(message = "nomMet must not Null nor Empty")
	private String nomMet;

	@NotNull(message = "Price must not Null")
	private Double prix;

	@Null
	private Set<TicketDTO> tickets;

	@NotNull
	private TypeMet typeMet;
}
