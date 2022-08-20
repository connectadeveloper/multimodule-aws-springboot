package com.akash.multi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.akash.*")
public class MultiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiApplication.class, args);
    }

}
