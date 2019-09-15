package com.raif.javahack.javahack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.raif.javahack")
public class JavahackApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavahackApplication.class, args);
    }

}
