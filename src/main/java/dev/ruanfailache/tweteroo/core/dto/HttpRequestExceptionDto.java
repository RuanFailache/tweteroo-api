package dev.ruanfailache.tweteroo.core.dto;

import dev.ruanfailache.tweteroo.core.exception.HttpRequestException;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record HttpRequestExceptionDto(
	String message,
	Integer status,
	LocalDateTime timestamp
) {
	public HttpRequestExceptionDto(String message, HttpStatus status) {
		this(message, status.value(), LocalDateTime.now());
	}

	public HttpRequestExceptionDto(HttpRequestException exception) {
		this(exception.getMessage(), exception.getStatus());
	}
}
