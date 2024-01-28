package dev.ruanfailache.tweteroo.modules.user.dto;

import dev.ruanfailache.tweteroo.modules.user.User;

public record UserDto(Long id, String avatar, String username) {
	public UserDto(User user) {
		this(user.getId(), user.getAvatar(), user.getUsername());
	}
}
