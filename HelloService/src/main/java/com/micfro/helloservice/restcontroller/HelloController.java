package com.micfro.helloservice.restcontroller;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloController {

  private final RabbitTemplate rabbitTemplate;

  @Autowired
  HelloController(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  @GetMapping("/helloMessage")
  public String sendHelloMessageToQueue() {
    String messageToQueue = "Hello";
    String helloQueue = "helloQueue";
    rabbitTemplate.convertAndSend(helloQueue, messageToQueue);
    return "Hej. Message sent to the " + helloQueue + ": " + messageToQueue;
  }

}