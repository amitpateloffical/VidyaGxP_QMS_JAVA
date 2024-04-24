package com.inn.qms.serviceimpl;

import com.inn.qms.exception.BusinessException;
import com.inn.qms.model.EntityDetails;
import com.inn.qms.repository.EntityDetailsRepository;
import com.inn.qms.service.IEntityDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class EntityDetailsServiceImpl implements IEntityDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(EntityDetailsServiceImpl.class);

    @Autowired
    private EntityDetailsRepository entityDetailsRepository;

    @Override
    public List<EntityDetails> getAllEntities() {
        try {
            return entityDetailsRepository.findAll();
        } catch (Exception e) {
            logger.error("An error occurred while retrieving all entities: {}", e.getMessage());
            throw new BusinessException("Failed to retrieve all entities", e);
        }
    }

    @Override
    public Optional<EntityDetails> getEntityById(Long id) {
        try {
            return entityDetailsRepository.findById(id);
        } catch (Exception e) {
            logger.error("An error occurred while retrieving entity with id {}: {}", id, e.getMessage());
            throw new BusinessException("Failed to retrieve entity with id " + id, e);
        }
    }

    @Override
    public EntityDetails createEntity(EntityDetails entityDetails) {
        try {
            // Check if the name is provided
            if (entityDetails.getName() == null || entityDetails.getName().isEmpty()) {
                throw new BusinessException("Entity name is mandatory");
            }
            // Check if the name already exists in the database
            Optional<EntityDetails> existingEntity = entityDetailsRepository.findByName(entityDetails.getName());
            if (existingEntity.isPresent()) {
                throw new BusinessException("Entity with name " + entityDetails.getName() + " already exists");
            }

            return entityDetailsRepository.save(entityDetails);
        } catch (IllegalArgumentException e) {
            logger.error("Entity name is mandatory: {}", e.getMessage());
            throw e;
        } catch (BusinessException e) {
            logger.error("Duplicate entity name found while creating entity: {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("An error occurred while creating entity: {}", e.getMessage());
            throw new BusinessException("Failed to create entity", e);
        }
    }


    public EntityDetails updateEntity(Long id, EntityDetails updatedEntityDetails) {
        try { // Code For Update Specific DataField Change
            Optional<EntityDetails> existingEntityOptional = entityDetailsRepository.findById(id);
            if (existingEntityOptional.isPresent()) {
                EntityDetails existingEntity = existingEntityOptional.get();
                // Check each field if it's updated, if not, keep the existing value
                if (updatedEntityDetails.getName() != null) {
                    existingEntity.setName(updatedEntityDetails.getName());
                }
                if (updatedEntityDetails.getSalesPerson() != null) {
                    existingEntity.setSalesPerson(updatedEntityDetails.getSalesPerson());
                }
                if (updatedEntityDetails.getAccountManager() != null) {
                    existingEntity.setAccountManager(updatedEntityDetails.getAccountManager());
                }
                if (updatedEntityDetails.getTerritory() != null) {
                    existingEntity.setTerritory(updatedEntityDetails.getTerritory());
                }
                if (updatedEntityDetails.getExternalId() != null) {
                    existingEntity.setExternalId(updatedEntityDetails.getExternalId());
                }
                if (updatedEntityDetails.getIsCustomer() != null) {
                    existingEntity.setIsCustomer(updatedEntityDetails.getIsCustomer());
                }
                if (updatedEntityDetails.getCustomerId() != null) {
                    existingEntity.setCustomerId(updatedEntityDetails.getCustomerId());
                }
                if (updatedEntityDetails.getIsActive() != null) {
                    existingEntity.setIsActive(updatedEntityDetails.getIsActive());
                }
                if (updatedEntityDetails.getDateCustomer() != null) {
                    existingEntity.setDateCustomer(updatedEntityDetails.getDateCustomer());
                }
                if (updatedEntityDetails.getDateExpired() != null) {
                    existingEntity.setDateExpired(updatedEntityDetails.getDateExpired());
                }
                if (updatedEntityDetails.getPersonsInEntity() != null) {
                    existingEntity.setPersonsInEntity(updatedEntityDetails.getPersonsInEntity());
                }
                if (updatedEntityDetails.getBusinessDescription() != null) {
                    existingEntity.setBusinessDescription(updatedEntityDetails.getBusinessDescription());
                }
                // Repeat the above for other fields...

                return entityDetailsRepository.save(existingEntity);
            } else {
                throw new BusinessException("Entity with id " + id + " not found");
            }
        } catch (BusinessException e) {
            logger.error("Entity not found while updating entity with id {}: {}", id, e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("An error occurred while updating entity with id {}: {}", id, e.getMessage());
            throw new BusinessException("Failed to update entity with id " + id, e);
        }
    }


    @Override
    public void deleteEntity(Long id) {
        try {
            entityDetailsRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("An error occurred while deleting entity with id {}: {}", id, e.getMessage());
            throw new BusinessException("Failed to delete entity with id " + id, e);
        }
    }

    @Override
    public Optional<EntityDetails> getEntityByName(String name) {
        try {
            return entityDetailsRepository.findByName(name);
        } catch (Exception e) {
            logger.error("An error occurred while retrieving entity with name {}: {}", name, e.getMessage());
            throw new BusinessException("Failed to retrieve entity with name " + name, e);
        }
    }
}
