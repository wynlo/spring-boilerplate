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
public class Boot {

    public static void main(String[] args) {
        SpringApplication.run(Boot.class, args);
    }

//    @EventListener
//    public void handleContextRefresh(ContextRefreshedEvent event) {
//        ApplicationContext applicationContext = event.getApplicationContext();
//        applicationContext.getBean(RequestMappingHandlerMapping.class)
//                .getHandlerMethods().forEach((key, value) -> System.out.println(key + "," + value));
//    }

}
