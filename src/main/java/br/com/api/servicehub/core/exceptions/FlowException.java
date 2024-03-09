package br.com.api.servicehub.core.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
public class FlowException extends RuntimeException {

    private final HttpStatus httpStatus;
    private final LocalDateTime dateTime;
    private final String message;

    public FlowException(HttpStatus httpStatus, LocalDateTime dateTime, String message) {
        super(message);
        this.httpStatus = httpStatus;
        this.dateTime = dateTime;
        this.message = message;
    }
}
