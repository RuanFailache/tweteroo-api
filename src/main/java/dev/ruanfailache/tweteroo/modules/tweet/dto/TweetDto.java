package dev.ruanfailache.tweteroo.modules.tweet.dto;

import dev.ruanfailache.tweteroo.modules.tweet.Tweet;
import dev.ruanfailache.tweteroo.modules.user.dto.UserDto;

public record TweetDto(Long id, String text, UserDto user) {
	public TweetDto(Tweet tweet) {
		this(tweet.getId(), tweet.getText(), new UserDto(tweet.getUser()));
	}
}
