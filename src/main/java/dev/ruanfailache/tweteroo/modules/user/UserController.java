package dev.ruanfailache.tweteroo.modules.user;

import dev.ruanfailache.tweteroo.modules.user.dto.CreateUserDto;
import dev.ruanfailache.tweteroo.modules.user.dto.UserDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	public ResponseEntity<UserDto> create(@Valid @RequestBody CreateUserDto dto) {
		User createdUser = userService.create(dto);
		UserDto body = new UserDto(createdUser);
		return ResponseEntity.status(HttpStatus.CREATED).body(body);
	}
}
