package com.web_programming.data_collecting_server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan("com.web_programming")
public class DataCollectingServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataCollectingServerApplication.class, args);
    }
}
