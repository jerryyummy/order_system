package com.ordersystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ordersystem.dao")
public class OrderSystemApplication {

    public static void main(String[] args) {

        SpringApplication.run(OrderSystemApplication.class, args);
    }

}
