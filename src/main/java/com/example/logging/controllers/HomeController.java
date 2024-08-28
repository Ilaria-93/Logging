package com.example.logging.controllers;

import com.example.logging.exception.CustomError;
import com.example.logging.servers.HomeServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    private final HomeServer homeServer;

    @Value("${my.custom.var1}")
    private Integer num1;

    @Value("${my.custom.var2}")
    private Integer num2;

    public HomeController(HomeServer homeServer) {
        this.homeServer = homeServer;
    }

    @GetMapping
    public String welcome() {
        String message = "Welcome to the Logging Demo";
        logger.info(message);
        return message;
    }

    @GetMapping("/exp")
    public String calculateExponent() {
        return "Result of " + num1 + "^" + num2 + " is: " + homeServer.calculateExponent(num1, num2);
    }

    @GetMapping("/get-errors")
    public String throwError() throws CustomError {
        throw new CustomError("This is a custom error");
    }

}
