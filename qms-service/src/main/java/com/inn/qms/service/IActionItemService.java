package com.inn.qms.service;

import com.inn.qms.model.ActionItem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IActionItemService {

    ActionItem createActionItem(ActionItem actionItem);


    ResponseEntity<String> createActionItem(String actionItemJson, List<MultipartFile> fileAttachments);

    String uploadfileAttachment(MultipartFile file) throws IOException;

    ResponseEntity<byte[]> downloadAllFiles(Long id);


    ActionItem updateActionItem(ActionItem updatedActionItem);


    ActionItem findById(Long id);

    List<ActionItem> findAll();

    ResponseEntity<String> ActionItemUpdate(String actionItemJson, List<MultipartFile> fileAttachments);


    //for upload
/*
    ResponseEntity<String> createActionItem(String actionItemJson, List<MultipartFile> files);
*/


}
