package com.micfro.compositeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.amqp.core.Queue;


@SpringBootApplication
public class CompositeServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(CompositeServiceApplication.class, args);
  }


  @Bean
  public Queue helloQueue() {
    return new Queue("helloQueue", false);
  }

  @Bean
  public Queue worldQueue() {
    return new Queue("worldQueue", false);
  }
}


