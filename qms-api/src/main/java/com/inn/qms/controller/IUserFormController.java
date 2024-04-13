package com.inn.qms.controller;

import com.inn.qms.model.UserForm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/userforms")
public interface IUserFormController {

    @PostMapping("/create")
    UserForm createUserForm(@RequestBody UserForm userForm);
}
