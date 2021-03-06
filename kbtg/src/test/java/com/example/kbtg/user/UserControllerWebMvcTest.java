package com.example.kbtg.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.example.kbtg.user.ErrorResponse;
import com.example.kbtg.user.UserController;
import com.example.kbtg.user.UserNotFoundException;
import com.example.kbtg.user.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(UserController.class)
public class UserControllerWebMvcTest {
	@Autowired
	private MockMvc mvc;
	@MockBean
	private UserService userService;

	@Test
	public void failure_user_not_found() throws Exception {
		// Arrange
		when(userService.getInfo(15)).thenThrow(new UserNotFoundException("User not found id = 15"));
		// Act
		MvcResult mvcResult = mvc.perform(get("/user/15").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andReturn();

		// String >>> JSON Message
		String jsonResult = mvcResult.getResponse().getContentAsString();
		// Convert JSON message to Object||POJO
		ObjectMapper mapper = new ObjectMapper();
		ErrorResponse response = mapper.readValue(jsonResult, ErrorResponse.class);
		// Assert
		assertEquals(1234, response.getCode());
		assertEquals("User not found id = 15", response.getMessage());
	}
}
