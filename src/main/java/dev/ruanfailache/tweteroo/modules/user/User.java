package dev.ruanfailache.tweteroo.modules.user;

import dev.ruanfailache.tweteroo.modules.tweet.Tweet;
import dev.ruanfailache.tweteroo.modules.user.dto.CreateUserDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Table(name = "users")
@Entity
@Data
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String avatar;

	@Column(length = 100, nullable = false)
	private String username;

	@OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<Tweet> tweets;

	@Column
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@Column
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	public User(CreateUserDto dto) {
		this.avatar = dto.avatar();
		this.username = dto.username();
	}
}
