package com.inn.qms.controllerimpl;

import com.inn.qms.controller.ICCapaController;
import com.inn.qms.model.Capa;
import com.inn.qms.service.ICCapaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CCapaControllerImpl implements ICCapaController {

    @Autowired
    private ICCapaService capaService;

    @Override
    public List<Capa> getAllCapas() {
        return capaService.getAllCapas();
    }

    @Override
    public Capa getCapaById(@PathVariable Long id) {
        return capaService.getCapaById(id)
                .orElseThrow(() -> new RuntimeException("Capa not found with id: " + id));
    }

    @Override
    public Capa createCapa(@Valid Capa capa) {
        return capaService.createCapa(capa);
    }

    @Override
    public Capa updateCapa(@PathVariable Long id, @RequestBody Capa capa) {
        capa.setId(id);
        return capaService.createCapa(capa);
    }

    @Override
    public void deleteCapa(@PathVariable Long id) {
        capaService.deleteCapa(id);
    }
}

