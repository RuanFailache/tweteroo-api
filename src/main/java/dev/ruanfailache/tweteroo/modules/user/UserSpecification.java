package dev.ruanfailache.tweteroo.modules.user;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserSpecification {
	public static Specification<User> hasUsername(String username) {
		return (root, query, builder) -> builder.equal(root.get("username"), username);
	}
}
