package tekup.jee.restaurant.model.dto;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tekup.jee.restaurant.model.Ticket;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

	private Long idClient;

	@NotBlank(message = "nom must not Empty")
	@Size(max = 50, min = 5)
	@Pattern(regexp = "[a-zA-Z ]+", message = "nom must contain only characters")
	private String nom;

	@NotBlank(message = "prenom must not Empty")
	@Size(max = 50, min = 5)
	@Pattern(regexp = "[a-zA-Z ]+", message = "prenom must contain only characters")
	private String prenom;

	@Past
	private LocalDate dateNaiss;

	@Email
	private String email;

	@Pattern(regexp = "^\\\\{8}$", message = "invalid phone number")
	@NotBlank(message = "phone must not Empty")
	private String phone;

	@Valid
	@Null
	private List<TicketDTO> tickets;

}
