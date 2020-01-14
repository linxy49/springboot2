package com.line.delivey.infrastructure.psqldb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.line.delivey.infrastructure.psqldb.entity.Email;

public interface EmailRepository extends JpaRepository<Email, Integer> {

}
