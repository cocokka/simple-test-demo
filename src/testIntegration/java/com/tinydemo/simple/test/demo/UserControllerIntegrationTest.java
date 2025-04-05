package com.tinydemo.simple.test.demo.controller;

import com.tinydemo.simple.test.demo.entity.User;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ActiveProfiles("integration")
@Tag("integration")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Sql(scripts = "/test-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
class UserControllerIntegrationTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @Order(1)
    void testGetAllUsers() {
        ResponseEntity<List<User>> response = restTemplate.exchange(
                "/api/users",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<User>>() {
                }
        );
        assertThat(response.getBody()).hasSize(2); // 根据 test-data.sql 中的数据验证
    }

    @Test
    @Order(2)
    void testUpdateUser() {
        /*User user = new User(1L, "Bob Updated", "bob@example.com");
        restTemplate.put("/api/users/1", user);
        ResponseEntity<User> updatedUser = restTemplate.getForEntity("/api/users/1", User.class);
        assertThat(updatedUser.getBody().getName()).isEqualTo("Bob Updated");*/
    }
}