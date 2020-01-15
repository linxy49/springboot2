package com.line.delivey.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.line.delivey.common.LogUtils;
import com.line.delivey.domain.service.MailService;
import com.line.delivey.domain.service.TaskService;
import com.line.delivey.domain.service.UserService;
import com.line.delivey.infrastructure.mongodb.entity.Task;
import com.line.delivey.infrastructure.mysqldb.entity.User;
import com.line.delivey.infrastructure.psqldb.entity.Mail;

@RestController
@RequestMapping("/v1/users")
public class UserController {

  @Autowired
  public UserService userService;

  @Autowired
  public TaskService taskService;

  @Autowired
  public MailService mailService;

  /**
   * user list.
   * @return
   */
  @GetMapping
  public String index() {
    LogUtils.info("===========INDEX BEGIN===========");
    List<User> users = userService.all();
    List<Task> tasks = taskService.all();
    List<Mail> mails = mailService.all();
    LogUtils.info("===========INDEX END  ===========");

    return "ユーザー：" + users.size() + "<br>" + "タスク：" + tasks.size() + "<br>" + "メール：" + mails.size();
  }

  @GetMapping("{id}")
  public String get(@PathVariable String id) {
    return "get";
  }

  @PostMapping
  public String save() {
    return "save";
  }

  @PutMapping("{id}")
  public String update(@PathVariable String id) {
    return "update";
  }

  @DeleteMapping("{id}")
  public String delete(@PathVariable String id) {
    return "delete";
  }
}
