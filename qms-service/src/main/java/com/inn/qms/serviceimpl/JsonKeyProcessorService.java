package com.inn.qms.serviceimpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inn.qms.model.*;
import com.inn.qms.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class JsonKeyProcessorService {


    @Autowired
    private IProcessFlowRepository processFlowRepository;
    @Autowired
    private IColumnNamesRepository columnNamesRepository;

    @Autowired
    private IColumnValuesRepository IColumnValuesRepository;

    @Autowired
    IUserRepository userRepository;
    @Autowired
    IUserFormRepository userFormRepository;

    @Autowired
    private IProcessFlowDefinitionRepository flowDefinitionRepository;

    public <T> Map<String, Long> processWrapperClassToJsonAndGetKeys(T wrapper) throws Exception {
    final ObjectMapper objectMapper = new ObjectMapper();
    String jsonString = objectMapper.writeValueAsString(wrapper);

    Map<String, Object> jsonMap = objectMapper.readValue(jsonString, Map.class);
    Set<String> keys = jsonMap.keySet();
    Map<String, Long> keyIdMap = new HashMap<>();

    for (String key : keys) {
        ColumnNames columnName = columnNamesRepository.findByColumnName(key);

            if (columnName == null) {
            columnName = new ColumnNames();
            columnName.setColumnName(key);
            columnName = columnNamesRepository.save(columnName);
        }
        // Assuming you want to keep the last put operation as it overwrites the previous one
        // You might need to adjust this logic based on your requirements
        keyIdMap.put(key, columnName.getId());
    }

    return keyIdMap;
}
    //for user



    public Map<String, Long> processNestedJsonAndGetKeys(Map<String, Object> nestedJson) throws Exception {
        Map<String, Long> keyIdMap = new HashMap<>();
        processNestedJsonRecursively(nestedJson, keyIdMap);
        return keyIdMap;
    }

    private void processNestedJsonRecursively(Map<String, Object> nestedJson, Map<String, Long> keyIdMap)
            throws Exception {
        for (Map.Entry<String, Object> entry : nestedJson.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (value instanceof List) {
                processList((List<Object>) value, keyIdMap);
            } else if (value instanceof Map) {
                processNestedJsonRecursively((Map<String, Object>) value, keyIdMap);
            } else {
                processLeafNode(key, value, keyIdMap);
            }
        }
    }

    private void processList(List<Object> list, Map<String, Long> keyIdMap) throws Exception {
        for (Object item : list) {
            if (item instanceof Map) {
                processNestedJsonRecursively((Map<String, Object>) item, keyIdMap);
            } else {
               //To-do
            }
        }
    }

    private void processLeafNode(String key, Object value, Map<String, Long> keyIdMap) throws Exception {
        ColumnNames columnName = columnNamesRepository.findByColumnName(key);
        System.out.println("value " + value);


        if (columnName == null) {
            columnName = new ColumnNames();
            columnName.setColumnName(key);
            columnName = columnNamesRepository.save(columnName);
//
        }
            keyIdMap.put(key, columnName.getId());
        }
    }