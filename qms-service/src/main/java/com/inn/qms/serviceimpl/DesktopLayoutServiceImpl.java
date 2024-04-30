package com.inn.qms.serviceimpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inn.qms.exception.BusinessException;
import com.inn.qms.model.DesktopLayoutDetails.DesktopLayoutDetails;
import com.inn.qms.model.DesktopLayoutDetails.DesktopLayoutRequest;
import com.inn.qms.model.DesktopLayoutDetails.LayoutDataField;
import com.inn.qms.repository.DesktopLayoutRepository;
import com.inn.qms.service.DesktopLayoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class DesktopLayoutServiceImpl implements DesktopLayoutService {

    private static final Logger logger = LoggerFactory.getLogger(DesktopLayoutServiceImpl.class);

    @Autowired
    private DesktopLayoutRepository desktopLayoutRepository;

    @Override
    public DesktopLayoutDetails saveLayout(DesktopLayoutRequest request) {
        String layoutName = request.getName();
        // Check if the name field is null or empty
        if (layoutName == null || layoutName.isEmpty()) {
            throw new BusinessException("Desktop Layout name is mandatory.");
        }
        // Check if the layout name already exists
        if (desktopLayoutRepository.existsByname(layoutName)) {
            throw new BusinessException("Desktop Layout name '" + layoutName + "' already exists.");
        }
        DesktopLayoutDetails layout = new DesktopLayoutDetails();
        layout.setName(layoutName);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            layout.setLayoutDataFields(objectMapper.writeValueAsString(request.getLayoutDataFields()));
        } catch (JsonProcessingException e) {
            logger.error("Error processing JSON for layout data fields", e);
            throw new BusinessException("Error processing JSON for layout data fields", e);
        }
        return desktopLayoutRepository.save(layout);
    }

    @Override
    public DesktopLayoutDetails updateLayout(Long id, DesktopLayoutRequest request) {
        Optional<DesktopLayoutDetails> optionalLayout = desktopLayoutRepository.findById(id);

        LayoutDataField l1 = new LayoutDataField();
        if (optionalLayout.isPresent()) {
            DesktopLayoutDetails layout = optionalLayout.get();
            // Check if the name field is to be updated
            if (request.getName() != null) {
                layout.setName(request.getName());
            }
            // Check if the layoutDataFields field is to be updated
            if (request.getLayoutDataFields() != null) {
                try {
                    ObjectMapper objectMapper = new ObjectMapper();
                    layout.setLayoutDataFields(objectMapper.writeValueAsString(request.getLayoutDataFields()));
                } catch (JsonProcessingException e) {
                    logger.error("Error processing JSON for layout data fields", e);
                    throw new BusinessException("Error processing JSON for layout data fields", e);
                }
            }
            return desktopLayoutRepository.save(layout);
        } else {
            logger.error("Desktop Layout not found with id {}", id);
            throw new BusinessException("Desktop Layout not found with id " + id);
        }
    }
    @Override
    public DesktopLayoutDetails findLayoutByName(String name) {
        Optional<DesktopLayoutDetails> optionalLayout = desktopLayoutRepository.findByName(name);
        if (optionalLayout.isPresent()) {
            return optionalLayout.get();
        } else {
            logger.error("Desktop Layout not found with name '{}'", name);
            throw new BusinessException("Desktop Layout not found with name '" + name + "'");
        }
    }

    @Override
    public DesktopLayoutDetails getById(Long id) {
        return desktopLayoutRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Desktop Layout not found with id " + id));
    }

    @Override
    public List<DesktopLayoutDetails> getAll() {
        Logger logger = LoggerFactory.getLogger(DesktopLayoutServiceImpl.class);
        try {
            return desktopLayoutRepository.findAll();
        } catch (Exception e) {
            logger.error("Error occurred while fetching all desktop layouts", e);
            throw new RuntimeException("Error occurred while fetching all desktop layouts", e);
        }
    }

    @Override
    public void deleteLayoutDetails(List<Long> ids) {
        // Check if the list of IDs is null or empty
        if (ids == null || ids.isEmpty()) {
            throw new IllegalArgumentException("List of IDs is null or empty.");
        }
        // Loop through each ID and delete the corresponding entity...
        for (Long id : ids) {
            // Check if the entity exists before attempting deletation
            if (desktopLayoutRepository.existsById(id)) {
                desktopLayoutRepository.deleteById(id);
            } else {
                throw new IllegalArgumentException("Entity with ID " + id + " does not exist....");
            }
        }
    }
    // Other methods omitted for brevity. .. ...
}