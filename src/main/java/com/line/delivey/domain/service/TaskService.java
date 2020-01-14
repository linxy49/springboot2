package com.line.delivey.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.line.delivey.common.LogUtils;
import com.line.delivey.infrastructure.mongodb.entity.Task;
import com.line.delivey.infrastructure.mongodb.repository.TaskRepository;

@Service
public class TaskService {

  @Autowired
  TaskRepository repository;

  public List<Task> all() {
    LogUtils.info("=======all BEGIN  ==========");
    List<Task> tasks = repository.findAll();
    LogUtils.info("=======" + String.valueOf(tasks.size()) + " ==========");

    LogUtils.info("=======all END  ============");
    return tasks;
  }

  public Task save() {
    Task data = new Task();
    data.setName("abc");
    return repository.insert(data);
  }
}
