package tekup.jee.restaurant.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RevenuReport {

	private Double dayRevenu;
	private Double weekRevenu;
	private Double monthRevenu;
}
