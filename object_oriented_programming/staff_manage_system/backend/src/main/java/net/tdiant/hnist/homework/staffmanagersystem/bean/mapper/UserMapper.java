package net.tdiant.hnist.homework.staffmanagersystem.bean.mapper;

import net.tdiant.hnist.homework.staffmanagersystem.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    User findLoginUser(@Param("username") String username, @Param("password") String password);

    List<User> findAll();

    User findById(@Param("id") int id);

    void changePassword(@Param("id") int id, @Param("password") String password);
}
