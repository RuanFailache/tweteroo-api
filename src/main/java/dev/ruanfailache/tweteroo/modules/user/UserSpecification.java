package dev.ruanfailache.tweteroo.modules.user;

import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {
	public static Specification<User> hasUsername(String username) {
		return (root, query, builder) -> builder.equal(root.get("username"), username);
	}
}
