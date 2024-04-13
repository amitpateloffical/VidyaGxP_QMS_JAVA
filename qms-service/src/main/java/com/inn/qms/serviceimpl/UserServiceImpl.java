package com.inn.qms.serviceimpl;

import com.inn.qms.model.User;
import com.inn.qms.model.UserForm;
import com.inn.qms.repository.IUserRepository;
import com.inn.qms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl  {

	@Service
	public class UserService {
		@Autowired
		private IUserRepository userRepository;

		public User createUser(User user) {
			return userRepository.save(user);
		}

		public List<User> getAllUsers() {
			return userRepository.findAll();
		}

		// Other service methods as needed
	}


}
