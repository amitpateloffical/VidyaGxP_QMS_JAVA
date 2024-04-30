package com.inn.qms.controller;
import com.inn.qms.model.ActionItem;
import jakarta.validation.Valid;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.Map;

@RequestMapping("/ActionItem")

public interface IActionItemController {

    @PostMapping("/create")
    ResponseEntity<ActionItem> createActionItem(@Valid @RequestBody ActionItem actionItem);

    @PostMapping("/createAction")
    ResponseEntity<String> createActionItem(@RequestParam("actionItemJson") String actionItemJson,
                                            @RequestParam("fileAttachments") List<MultipartFile> fileAttachments);

    @GetMapping("/download/{id}")
    ResponseEntity<byte[]> downloadFiles(@PathVariable Long id);

    @GetMapping("{id}")
    ActionItem findById(Long id);

    @GetMapping("/allAction")
    ResponseEntity<Iterable<ActionItem>> findAll();

    @PutMapping("/{id}")
    ResponseEntity<ActionItem> updateActionItem(@PathVariable Long id, @RequestBody ActionItem updatedActionItem);

    @PutMapping("/updateStatus/{id}")
    ResponseEntity<ActionItem> updateStatus(@RequestBody Map<String, String> requestBody, @PathVariable Long id);


}
