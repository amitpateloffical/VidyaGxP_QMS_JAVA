package com.inn.qms.controllerimpl;

import com.inn.qms.controller.IEntityDetailsController;
import com.inn.qms.model.EntityDetails;
import com.inn.qms.service.IEntityDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class EntityDetailsControllerImpl implements IEntityDetailsController {

    @Autowired
    private IEntityDetailsService entityDetailsService;

    @Override
    public List<EntityDetails> getAllEntities() {
        return entityDetailsService.getAllEntities();
    }

    @Override
    public EntityDetails getEntityById(@PathVariable Long id) {
        Optional<EntityDetails> entity = entityDetailsService.getEntityById(id);
        return entity.orElse(null);
    }

    @Override
    public EntityDetails createEntity(@RequestBody EntityDetails entityDetails) {
        return entityDetailsService.createEntity(entityDetails);
    }

   @Override
    public EntityDetails updateEntity(@PathVariable Long id, @RequestBody EntityDetails updatedEntityDetails) {
        return entityDetailsService.updateEntity(id, updatedEntityDetails);
    }

@Override
    public void deleteEntity(@PathVariable Long id) {
        entityDetailsService.deleteEntity(id);
        return ;
    }

    @Override
    public EntityDetails getEntityByName(@PathVariable String name) {
        Optional<EntityDetails> entity = entityDetailsService.getEntityByName(name);
        return entity.orElse(null);
    }
}
