package tekup.jee.restaurant.model;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mets")
public class Met {

	@Id
	private String nomMet;

	private Double prix;

	@ManyToMany(mappedBy = "mets")
	@JsonIgnore
	private Set<Ticket> tickets;

	@Enumerated(EnumType.STRING)
	private TypeMet typeMet;

}
