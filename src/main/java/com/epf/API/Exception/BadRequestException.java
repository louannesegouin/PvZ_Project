package com.epf.API.Exception;

public class BadRequestException extends ApiException {
    public BadRequestException(String message) {
        super(message, 400);
    }
}
