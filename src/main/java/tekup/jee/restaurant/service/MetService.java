package tekup.jee.restaurant.service;

import java.time.LocalDateTime;
import java.util.List;

import tekup.jee.restaurant.model.Met;

/**
 * {@link MetService } class.
 *
 * @author AhmedBenyahia
 * @since 0.0.1
 */
public interface MetService {

	List<Met> getMets();

	void deleteMet(String name);

	Met getMetById(String name);

	Met saveOrUpdate(Met met);

	Met getMostSoldMet(LocalDateTime start, LocalDateTime end);
}
