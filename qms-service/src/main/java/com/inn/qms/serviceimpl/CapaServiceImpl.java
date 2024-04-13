package com.inn.qms.serviceimpl;

import com.inn.qms.repository.IColumnNamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inn.qms.service.ICapaService;
import com.inn.qms.wrapper.CapaWrapper;
import java.util.Map;

@Service
public class CapaServiceImpl implements ICapaService {

	@Autowired
	private IColumnNamesRepository columnNamesRepository;
	
	@Autowired
	private JsonKeyProcessorService jsonKeyProcessorService;
	
	@Override
	public String createCapa(CapaWrapper capaWrapper) {
		System.out.println(capaWrapper != null);
		System.out.println(capaWrapper.getFlowName());
		try {
			Map<String, Long> mapWithColNameAndId = jsonKeyProcessorService.processWrapperClassToJsonAndGetKeys(capaWrapper);
		System.out.println(mapWithColNameAndId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Capa Created";
	}

	public Long getColumnId(String columnName) {
		Long id ;
		id = columnNamesRepository.findColumnIDByColumnName(columnName);
		if(id == null) {
			 id = columnNamesRepository.insertColumnName(columnName);
		}
		return id;
		
	}

	@Override
	public void processNestedJson(Map<String, Object> nestedJson) {
		System.out.println("CapaServiceImpl.processNestedJson()");
		try {
			Map<String, Long> mapWithColNameAndId = jsonKeyProcessorService.processWrapperClassToJsonAndGetKeys(nestedJson);
		System.out.println(mapWithColNameAndId);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	 public void processNestedJsonnnnnn( Map<String, Object> nestedJson) throws Exception {
	        // Process the nested JSON objects using the service
	        Map<String, Long> keyIdMap = jsonKeyProcessorService.processNestedJsonAndGetKeys(nestedJson);
	        // Do something with the result if needed
	        System.out.println("Key-ID Mapping: " + keyIdMap);
	    }
}
