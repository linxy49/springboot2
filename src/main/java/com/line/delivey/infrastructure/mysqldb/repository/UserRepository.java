package com.line.delivey.infrastructure.mysqldb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.line.delivey.infrastructure.mysqldb.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
