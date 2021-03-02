package com.example.kbtg.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	@Mock
	private UserRepository userRepository;

	@Test
	public void found_user_by_id_1() {
		// Arrange
		MyUser adduser = new MyUser();
		adduser.setId(1);
		adduser.setName("marut");
		adduser.setAge(30);
		when(userRepository.findById(1)).thenReturn(Optional.of(adduser));

		UserService userService = new UserService(userRepository);
		UserResponse response = userService.getInfo(1);
		// Assert
		assertEquals(1, response.getId());
		assertEquals("marut", response.getName());
		assertEquals(30, response.getAge());
	}

	@Test
	public void user_not_found_with_id_15_should_throw_exception() {

		when(userRepository.findById(15)).thenThrow(new UserNotFoundException("User not found id = 15"));

		Exception exception = assertThrows(RuntimeException.class, () -> {
			UserService userService = new UserService(userRepository);
			userService.getInfo(1);
		});
		assertEquals("User not found id = 15", exception.getMessage());
	}
}
