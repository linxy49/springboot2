package com.line.delivey.domain.service;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.line.delivey.infrastructure.psqldb.entity.Mail;
import com.line.delivey.infrastructure.psqldb.repository.MailRepository;

@Service
public class MailService {

  @Autowired
  private MailRepository repository;

  @Autowired
  private MailSender sender;

  @Autowired
  private JavaMailSender javaMailSender;

  public List<Mail> all() {
    return repository.findAll();
  }

  /**
   * send email.
   * @return
   */
  public String send2() {
    try {
      SimpleMailMessage msg = new SimpleMailMessage();
      msg.setFrom("stringtechinc@gmail.com");
      msg.setTo("stringtechinc@gmail.com");
      msg.setSubject("テストメール");
      msg.setText("Spring Boot より本文送信");
      this.sender.send(msg);
      return "EmailService: send email";
    } catch (Exception e) {
      return e.getMessage();
    }
  }

  /**
   * send javamail.
   */
  public String send() {

    try {
      MimeMessage msg = javaMailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(msg, true);

      helper.setText("テキストです！");
      helper.setSubject("テストメール");
      helper.setTo("to@gmail.com");
      FileSystemResource res = new FileSystemResource("/テスト.xlsx");
      helper.addAttachment("添付ファイル.", res);

      javaMailSender.send(msg);

      return "EmailService: send java email";
    } catch (MessagingException e) {
      return e.getMessage();
    }
  }
}
