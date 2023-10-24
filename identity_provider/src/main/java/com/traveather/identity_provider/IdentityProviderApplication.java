package com.traveather.identity_provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.traveather")
public class IdentityProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdentityProviderApplication.class, args);
    }
}
