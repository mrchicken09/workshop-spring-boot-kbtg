package com.example.kbtg;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.example.kbtg.user.UserResponse;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void success_get_user_id_1() {
		UserResponse response = restTemplate.getForObject("/user/1", UserResponse.class);
		assertEquals(1, response.getId());
		assertEquals("marut", response.getName());
		assertEquals(30, response.getAge());

		UserResponse expected = new UserResponse(1, "marut", 30);
		assertEquals(expected, response);

	}

}
