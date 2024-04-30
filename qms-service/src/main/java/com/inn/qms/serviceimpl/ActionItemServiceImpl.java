package com.inn.qms.serviceimpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inn.qms.exception.BusinessException;
import com.inn.qms.model.ActionItem;
import com.inn.qms.model.Status;
import com.inn.qms.repository.IActionItemRepository;
import com.inn.qms.service.IActionItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
@Slf4j
public class ActionItemServiceImpl implements IActionItemService {

    @Autowired
    IActionItemRepository actionItemRepository;

    @Override
    public ActionItem createActionItem(ActionItem actionItem) {
        actionItem.setStatus(Status.OPEN);
        return actionItemRepository.save(actionItem);
    }

    @Override
    public ResponseEntity<String> createActionItem(String actionItemJson, List<MultipartFile> fileAttachments) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ActionItem actionItem = objectMapper.readValue(actionItemJson, ActionItem.class);
            // Validate actionItem fields
            if (StringUtils.isEmpty(actionItem.getShortDescription())) {
                throw new BusinessException("Short description is required.");
            }
            // Convert MultipartFile objects to byte[]
            Map<String, byte[]> filesData = new HashMap<>();
            for (MultipartFile file : fileAttachments) {
                String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());
                byte[] fileData = file.getBytes();
                filesData.put(originalFilename, fileData);
            }
            // Set file attachments to actionItem
            actionItem.setFileAttachments(filesData);


            actionItem.setStatus(Status.OPEN);
            // Save action item to the database
            actionItemRepository.save(actionItem);

            return ResponseEntity.ok("Action item created successfully.");
        } catch (BusinessException e) {
            log.error("Failed to create action item: {}", e.getMessage());
            return ResponseEntity.badRequest().body("Failed to create action item: " + e.getMessage());
        } catch (Exception e) {
            log.error("Failed to create action item: {}", e.getMessage());
            return ResponseEntity.badRequest().body("Failed to create action item: " + e.getMessage());
        }
    }

    @Override
    public String uploadfileAttachment(MultipartFile file) throws IOException {
        // Check if the file is not null
        if (file == null || file.isEmpty()) {
            return null;
        }

        // Get the original filename
        String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());
        // Use the original filename if provided, otherwise generate a unique filename
        String filename = StringUtils.hasText(originalFilename) ? originalFilename : UUID.randomUUID().toString();
        // Save the file data to the database
        try {
            // Convert MultipartFile to byte array
            byte[] data = file.getBytes();
            // Return the original filename for reference
            return originalFilename;
        } catch (IOException e) {
            log.error("Failed to upload file: {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public ResponseEntity<byte[]> downloadAllFiles(Long id) {
        try {
            // Find the ActionItem by its ID
            Optional<ActionItem> optionalActionItem = actionItemRepository.findById(id);
            if (optionalActionItem.isPresent()) {
                ActionItem actionItem = optionalActionItem.get();
                // Get the file attachments from the ActionItem
                Map<String, byte[]> fileAttachments = actionItem.getFileAttachments();
                if (fileAttachments != null && !fileAttachments.isEmpty()) {
                    // Create a zip stream to hold all files
                    ByteArrayOutputStream zipStream = new ByteArrayOutputStream();
                    try (ZipOutputStream zipOutputStream = new ZipOutputStream(zipStream)) {
                        for (Map.Entry<String, byte[]> entry : fileAttachments.entrySet()) {
                            byte[] fileData = entry.getValue();
                            String filename = entry.getKey();
                            // Create a new zip entry
                            zipOutputStream.putNextEntry(new ZipEntry(filename));
                            // Write file data to the zip output stream
                            zipOutputStream.write(fileData);
                            // Close the current entry
                            zipOutputStream.closeEntry();
                        }
                    }

                    // Set appropriate content type for zip file
                    HttpHeaders headers = new HttpHeaders();
                    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                    headers.setContentDispositionFormData("attachment", "files.zip");

                    // Return the zip file as a ResponseEntity
                    return ResponseEntity.ok()
                            .headers(headers)
                            .body(zipStream.toByteArray());
                } else {
                    throw new BusinessException("No files found for ActionItem with ID: " + id);
                }
            } else {
                throw new BusinessException("ActionItem not found with ID: " + id);
            }
        } catch (IOException e) {
            log.error("Error creating zip file: {}", e.getMessage());
            throw new BusinessException("Failed to download files: " + e.getMessage());
        } catch (Exception e) {
            log.error("Error downloading files: {}", e.getMessage());
            throw new BusinessException("Failed to download files: " + e.getMessage());
        }
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
        try {
            return actionItemRepository.findAll();
        } catch (Exception e) {
            log.error("Failed to find ActionItem", e);
            throw new BusinessException("Failed to find  all ActionItem: " + e);
        }
    }

    @Override
    public ResponseEntity<String> ActionItemUpdate(String actionItemJson, List<MultipartFile> fileAttachments) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ActionItem updatedActionItem = objectMapper.readValue(actionItemJson, ActionItem.class);

            Optional<ActionItem> optionalActionItem = actionItemRepository.findById(updatedActionItem.getId());
            if (optionalActionItem.isPresent()) {
                ActionItem existingActionItem = optionalActionItem.get();

                // Update all fields of existingActionItem with the fields of updatedActionItem
                existingActionItem.setShortDescription(updatedActionItem.getShortDescription());
                // Update other fields similarly

                // Convert MultipartFile objects to byte[]
                Map<String, byte[]> filesData = new HashMap<>();
                for (MultipartFile file : fileAttachments) {
                    String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());
                    byte[] fileData = file.getBytes();
                    filesData.put(originalFilename, fileData);
                }
                // Update file attachments in existingActionItem
                existingActionItem.setFileAttachments(filesData);

                // Save and return the updated action item
                actionItemRepository.save(existingActionItem);

                return ResponseEntity.ok("Action item updated successfully.");
            } else {
                return ResponseEntity.notFound().build(); // Handle not found case
            }
        } catch (IOException e) {
            log.error("Failed to update action item: {}", e.getMessage());
            return ResponseEntity.badRequest().body("Failed to update action item: " + e.getMessage());
        } catch (Exception e) {
            log.error("Failed to update action item: {}", e.getMessage());
            return ResponseEntity.badRequest().body("Failed to update action item: " + e.getMessage());
        }
    }


}


