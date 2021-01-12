package tekup.jee.restaurant.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Set;

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
@Table(name = "tickets")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numeroTicket;

	private LocalDateTime date;

	private Integer nbCouvert;

	private Double addition;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = RestaurantTable.class)
	@JoinColumn(name = "numeroTable", nullable = false)
	@JsonIgnore
	private RestaurantTable tables;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Client.class)
	@JoinColumn(name = "idClient", nullable = false)
	@JsonIgnore
	private Client client;

	@ManyToMany(fetch = FetchType.EAGER, targetEntity = Met.class)
	@JoinTable(
			name = "tickets_mets",
			joinColumns = @JoinColumn(name = "numeroTicket"),
			inverseJoinColumns = @JoinColumn(name = "nomMet"))
	private Set<Met> mets;

}
