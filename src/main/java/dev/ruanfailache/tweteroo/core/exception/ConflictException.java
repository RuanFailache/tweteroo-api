package dev.ruanfailache.tweteroo.core.exception;

import org.springframework.http.HttpStatus;

public class ConflictException extends HttpRequestException {
	public ConflictException(String message) {
		super(HttpStatus.CONFLICT, message);
	}
}
