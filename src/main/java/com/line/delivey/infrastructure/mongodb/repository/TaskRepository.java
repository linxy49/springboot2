package com.line.delivey.infrastructure.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.line.delivey.infrastructure.mongodb.entity.Task;

public interface TaskRepository extends MongoRepository<Task, String> {

}
