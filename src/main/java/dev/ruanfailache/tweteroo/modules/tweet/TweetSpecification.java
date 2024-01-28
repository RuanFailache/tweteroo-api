package dev.ruanfailache.tweteroo.modules.tweet;

import dev.ruanfailache.tweteroo.modules.user.User;
import jakarta.persistence.criteria.Join;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TweetSpecification {
	public static Specification<Tweet> byUser(Long userId) {
		return (root, query, builder) -> {
			Join<User, Tweet> userTweets = root.join("user");
			return builder.equal(userTweets.get("id"), userId);
		};
	}
}
