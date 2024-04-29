package com.inn.qms.controllerimpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inn.qms.controller.IActionItemController;
import com.inn.qms.model.ActionItem;
import com.inn.qms.model.Status;
import com.inn.qms.service.IActionItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class ActionItemControllerImpl implements IActionItemController {
    @Autowired
    IActionItemService actionItemService;
    @Override
    public ResponseEntity<ActionItem> createActionItem(ActionItem actionItem) {
        log.info("Requested to create action item");
        ActionItem createdActionItem = actionItemService.createActionItem(actionItem);
        log.info("Action item created Successfully : {} " , createdActionItem);
        return new ResponseEntity<>(createdActionItem, HttpStatus.CREATED);
    }

    @Override
 public ActionItem findById(Long id) {
        return actionItemService.findById(id);
    }

    @Override
    public ResponseEntity<Iterable<ActionItem>> findAll() {
        log.info("Requested to find all ActionItems");
        List<ActionItem> actionItem = actionItemService.findAll();
        if (!actionItem.isEmpty()) {
            return new ResponseEntity<>(actionItem, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<ActionItem> updateActionItem(@PathVariable Long id, @RequestBody ActionItem updatedActionItem) {
        updatedActionItem.setId(id); // Set the ID of the updatedActionItem

        ActionItem updatedItem = actionItemService.updateActionItem(updatedActionItem);
        if (updatedItem != null) {
            return new ResponseEntity<>(updatedItem, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<ActionItem> updateStatus(@RequestBody Map<String, String> requestBody, @PathVariable Long id) {

        try {
            ActionItem existingActionItem = actionItemService.findById(id);
            if (existingActionItem == null) {
                return ResponseEntity.notFound().build();
            }

            existingActionItem.setStatus(Status.valueOf(requestBody.getOrDefault("status", Status.OPEN.name()).toUpperCase()));
            requestBody.remove("status");

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.readerForUpdating(existingActionItem).readValue(objectMapper.writeValueAsString(requestBody));

            return ResponseEntity.ok(actionItemService.updateActionItem(existingActionItem));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }


}