package com.inn.qms.controllerimpl;
import com.inn.qms.controller.IActionItemController;
import com.inn.qms.exception.BusinessException;
import com.inn.qms.model.ActionItem;
import com.inn.qms.model.Status;
import com.inn.qms.service.IActionItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class ActionItemControllerImpl implements IActionItemController {
    @Autowired
    IActionItemService actionItemService;

    @Override
    public ResponseEntity<ActionItem> createActionItem(@RequestBody ActionItem actionItem) {
        log.info("Requested to create action item");
        ActionItem createdActionItem = actionItemService.createActionItem(actionItem);
        log.info("Action item created Successfully : {} ", createdActionItem);
        return new ResponseEntity<>(createdActionItem, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> createActionItem(@RequestParam("actionItemJson") String actionItemJson,
                                                   @RequestParam("fileAttachments") List<MultipartFile> fileAttachments) {
        try {
            return actionItemService.createActionItem(actionItemJson, fileAttachments);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to create action item: " + e.getMessage());
        }
    }

    @Override
    public ResponseEntity<byte[]> downloadFiles(@PathVariable Long id) {
        try {
            return actionItemService.downloadAllFiles(id);
        } catch (BusinessException e) {
            // Handle BusinessException
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage().getBytes());
        } catch (Exception e) {
            // Handle other exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to download files".getBytes());
        }
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
        } else {
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


    @Override
    public ResponseEntity<ActionItem> updateStatus(@RequestBody Map<String, String> requestBody, @PathVariable Long id) {
        try {
            ActionItem existingActionItem = actionItemService.findById(id);
            if (existingActionItem == null) return ResponseEntity.notFound().build();

            String statusValue = requestBody.getOrDefault("status", Status.OPEN.name());
            existingActionItem.setStatus(Status.valueOf(statusValue.toUpperCase()));

            requestBody.entrySet().stream()
                    .filter(entry -> !entry.getKey().equals("status"))
                    .forEach(entry -> {
                        try {
                            Field field = ActionItem.class.getDeclaredField(entry.getKey());
                            field.setAccessible(true);
                            field.set(existingActionItem, entry.getValue());
                        } catch (Exception ignored) {}
                    });

            return ResponseEntity.ok(actionItemService.updateActionItem(existingActionItem));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateActionItem(@PathVariable("id") Long id,
                                                   @RequestParam("actionItemJson") String actionItemJson,
                                                   @RequestParam("fileAttachments") List<MultipartFile> fileAttachments) {
        try {
            ResponseEntity<String> response = actionItemService.ActionItemUpdate( actionItemJson, fileAttachments);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update action item: " + e.getMessage());
        }
    }

    }

