package com.epf.API.Controller;

import com.epf.API.Exception.BadRequestException;
import com.epf.API.Exception.NotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestExceptionController {

    @GetMapping("/bad-request")
    public void testBadRequest() {
        throw new BadRequestException("Test bad request");
    }

    @GetMapping("/not-found")
    public void testNotFound() {
        throw new NotFoundException("Test not found");
    }
}
