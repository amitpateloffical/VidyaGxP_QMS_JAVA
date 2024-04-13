package com.inn.qms.controllerimpl;

import com.inn.qms.controller.IUserFormController;
import com.inn.qms.model.UserForm;
import com.inn.qms.serviceimpl.UserFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserFormController implements IUserFormController {
    @Autowired
    private UserFormService userFormService;


    @Override
    public UserForm createUserForm(@RequestBody UserForm userForm) {
        return userFormService.createUserForm(userForm);
    }

    // Other controller methods as needed
}

