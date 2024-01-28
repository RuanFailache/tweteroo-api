package dev.ruanfailache.tweteroo.modules.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

public record CreateUserDto(
	@NotBlank
	@Size(max = 100)
	String username,

	@NotBlank
	@URL
	String avatar
) {
}
