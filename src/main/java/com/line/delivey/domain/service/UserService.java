package com.line.delivey.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.line.delivey.infrastructure.mysqldb.entity.User;
import com.line.delivey.infrastructure.mysqldb.repository.UserRepository;

@Service
public class UserService {
  @Autowired
  UserRepository repository;

  public List<User> all() {
    return repository.findAll();
  }
}
