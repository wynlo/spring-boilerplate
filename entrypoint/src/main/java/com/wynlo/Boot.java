package com.wynlo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(
        scanBasePackages = "com.wynlo",
        exclude = {DataSourceAutoConfiguration.class }
)
public class Boot {

    private static final Logger logger = LoggerFactory.getLogger(Boot.class);

    public static void printTestLogs() {
        logger.trace("This is a TRACE message.");
        logger.debug("This is a DEBUG message.");
        logger.info("This is an INFO message.");
        logger.warn("This is a WARN message.");
        logger.error("You guessed it, an ERROR message.");
    }

    public static void main(String[] args) {
//        printTestLogs();
        SpringApplication.run(Boot.class, args);
    }


}
