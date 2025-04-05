package com.tinydemo.simple.test.demo.service;

import com.tinydemo.simple.test.demo.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    List<User> getAllUsers();

    User updateUser(Long id, User user);

    void deleteUser(Long id);

    User getUser(Long id);
}