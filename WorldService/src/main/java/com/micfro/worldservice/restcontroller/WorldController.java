package com.micfro.worldservice.restcontroller;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class WorldController {

  private final RabbitTemplate rabbitTemplate;

  @Autowired
  WorldController(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  @GetMapping("/worldMessage")
  public String worldMessageToQueue() {
    String messageToQueue = "World";
    String worldQueue = "worldQueue";
    rabbitTemplate.convertAndSend(worldQueue, messageToQueue);
    return "Hej. Message sent to the " + worldQueue + ": " + messageToQueue;
  }

}