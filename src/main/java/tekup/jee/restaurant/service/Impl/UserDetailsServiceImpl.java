package tekup.jee.restaurant.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tekup.jee.restaurant.model.EBUserDetails;
import tekup.jee.restaurant.model.User;
import tekup.jee.restaurant.repository.UserRepository;

/**
 * {@link UserDetailsService } class.
 *
 * @author AhmedBenyahia
 * @since 0.0.1
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	/**
	 * The UserDetails service.
	 */
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUsername(username);
		user.orElseThrow(() -> new UsernameNotFoundException(username));
		return new EBUserDetails(user.get());
	}

	/*public void save(User user) {
		userRepository.save(user);
	}*/
}
