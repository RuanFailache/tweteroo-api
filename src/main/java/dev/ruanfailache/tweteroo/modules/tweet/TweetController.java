package dev.ruanfailache.tweteroo.modules.tweet;

import dev.ruanfailache.tweteroo.modules.tweet.dto.CreateTweetDto;
import dev.ruanfailache.tweteroo.modules.tweet.dto.TweetDto;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

	@GetMapping
	public ResponseEntity<Page<TweetDto>> findAll(Pageable pageable) {
		Page<Tweet> tweets = this.tweetService.findAllWithPagination(pageable);
		Page<TweetDto> body = tweets.map(TweetDto::new);
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}
}
