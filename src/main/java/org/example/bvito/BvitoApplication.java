package org.example.bvito;

import org.example.bvito.service.photos.utils.PhotoProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableConfigurationProperties(PhotoProperties.class)
public class BvitoApplication {
    public static void main(String[] args) {
        SpringApplication.run(BvitoApplication.class, args);
    }
}
