package com.inn.qms.service;

import com.inn.qms.model.UserForm;

public abstract interface IUserFormService {
    public abstract UserForm createUserForm(UserForm userForm);

    UserForm getUserFormById(Long id);
}
