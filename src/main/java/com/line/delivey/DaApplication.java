package com.line.delivey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.line.delivey.config.MongodbConfig;

@Import(MongodbConfig.class)
@SpringBootApplication
public class DaApplication {

  public static void main(String[] args) {
    SpringApplication.run(DaApplication.class, args);
  }

}
