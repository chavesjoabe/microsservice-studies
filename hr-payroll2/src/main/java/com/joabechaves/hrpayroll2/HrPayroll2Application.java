package com.joabechaves.hrpayroll2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class HrPayroll2Application {

    public static void main(String[] args) {
        SpringApplication.run(HrPayroll2Application.class, args);
    }

}
