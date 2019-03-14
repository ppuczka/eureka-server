package com.microservices.lab.eurekaconcatclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaConcatClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaConcatClientApplication.class, args);
    }

}
