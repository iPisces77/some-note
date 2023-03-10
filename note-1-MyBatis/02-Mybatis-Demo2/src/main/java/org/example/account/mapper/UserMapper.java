package org.example.account.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.pojo.User;

/**
 * @author fuhaixin
 * @date 2023-01-01
 **/
public interface UserMapper {

  List<User> findUserAndOrder();

  List<User> findAllUserAndRole();

  @Insert("insert into user value (#{id},#{username})")
  void addUser(User user);

  @Update("update user set username=#{username} where id=#{id}")
  void updateUser(User user);

  @Delete("delete from user where id=#{id}")
  void deleteUser(Integer id);

  @Select("select * from user")
  List<User> findAllUser();
}
