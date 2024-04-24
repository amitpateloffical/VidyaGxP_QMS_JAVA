package com.inn.qms.service;

import com.inn.qms.model.EntityDetails;

import java.util.List;
import java.util.Optional;

public interface IEntityDetailsService {
    List<EntityDetails> getAllEntities();

    Optional<EntityDetails> getEntityById(Long id);

    EntityDetails createEntity(EntityDetails entityDetails);

    EntityDetails updateEntity(Long id, EntityDetails updatedEntityDetails);

    void deleteEntity(Long id);

    Optional<EntityDetails> getEntityByName(String name);
}
