package com.inn.qms.serviceimpl;

import com.inn.qms.customeException.DataNotFoundException;
import com.inn.qms.model.ProcessFlowDefinition;
import com.inn.qms.model.User;
import com.inn.qms.model.UserForm;
import com.inn.qms.repository.IProcessFlowDefinitionRepository;
import com.inn.qms.repository.IUserFormRepository;
import com.inn.qms.repository.IUserRepository;
import com.inn.qms.service.IUserFormService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserFormService implements IUserFormService
{
    private static final Logger logger = LoggerFactory.getLogger(UserFormService.class);
    @Autowired
    private IUserFormRepository userFormRepository;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IProcessFlowDefinitionRepository processFlowDefinitionRepository;
@Override
    public UserForm createUserForm(UserForm userForm) {
        // Check if the user exists in the database
        User user = userRepository.findById(userForm.getUser().getId()).orElse(null);
        if (user == null)
        {
            logger.info("User with ID {} does not exist.", userForm.getUser().getId());
            throw new DataNotFoundException("User with ID " + userForm.getUser().getId() + " does not exist.");
        }

        // Check if the process flow definition exists in the database
        ProcessFlowDefinition processFlowDefinition = processFlowDefinitionRepository.findById(userForm.getFlowDefinition().getId()).orElse(null);
        if (processFlowDefinition == null)
        {
            logger.info("ProcessFlowDefinition with ID {} does not exist.", userForm.getFlowDefinition().getId());
            throw new DataNotFoundException
                    ("ProcessFlowDefinition with ID " + userForm.getFlowDefinition().getId() + " does not exist.");
        }

        // Set the user and process flow definition in the userForm object
        userForm.setUser(user);
        userForm.setFlowDefinition(processFlowDefinition);
        return userFormRepository.save(userForm);
    }
  @Override
    public UserForm getUserFormById(Long id)
    {
        return userFormRepository.findById(id).orElse(null);
    }
    // Other methods for updating and deleting UserForm entities
}

