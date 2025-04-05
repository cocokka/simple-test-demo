package com.tinydemo.simple.test.demo.mapper;

import com.tinydemo.simple.test.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    void insert(User user);

    User selectById(Long id);

    List<User> selectAll();

    void update(User user);

    void delete(Long id);
}