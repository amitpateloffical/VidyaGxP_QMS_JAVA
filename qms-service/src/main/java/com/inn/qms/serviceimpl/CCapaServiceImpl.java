package com.inn.qms.serviceimpl;

import com.inn.qms.exception.BusinessException;
import com.inn.qms.model.Capa;
import com.inn.qms.repository.ICapaRepository;
import com.inn.qms.repository.IProcessFlowFieldDefinitionRepository;
import com.inn.qms.service.ICCapaService;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CCapaServiceImpl implements ICCapaService {


    @Autowired
    private ICapaRepository capaRepository;


    private IProcessFlowFieldDefinitionRepository processFlowFieldDefinitionRepository;


    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Capa> getAllCapas() {
        try {
            return capaRepository.findAll();
        } catch (Exception e) {
            // Log the exception
            log.error("Error occurred while retrieving all Capas", e);
            // You can rethrow the exception or handle it according to your application's logic
            throw e;
        }
    }

    @Override
    public Optional<Capa> getCapaById(Long id) {
        try {
            Optional<Capa> capaOptional = capaRepository.findById(id);
            if (!capaOptional.isPresent()) {
                throw new BusinessException("Capa with ID " + id + " not found");
            }
            return capaOptional;
        } catch (Exception e) {
            // Log the exception
            log.error("Error occurred while retrieving Capa by ID: " + id, e);
            // You can rethrow the exception or handle it according to your application's logic
            throw e;
        }
    }

    /*  @Override
      public Capa createCapa(Capa capa) {
          return capaRepository.save(capa);
      }*/
    public Capa createCapa(Capa capa) {
        // Generate and set record number
       if (capa.getShort_Description() == null || capa.getShort_Description().isEmpty()) {
            throw new BusinessException("Short_Description is mandatory");
      }
        capa.setRecord_Number(generateRecordNumber());
        return capaRepository.save(capa);
    }
    public String generateRecordNumber() {
        LocalDate currentDate = LocalDate.now();
        // Extract only the year part
        int year = currentDate.getYear();
        // Retrieve the latest record number from the database
        Capa latestCapa = capaRepository.findTopByOrderByIdDesc();
        int number;
        if (latestCapa == null || latestCapa.getRecord_Number() == null || latestCapa.getRecord_Number().equals("0")) {
            number = 1; // Set the number to 1 if no previous record exists or if the latest record number is null or 0
        } else {
            String latestRecordNumber = latestCapa.getRecord_Number();
            number = Integer.parseInt(latestRecordNumber.substring(latestRecordNumber.lastIndexOf("/") + 1));
            number++; // Increment the number
        }
        Capa myObject = new Capa();
        String className = myObject.getClass().getSimpleName();
        return "KSA/" + className + "/" + String.format("%04d", year) + "/" + String.format("%03d", number); // Format the number to 3 digits with leading zeros

    }
    @Override
    public Capa updateCapa(Capa capa) {
        // Fetch the existing Capa object from the database
        Optional<Capa> existingCapaOptional = capaRepository.findById(capa.getId());
        if (existingCapaOptional.isPresent()) {
            Capa existingCapa = existingCapaOptional.get();
            try {
                Class<?> clazz = Capa.class;
                for (Field field : clazz.getDeclaredFields()) {
                    // Get the field name
                    String fieldName = field.getName();
                    // Skip the record_Number field
                    if(fieldName.equals("record_Number")) {
                        continue;
                    }
                    // Get the corresponding getter method for the field
                    Method getter = clazz.getMethod("get" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1));
                    // Get the corresponding setter method for the field
                    Method setter = clazz.getMethod("set" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1), field.getType());
                    // Retrieve the value from the provided Capa object using the getter method
                    Object value = getter.invoke(capa);

                    // Check if the value is not null and not empty (for String fields)
                    if (value != null && (!(value instanceof String) || !((String) value).isEmpty())) {
                        // Set the value to the corresponding field in the existing Capa object using the setter method
                        setter.invoke(existingCapa, value);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace(); // Handle or log the exception
            }
            // Save the updated Capa object
            return capaRepository.save(existingCapa);
        } else {
            // Handle case where the provided Capa object does not exist in the database
            // You can throw an exception or handle it according to your application's logic
            return null;
        }
    }
  /* @Override
    public Capa updateCapa(Capa capa) {
        return capaRepository.save(capa);
    }*/

        @Override
        public void deleteCapa (Long id){
            capaRepository.deleteById(id);
        }


    }
