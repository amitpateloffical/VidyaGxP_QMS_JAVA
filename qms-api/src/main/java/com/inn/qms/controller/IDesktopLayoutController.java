package com.inn.qms.controller;

import com.inn.qms.model.DesktopLayoutDetails.DesktopLayoutDetails;
import com.inn.qms.model.DesktopLayoutDetails.DesktopLayoutRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/desktop/")

public interface IDesktopLayoutController {
    @PostMapping("/create")
    DesktopLayoutDetails saveLayout(@RequestBody DesktopLayoutRequest request);

    @GetMapping("/{id}")
    DesktopLayoutDetails getDesktopLayoutById(@PathVariable Long id);

    @GetMapping("/All")
    List<DesktopLayoutDetails> getAllDesktopLayouts();

    @PutMapping("/{id}")
    DesktopLayoutDetails updateDesktopLayout(@PathVariable Long id, @RequestBody DesktopLayoutRequest desktopLayoutRequest);

     @DeleteMapping("/delete")
     ResponseEntity<String> deleteLayoutDetails(@RequestBody List<Long> ids);

    @GetMapping("/byname/{name}")
    ResponseEntity<?> findLayoutByName(@PathVariable String name);
}
