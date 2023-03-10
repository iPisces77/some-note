package org.example.pojo;

import java.util.Date;

/**
 * @author fuhaixin
 * @date 2023-01-01
 **/
public class Order {

  private Integer id;
  private Date orderTime;
  private Double total;
  private User user;

  @Override
  public String toString() {
    return "Order{" +
        "id=" + id +
        ", orderTime=" + orderTime +
        ", total=" + total +
        ", user=" + user +
        '}';
  }

  public Order() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getOrderTime() {
    return orderTime;
  }

  public void setOrderTime(Date orderTime) {
    this.orderTime = orderTime;
  }

  public Double getTotal() {
    return total;
  }

  public void setTotal(Double total) {
    this.total = total;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Order(Integer id, Date orderTime, Double total, User user) {
    this.id = id;
    this.orderTime = orderTime;
    this.total = total;
    this.user = user;
  }
}
