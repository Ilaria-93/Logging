package com.example.logging.servers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HomeServer {

    private static final Logger logger = LoggerFactory.getLogger(HomeServer.class);

    public int calculateExponent(Integer num1, Integer num2) {
        logger.debug("Calculating {}^{}", num1, num2);
        int result = (int) Math.pow(num1, num2);
        logger.debug("Result of {}^{} = {}", num1, num2, result);
        return result;
    }
}
