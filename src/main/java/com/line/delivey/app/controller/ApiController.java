package com.line.delivey.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ApiController {

  /**
   * all user.
   * @return
   */
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index() {

    return "index";

  }
}
