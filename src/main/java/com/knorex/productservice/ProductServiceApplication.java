package com.knorex.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ProductServiceApplication {

    public static void main(String[] args) {
        String url = "http://localhost:5050";

        SpringApplication.run(ProductServiceApplication.class, args);
        // Use logging libraries
        // Understand the log levels: System Logs, Debug Logs (In production, not required all the time)
        // (Services > log stash manager > Elastic Search) for managing the logs
        // Constants: Routes should be defined as constants and imported from a class
        // Enum from other class instead of having inside the model class.
        // Spring boot starter validation library

        // Integration tests
        // Unit test cases - testing the function/ limited functionality
        System.out.println("Site is live at: " + url);
    }

}

/*
- Controllers can be found in the package: com.knorex.productservice.controllers
- Models in the package: com.knorex.productservice.models
- DataAccessObjects/JPARepositories in: com.knorex.productservice.dao
- Custom Exceptions, Exception Handlers and Exception Response Class can be found in:
com.knorex.productservice.exceptions
- ProductService is defined at './ProductService.java'
 */
