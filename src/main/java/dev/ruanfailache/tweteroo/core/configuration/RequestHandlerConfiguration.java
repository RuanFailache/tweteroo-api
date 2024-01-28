package dev.ruanfailache.tweteroo.core.configuration;

import dev.ruanfailache.tweteroo.core.dto.HttpRequestExceptionDto;
import dev.ruanfailache.tweteroo.core.exception.HttpRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RequestHandlerConfiguration {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<HttpRequestExceptionDto> handler(Exception exception) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
			new HttpRequestExceptionDto(
				exception.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR
			)
		);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<HttpRequestExceptionDto> handler(MethodArgumentNotValidException exception) {
		return ResponseEntity.badRequest().body(
			new HttpRequestExceptionDto(
				exception.getMessage(),
				HttpStatus.BAD_REQUEST
			)
		);
	}

	@ExceptionHandler(HttpRequestException.class)
	public ResponseEntity<HttpRequestExceptionDto> handler(HttpRequestException exception) {
		return ResponseEntity.status(exception.getStatus()).body(
			new HttpRequestExceptionDto(
				exception.getMessage(),
				exception.getStatus()
			)
		);
	}
}
