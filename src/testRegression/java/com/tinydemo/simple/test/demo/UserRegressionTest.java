package com.tinydemo.simple.test.demo;

import com.tinydemo.simple.test.demo.entity.User;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("regression")
@Tag("regression")
class UserRegressionTest {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.url}")
    private String apiUrl;

    @Test
    void testFullCrudFlow() {
        // 创建用户
        User user = new User(null, "Alice", "alice@example.com");
        ResponseEntity<User> createResponse = restTemplate.postForEntity(apiUrl + "/api/users", user, User.class);
        assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

        // 查询用户
        ResponseEntity<List<User>> getResponse = restTemplate.exchange(
                "/api/users",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        assertThat(getResponse.getBody()).hasSize(1);

        // 删除用户
        restTemplate.delete(apiUrl + "/api/users/" + createResponse.getBody().getId());
        ResponseEntity<List<User>> afterDelete = restTemplate.exchange(
                "/api/users",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        assertThat(afterDelete.getBody()).isEmpty();
    }
}