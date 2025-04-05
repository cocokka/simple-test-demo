package com.tinydemo.simple.test.demo.service.impl;

import com.tinydemo.simple.test.demo.entity.User;
import com.tinydemo.simple.test.demo.mapper.UserMapper;
import com.tinydemo.simple.test.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public User createUser(User user) {
        userMapper.insert(user);
        return user;
    }

    public List<User> getAllUsers() {
        return userMapper.selectAll();
    }

    public User updateUser(Long id, User user) {
        user.setId(id);
        userMapper.update(user);
        return userMapper.selectById(id);
    }

    public void deleteUser(Long id) {
        userMapper.delete(id);
    }

    @Override
    public User getUser(Long id) {
        return userMapper.selectById(id);
    }
}
