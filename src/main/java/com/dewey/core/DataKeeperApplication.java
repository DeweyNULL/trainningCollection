package com.dewey.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@EnableCaching
@SpringBootApplication
public class DataKeeperApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataKeeperApplication.class, args);
    }

}
