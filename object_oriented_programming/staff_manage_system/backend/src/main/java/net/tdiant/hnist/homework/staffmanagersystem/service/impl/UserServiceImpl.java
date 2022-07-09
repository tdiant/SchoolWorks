package net.tdiant.hnist.homework.staffmanagersystem.service.impl;

import net.tdiant.hnist.homework.staffmanagersystem.bean.User;
import net.tdiant.hnist.homework.staffmanagersystem.bean.mapper.UserMapper;
import net.tdiant.hnist.homework.staffmanagersystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Override
    public User findLoginUser(String username, String password) {
        return userMapper.findLoginUser(username, password);
    }

    @Override
    public User getUser(int id) {
        return userMapper.findById(id);
    }

    @Override
    public void changePassword(int id, String newPassword) {
        userMapper.changePassword(id, newPassword);
    }

    @Override
    public UserWrapper findUserGlobalData(int id) {
        User user = getUser(id);
        if (user == null) return null;
        return new UserWrapper(
                user.getId(),
                user.getRealName(),
                user.getUsername(),
                user.getJob(),
                user.getDepartment()
        );
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
