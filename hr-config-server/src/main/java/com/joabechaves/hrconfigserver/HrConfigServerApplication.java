package com.joabechaves.hrconfigserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class HrConfigServerApplication implements CommandLineRunner {

    //implements CommandLinRunner faz com que a aplicaçao execute um comando
    //quando for iniciada, no caso, estou imprimindo no console o username do github
    @Value("${spring.cloud.config.server.git.username}")
    private String username;

    public static void main(String[] args) {
        SpringApplication.run(HrConfigServerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //System.out.println("USERNAME ="+username);
    }
}
