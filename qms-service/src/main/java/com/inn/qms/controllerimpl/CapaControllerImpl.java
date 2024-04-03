package com.inn.qms.controllerimpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.inn.qms.controller.ICapaController;
import com.inn.qms.service.ICapaService;
import com.inn.qms.wrapper.CapaWrapper;

@RestController
public class CapaControllerImpl implements ICapaController {

	
	@Autowired
	ICapaService capaService;
	
	@Override
	public String createCapa(CapaWrapper capaWrapper) {
		return capaService.createCapa(capaWrapper);
	}

	@Override
	public void processNestedJson(Map<String, Object> nestedJson) {
		// TODO Auto-generated method stub
		try {
			capaService.processNestedJsonnnnnn(nestedJson);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
