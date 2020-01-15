package com.line.delivey.infrastructure.psqldb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.line.delivey.infrastructure.psqldb.entity.Mail;

public interface MailRepository extends JpaRepository<Mail, Integer> {

}
