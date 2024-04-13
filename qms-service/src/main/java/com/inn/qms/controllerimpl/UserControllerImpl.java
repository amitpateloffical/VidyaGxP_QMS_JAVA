package com.inn.qms.controllerimpl;

import com.inn.qms.controller.IUserController;
import com.inn.qms.model.User;
import com.inn.qms.serviceimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserControllerImpl implements IUserController {
    @Autowired
    private UserServiceImpl.UserService userService;

    @Override
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Other controller methods as needed
}



