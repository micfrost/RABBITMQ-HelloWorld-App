package com.micfro.helloservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.amqp.core.Queue;

@SpringBootApplication
public class HelloServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(HelloServiceApplication.class, args);
  }

  @Bean
  public Queue helloQueue() {
    return new Queue("helloQueue", false);
  }
}

