package br.com.treinamento.backend.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    private final static long serialVersionUID = -2842210367166840962L;

    public BadRequestException(String message) {
        super(message);
    }
}
