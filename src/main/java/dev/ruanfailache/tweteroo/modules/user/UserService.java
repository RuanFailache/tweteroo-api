package dev.ruanfailache.tweteroo.modules.user;

import dev.ruanfailache.tweteroo.core.exception.ConflictException;
import dev.ruanfailache.tweteroo.modules.user.dto.CreateUserDto;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
			throw new ConflictException("Username is already registered");
		});

		return this.userRepository.save(new User(dto));
	}

	public Optional<User> findById(Long id) {
		return this.userRepository.findById(id);
	}
}
