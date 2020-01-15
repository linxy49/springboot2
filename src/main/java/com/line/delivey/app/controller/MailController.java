package com.line.delivey.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.line.delivey.domain.service.MailService;

@RestController
@RequestMapping("/v1/mails")
public class MailController {

  @Autowired
  private MailService mailService;

  @GetMapping
  public String send() {
    return  mailService.send();
  }
}
