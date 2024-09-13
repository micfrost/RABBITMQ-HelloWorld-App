package com.micfro.compositeservice.restcontroller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompositeController {


  private String helloMessage = "";
  private String worldMessage = "";

  @RabbitListener(queues = "helloQueue")
  public void receiveHello(String message) {
    this.helloMessage = message;
  }

  @RabbitListener(queues = "worldQueue")
  public void receiveWorld(String message) {
    this.worldMessage = message;
  }

@GetMapping("/sentence")
  private String getSentence() {
    if (!helloMessage.isEmpty() && !worldMessage.isEmpty()) {
      return helloMessage + " " + worldMessage;
    }
    return "Waiting for messages ...";
  }
}