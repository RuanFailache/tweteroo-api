package dev.ruanfailache.tweteroo.core.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class HttpRequestException extends RuntimeException {
	private final HttpStatus status;

	public HttpRequestException(HttpStatus status, String message) {
		super(message);
		this.status = status;
	}
}
