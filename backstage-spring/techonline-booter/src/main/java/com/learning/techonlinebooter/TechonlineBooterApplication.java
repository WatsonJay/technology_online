package com.learning.techonlinebooter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.learning")
@EnableAutoConfiguration
public class TechonlineBooterApplication {

    public static void main(String[] args) {
        SpringApplication.run(TechonlineBooterApplication.class, args);
    }

}
