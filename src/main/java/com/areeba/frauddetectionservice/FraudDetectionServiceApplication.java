package com.areeba.frauddetectionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FraudDetectionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FraudDetectionServiceApplication.class, args);
    }

}
