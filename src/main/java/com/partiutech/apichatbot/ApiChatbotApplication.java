package com.partiutech.apichatbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(exclude = {SpringApplicationAdminJmxAutoConfiguration.class})
public class ApiChatbotApplication  {

    public static void main(String[] args) {
        SpringApplication.run(ApiChatbotApplication.class, args);
    }

}
