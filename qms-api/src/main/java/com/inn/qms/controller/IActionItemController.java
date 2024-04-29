package com.inn.qms.controller;

import com.inn.qms.model.ActionItem;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/ActionItem")

public interface IActionItemController {

    @PostMapping("/create")
    ResponseEntity<ActionItem> createActionItem(@Valid @RequestBody ActionItem actionItem);

    @GetMapping("{id}")
    ActionItem findById(Long id);

    @GetMapping("/allAction")
    ResponseEntity<Iterable<ActionItem>> findAll();

    @PutMapping("/{id}")
    ResponseEntity<ActionItem> updateActionItem(@PathVariable Long id, @RequestBody ActionItem updatedActionItem);

}
