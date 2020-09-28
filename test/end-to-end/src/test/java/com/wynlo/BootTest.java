package com.wynlo;

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
public class BootTest {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(BootTest.class);
        springApplication.run(args);
    }

}
