package com.wynlo;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@SpringBootApplication(
        scanBasePackages = "com.wynlo",
        exclude = { DataSourceAutoConfiguration.class }
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

    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(Boot.class, args);
    }

    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {
        ApplicationContext applicationContext = event.getApplicationContext();
        applicationContext.getBean(RequestMappingHandlerMapping.class)
                .getHandlerMethods().forEach((key, value) -> System.out.println(key + "," + value));
    }


}
