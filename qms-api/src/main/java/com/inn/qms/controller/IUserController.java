package com.inn.qms.controller;

import com.inn.qms.model.User;
import com.inn.qms.model.UserForm;
import com.inn.qms.wrapper.CapaWrapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/User")
public interface IUserController {


	@PostMapping("/create")
	User createUser(@RequestBody User user);

	@GetMapping("/getAll")
	List<User> getAllUsers();
}
