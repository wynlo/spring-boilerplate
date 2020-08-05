package com.wynlo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.wynlo")
public class Boot {
    public static void main(String[] args) {
        SpringApplication.run(Boot.class, args);
    }

}
