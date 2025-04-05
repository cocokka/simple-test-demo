package com.tinydemo.simple.test.demo.service.impl;

import com.tinydemo.simple.test.demo.entity.User;
import com.tinydemo.simple.test.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Mock
    private UserMapper userMapper;
    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void testCreateUser() {
        User user = new User(null, "Alice", "alice@example.com");
        doAnswer(invocation -> {
            User u = invocation.getArgument(0);
            u.setId(1L); // 模拟数据库生成ID
            return null;
        }).when(userMapper).insert(any(User.class));

        User savedUser = userService.createUser(user);
        assertThat(savedUser.getId()).isEqualTo(1L);
    }

    @Test
    void testDeleteUser() {
        doNothing().when(userMapper).delete(1L);
        assertThatNoException().isThrownBy(() -> userService.deleteUser(1L));
    }
}