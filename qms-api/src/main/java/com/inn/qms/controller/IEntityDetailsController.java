package com.inn.qms.controller;

import com.inn.qms.model.EntityDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/entities")
public interface IEntityDetailsController {
    @GetMapping("/All")
    List<EntityDetails> getAllEntities();

    @GetMapping("/{id}")
    EntityDetails getEntityById(@PathVariable Long id);

    @PostMapping("/create")
    EntityDetails createEntity(@RequestBody EntityDetails entityDetails);

    @PutMapping("update/{id}")
    EntityDetails updateEntity(@PathVariable Long id, @RequestBody EntityDetails updatedEntityDetails);

    @DeleteMapping("/{id}")
    void deleteEntity(@PathVariable Long id);

    @GetMapping("/name/{name}")
    EntityDetails getEntityByName(@PathVariable String name);
}
