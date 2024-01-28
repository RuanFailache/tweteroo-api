package dev.ruanfailache.tweteroo.modules.tweet;

import dev.ruanfailache.tweteroo.core.exception.NotFoundException;
import dev.ruanfailache.tweteroo.modules.tweet.dto.CreateTweetDto;
import dev.ruanfailache.tweteroo.modules.user.User;
import dev.ruanfailache.tweteroo.modules.user.UserService;
import org.springframework.stereotype.Service;

@Service
public class TweetService {
	private final UserService userService;

	private final TweetRepository tweetRepository;

	public TweetService(UserService userService, TweetRepository tweetRepository) {
		this.userService = userService;
		this.tweetRepository = tweetRepository;
	}

	public Tweet create(CreateTweetDto dto) {
		User user = this.userService.findById(dto.userId()).orElseThrow(() ->
			new NotFoundException("User not found")
		);

		Tweet tweet = new Tweet();
		tweet.setText(dto.text());
		tweet.setUser(user);

		return this.tweetRepository.save(tweet);
	}
}
