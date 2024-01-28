package dev.ruanfailache.tweteroo.modules.tweet.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateTweetDto(
	@NotNull
	Long userId,

	@NotBlank
	@Size(max = 280, message = "Tweet must have at most 280 characters")
	String text
) {
}
