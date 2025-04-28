package com.epf.API.Exception;

public class NotFoundException extends ApiException {
    public NotFoundException(String message) {
        super(message, 404);
    }
}
