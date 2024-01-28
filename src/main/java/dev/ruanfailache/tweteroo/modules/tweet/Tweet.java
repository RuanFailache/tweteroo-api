package dev.ruanfailache.tweteroo.modules.tweet;

import dev.ruanfailache.tweteroo.modules.user.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Table(name = "tweets")
@Entity
@Data
@NoArgsConstructor
public class Tweet {
	@Id
	@GeneratedValue
	private Long id;

	@Column(length = 280, nullable = false)
	private String text;

	@JoinColumn(nullable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;

	@Column
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@Column
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
}