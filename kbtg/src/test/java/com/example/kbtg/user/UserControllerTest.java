package com.example.kbtg.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.example.kbtg.user.ErrorResponse;
import com.example.kbtg.user.UserNotFoundException;
import com.example.kbtg.user.UserResponse;
import com.example.kbtg.user.UserService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
	@Autowired
	private TestRestTemplate restTemplate;
	@Autowired
	private UserService userservice;
	@Autowired
	private UserRepository userRepository;
	
	@AfterEach
	public void clearData() {
		userRepository.deleteAll();
	}

	@Test
	public void success_get_user_id_1() {
		 MyUser adduser = new MyUser();
	        adduser.setName("marut");
	        adduser.setAge(30);
	        userRepository.save(adduser);
	        
		UserResponse response = restTemplate.getForObject("/user/1", UserResponse.class);
		assertEquals(1, response.getId());
		assertEquals("marut", response.getName());
		assertEquals(30, response.getAge());

		UserResponse expected = new UserResponse(1, "marut", 30);
		assertEquals(expected, response);

	}
	
	@Test
	public void throw_exception_user_not_found_id_15() {
		ErrorResponse response = restTemplate.getForObject("/user/15", ErrorResponse.class);
		assertEquals(1234, response.getCode());

		assertEquals("User not found id = 15", response.getMessage());

	}
	
//	@Test
//	public void throw_exception_user_not_found_id_15() {
//		 
//	        // JUnit 5 style
//	        Exception exception = assertThrows(RuntimeException.class, () -> {
//	        	userservice.getInfo(15);
//	        });
//	        assertEquals("User not found id = 15", exception.getMessage());
//
//	}

}
