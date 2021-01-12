package tekup.jee.restaurant.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tables")
public class RestaurantTable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numeroTable;

	private Integer nbCouvert;

	private String type;

	private Double supplement;

	@JoinColumn(name = "numeroTable")
	@OneToMany(fetch = FetchType.LAZY, targetEntity = Ticket.class)
//	@JsonIgnore
	private List<Ticket> tickets;

}
