package com.epf.API.Exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionTest {

    @Test
    public void testBadRequestException() {
        BadRequestException exception = new BadRequestException("Invalid input");
        assertEquals(400, exception.getStatusCode());
        assertEquals("Invalid input", exception.getMessage());
    }

    @Test
    public void testNotFoundException() {
        NotFoundException exception = new NotFoundException("Resource not found");
        assertEquals(404, exception.getStatusCode());
        assertEquals("Resource not found", exception.getMessage());
    }

    @Test
    public void testGlobalExceptionHandler() {
        GlobalExceptionHandler handler = new GlobalExceptionHandler();
        ApiException exception = new BadRequestException("Test error");
        
        ResponseEntity<?> response = handler.handleApiException(exception);
        
        assertEquals(400, response.getStatusCode().value());
        assertNotNull(response.getBody());
    }
}
