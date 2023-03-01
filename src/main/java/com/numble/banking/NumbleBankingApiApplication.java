package com.numble.banking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class NumbleBankingApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(NumbleBankingApiApplication.class, args);
    }

}
