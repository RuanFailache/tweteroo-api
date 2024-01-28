package dev.ruanfailache.tweteroo.modules.user;

import dev.ruanfailache.tweteroo.modules.user.dto.CreateUserDto;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User create(CreateUserDto dto) {
		var user = new User(dto);
		return this.userRepository.save(user);
	}
}
