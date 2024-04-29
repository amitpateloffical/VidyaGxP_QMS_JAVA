package com.inn.qms.serviceimpl;

import com.inn.qms.exception.BusinessException;
import com.inn.qms.model.ActionItem;
import com.inn.qms.model.Status;
import com.inn.qms.repository.IActionItemRepository;
import com.inn.qms.service.IActionItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ActionItemServiceImpl implements IActionItemService {

    @Autowired
    IActionItemRepository actionItemRepository;


    @Override
    public ActionItem createActionItem(ActionItem actionItem) {

        actionItem.setStatus(Status.OPEN);

        ActionItem savedActionItem = actionItemRepository.save(actionItem);
        return savedActionItem;
    }


    @Override
    public ActionItem updateActionItem(ActionItem updatedActionItem) {
        Optional<ActionItem> optionalActionItem = actionItemRepository.findById(updatedActionItem.getId());
        if (optionalActionItem.isPresent()) {
            ActionItem existingActionItem = optionalActionItem.get();
            // Set all fields of existingActionItem with the fields of updatedActionItem
            try {
                Class<?> clazz = ActionItem.class;
                for (Field field : clazz.getDeclaredFields()) {
                    // Get the field name
                    String fieldName = field.getName();
                    // Get the corresponding getter method for the field
                    Method getter = clazz.getMethod("get" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1));
                    // Get the corresponding setter method for the field
                    Method setter = clazz.getMethod("set" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1), field.getType());
                    // Retrieve the value from the provided Capa object using the getter method
                    Object value = getter.invoke(updatedActionItem);

                    // Check if the value is not null and not empty (for String fields)
                    if (value != null && (!(value instanceof String) || !((String) value).isEmpty())) {
                        // Set the value to the corresponding field in the existing Capa object using the setter method
                        setter.invoke(existingActionItem, value);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace(); // Handle or log the exception
            }
            // Save and return the updated action item
            return actionItemRepository.save(existingActionItem);
        } else {
            // Handle not found case
            return null;
        }
    }

    @Override
    public ActionItem findById(Long id) {
        return actionItemRepository.findById(id).get();
    }


    @Override
    public List<ActionItem> findAll() {
        try{
            return actionItemRepository.findAll();
        }catch (Exception e){
            log.error("Failed to find ActionItem", e);
            throw new BusinessException("Failed to find  all ActionItem: " + e);
        }
    }
}
