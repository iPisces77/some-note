package org.example.pojo;

import java.util.Objects;

/**
 * @author fuhaixin
 * @date 2022-12-23
 **/
public class User {

  private Long id;
  private String username;

  public User() {
  }

  public User(Long id, String username) {
    this.id = id;
    this.username = username;
  }

  public Long getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof User user)) {
      return false;
    }
    return getId().equals(user.getId()) && getUsername().equals(user.getUsername());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getUsername());
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", username='" + username + '\'' +
        '}';
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}
