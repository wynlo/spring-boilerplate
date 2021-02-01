package com.wynlo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication(
        exclude = { DataSourceAutoConfiguration.class, EmbeddedMongoAutoConfiguration.class }
)
@ComponentScan(
        basePackages = "com.wynlo",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = {
                BootLocal.class, BootStaging.class
        })
)
public class BootProduction {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(BootProduction.class);
        springApplication.setAdditionalProfiles("production");
        springApplication.run(args);
    }

}
