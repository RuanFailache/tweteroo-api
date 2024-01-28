package dev.ruanfailache.tweteroo.modules.tweet;

import dev.ruanfailache.tweteroo.modules.tweet.dto.CreateTweetDto;
import dev.ruanfailache.tweteroo.modules.tweet.dto.TweetDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tweets")
public class TweetController {
	private final TweetService tweetService;

	public TweetController(TweetService tweetService) {
		this.tweetService = tweetService;
	}

	@PostMapping
	public ResponseEntity<TweetDto> create(@Valid @RequestBody CreateTweetDto dto) {
		Tweet tweet = this.tweetService.create(dto);
		TweetDto body = new TweetDto(tweet);
		return ResponseEntity.status(HttpStatus.CREATED).body(body);
	}
}
