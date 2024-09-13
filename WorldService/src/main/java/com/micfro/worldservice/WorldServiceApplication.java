package com.micfro.worldservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.amqp.core.Queue;

@SpringBootApplication
public class WorldServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(WorldServiceApplication.class, args);
  }

  @Bean
  public Queue worldQueue() {
    return new Queue("worldQueue", false);
  }

}
