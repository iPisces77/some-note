package org.example.account.mapper;

import java.util.List;
import org.example.pojo.Order;

/**
 * @author fuhaixin
 * @date 2023-01-01
 **/
public interface OrderMapper {


  List<Order> findOrderAndUser();
}
