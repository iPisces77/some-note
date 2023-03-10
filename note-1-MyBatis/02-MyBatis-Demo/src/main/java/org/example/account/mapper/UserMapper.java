package org.example.account.mapper;

import java.util.List;
import org.example.pojo.User;

/**
 * @author fuhaixin
 * @date 2023-01-01
 **/
public interface UserMapper {

  List<User> findAll();


  List<User> findByCondition(User user);

  List<User> findByIds(List<Long> ids);
}
