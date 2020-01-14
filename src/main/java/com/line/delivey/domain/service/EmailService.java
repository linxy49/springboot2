package com.line.delivey.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.line.delivey.infrastructure.psqldb.entity.Email;
import com.line.delivey.infrastructure.psqldb.repository.EmailRepository;

@Service
public class EmailService {

  @Autowired
  EmailRepository repository;

  public List<Email> all() {
    return repository.findAll();
  }
}
