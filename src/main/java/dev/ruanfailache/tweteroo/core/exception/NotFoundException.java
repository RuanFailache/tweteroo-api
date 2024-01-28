package dev.ruanfailache.tweteroo.core.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends HttpRequestException {
	public NotFoundException(String message) {
		super(HttpStatus.NOT_FOUND, message);
	}
}
