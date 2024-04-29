package com.inn.qms.controller;

import com.inn.qms.model.Capa;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/capas")
public interface ICCapaController {
    @GetMapping("/All")
    List<Capa> getAllCapas();

    @GetMapping("/{id}")
    Capa getCapaById(@PathVariable Long id);

    @PostMapping("/create")
    Capa createCapa(@Valid @RequestBody Capa capa);

    @PutMapping("/{id}")
    Capa updateCapa(@PathVariable Long id, @RequestBody Capa capa);

    @DeleteMapping("/{id}")
    void deleteCapa(@PathVariable Long id);
}
