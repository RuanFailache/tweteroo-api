package dev.ruanfailache.tweteroo.modules.user;

import dev.ruanfailache.tweteroo.core.exception.ConflictRequestException;
import dev.ruanfailache.tweteroo.modules.user.dto.CreateUserDto;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User create(CreateUserDto dto) {
		Specification<User> specification = Specification.where(
			UserSpecification.hasUsername(dto.username())
		);

		this.userRepository.findOne(specification).ifPresent(user -> {
			throw new ConflictRequestException("Username is already registered");
		});

		User user = new User(dto);

		return this.userRepository.save(user);
	}
}
