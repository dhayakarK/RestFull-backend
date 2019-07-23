package com.restapi.bookrentalsystemrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableJpaRepositories
@EnableJpaAuditing
public class BookrentalsystemrestapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookrentalsystemrestapiApplication.class, args);
    }
    @Bean
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }

}
