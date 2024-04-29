package com.inn.qms.controllerimpl;

import com.inn.qms.controller.IPersonFilterController;
import com.inn.qms.model.PersonFilter;
import com.inn.qms.service.IPersonFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personFilter")
public class PersonFilterController implements IPersonFilterController {

    @Autowired
    private IPersonFilterService personFilterService;

    @PostMapping("/save")
    public PersonFilter save(@RequestBody PersonFilter personFilter) {
        return personFilterService.createPersonFilter(personFilter);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<PersonFilter> updateFlowData(@RequestBody String json, @PathVariable Long id) {
        PersonFilter updatedFlowData = personFilterService.updatePersonFilter(json, id);
        return ResponseEntity.ok(updatedFlowData);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePersonFilter(@PathVariable Long id) {
        return personFilterService.deletePersonFilter(id);
    }

    @DeleteMapping("/deleteList")
    public String deleteMultipleData(@RequestBody List<Long> ids) {
        personFilterService.deleteLayoutDetails(ids);
        return "Data deleted successfully";
    }

    @GetMapping("/Name/{name}")
    public PersonFilter SearchByName(@PathVariable String name){
        return personFilterService.getPersonFilterByName(name);
    }

}
