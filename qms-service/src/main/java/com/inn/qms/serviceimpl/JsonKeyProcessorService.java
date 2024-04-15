package com.inn.qms.serviceimpl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inn.qms.model.ColumnNames;
import com.inn.qms.model.ColumnValues;
import com.inn.qms.model.ProcessFlowDefinition;
import com.inn.qms.model.User;
import com.inn.qms.respository.IColumnNamesRepository;
import com.inn.qms.respository.IColumnValuesRepository;
import com.inn.qms.respository.IProcessFlowDefinitionRepository;
import com.inn.qms.respository.IUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class JsonKeyProcessorService {

    @Autowired
    private IColumnNamesRepository columnNamesRepository;

    @Autowired
    private IColumnValuesRepository columnValuesRepository;
    
    @Autowired
    private IProcessFlowDefinitionRepository flowDefinitionRepository;
    
    @Autowired
    private IUserRepository  iUserRepository;

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

            keyIdMap.put(key, columnName.getId());
        }

        return keyIdMap;
    }
    
    
 // Method to process nested JSON objects recursively
//    private Map<String, Long> processNestedJson(Map<String, Object> nestedJson) throws Exception {
//        Map<String, Long> nestedMap = new HashMap<>();
//        for (Map.Entry<String, Object> entry : nestedJson.entrySet()) {
//            // Recursively process nested JSON objects
//            if (entry.getValue() instanceof Map) {
//                Map<String, Long> innerMap = processNestedJson((Map<String, Object>) entry.getValue());
//                nestedMap.putAll(innerMap);
//            }
//            // For nested wrapper classes, fetch keys and IDs as before
//            else {
//                String key = entry.getKey();
//                ColumnNames columnName = columnNamesRepository.findByColumnName(key);
//                if (columnName == null) {
//                    columnName = new ColumnNames();
//                    columnName.setColumnName(key);
//                    columnName = columnNamesRepository.save(columnName);
//                }
//                nestedMap.put(key, columnName.getId());
//            }
//        }
//        return nestedMap;
//    }
    
    
//    public Map<String, Long> processNestedJsonAndGetKeys(Map<String, Object> nestedJson) throws Exception {
//        Map<String, Long> keyIdMap = new HashMap<>();
//        processNestedJsonRecursively(nestedJson, keyIdMap);
//        System.out.println(keyIdMap);
//        return keyIdMap;
//    }
//
//    private void processNestedJsonRecursively(Map<String, Object> nestedJson, Map<String, Long> keyIdMap) throws Exception {
//        for (Map.Entry<String, Object> entry : nestedJson.entrySet()) {
//            String key = entry.getKey();
//            Object value = entry.getValue();
//
//            if (value instanceof Map) {
//                processNestedJsonRecursively((Map<String, Object>) value, keyIdMap);
//            } else {
//                // Check if the key exists in the column names table
//                ColumnNames columnName = columnNamesRepository.findByColumnName(key);
//
//                // If the key doesn't exist, create a new entry in the column names table
//                if (columnName == null) {
//                    columnName = new ColumnNames();
//                    columnName.setColumnName(key);
//                    columnName = columnNamesRepository.save(columnName);
//                }
//
//                // Store the key ID in the map
//                keyIdMap.put(key, columnName.getId());
//            }
//        }
//    }
    
    
	public Map<String, Long> processNestedJsonAndGetKeys(Map<String, Object> nestedJson) throws Exception {
        Map<String, Long> keyIdMap = new HashMap<>();
        processNestedJsonRecursively(nestedJson, keyIdMap);
        return keyIdMap;
    }

    private void processNestedJsonRecursively(Map<String, Object> nestedJson, Map<String, Long> keyIdMap) throws Exception {
        System.out.println(nestedJson);
        String user  = (String) nestedJson.get("user");
        System.out.println("User is "+user);
        String flowName  = (String) nestedJson.get("flowName");
        System.out.println("FlowName is "+flowName);
    	for (Map.Entry<String, Object> entry : nestedJson.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (value instanceof List) {
                processList((List<Object>) value, keyIdMap);
            } else if (value instanceof Map) {
                processNestedJsonRecursively((Map<String, Object>) value, keyIdMap);
            } else {
                processLeafNode(key, value, keyIdMap, user);
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

    private void processLeafNode(String key, Object value, Map<String, Long> keyIdMap, String user) throws Exception {
        ColumnNames columnName = columnNamesRepository.findByColumnName(key);
       // ProcessFlowDefinition processFlowDefinition = flowDefinitionRepository.findByFlowName();
        
        System.out.println("value "+value);
        if (columnName == null) {
            columnName = new ColumnNames();
            columnName.setColumnName(key);
            columnName = columnNamesRepository.save(columnName);
        //    User user = iUserRepository.findByUserName(key)
//            ColumnValues columnValues= new ColumnValues();
//            columnValues.setColumnName(columnName);
//            columnValues.setValue(value.toString());
//            columnValues.setFlowDefinition(null);
        }
        keyIdMap.put(key, columnName.getId());
    }
}


