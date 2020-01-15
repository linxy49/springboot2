package com.line.delivey.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.line.delivey.domain.service.SlackService;

@RestController
@RequestMapping("/v1/slack")
public class SlackController {

  @Autowired
  private SlackService slackService;

  @GetMapping
  public String send() {
    try {
      return  slackService.send();
    } catch (IOException e) {
      return e.getMessage();
    }
  }
}
