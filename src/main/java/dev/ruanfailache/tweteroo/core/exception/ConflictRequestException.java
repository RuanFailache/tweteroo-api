package dev.ruanfailache.tweteroo.core.exception;

import org.springframework.http.HttpStatus;

public class ConflictRequestException extends HttpRequestException {
	public ConflictRequestException(String message) {
		super(HttpStatus.CONFLICT, message);
	}
}
