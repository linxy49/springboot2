package com.line.delivey.infrastructure.mongodb.entity;

import java.io.Serializable;

import javax.persistence.Id;

import lombok.Data;

@Data
public class Task implements Serializable {
  @Id
  private String id;

  private String name;

  public void setId(String id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

}
