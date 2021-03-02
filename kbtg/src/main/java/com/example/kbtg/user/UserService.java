package com.example.kbtg.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	public UserResponse getInfo(int id) {
		if (id <= 10) {
			//success
			return new UserResponse(id, "marut", 30);

		}
		//fail
			throw new UserNotFoundException("User not found id = 15" + id);
		
	}

	

}
