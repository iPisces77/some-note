package org.example.pojo;

import java.util.Date;
import java.util.List;

public class User {

  List<Order> orders;
  private List<Role> roles;

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }

  public User(List<Order> orders, List<Role> roles, int id, String username, String password,
      Date birthday) {
    this.orders = orders;
    this.roles = roles;
    this.id = id;
    this.username = username;
    this.password = password;
    this.birthday = birthday;
  }

  private int id;
  private String username;
  private String password;
  private Date birthday;

  public User(List<Order> orders, int id, String username, String password, Date birthday) {
    this.orders = orders;
    this.id = id;
    this.username = username;
    this.password = password;
    this.birthday = birthday;
  }

  public User() {
  }

  public User(int id, String username, String password, Date birthday) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.birthday = birthday;
  }

  public List<Order> getOrders() {
    return orders;
  }

  public void setOrders(List<Order> orders) {
    this.orders = orders;
  }

  @Override
  public String toString() {
    return "User{" +
        "orders=" + orders +
        ", id=" + id +
        ", username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", birthday=" + birthday +
        '}';
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }
}