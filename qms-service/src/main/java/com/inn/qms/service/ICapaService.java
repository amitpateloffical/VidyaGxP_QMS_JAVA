package com.inn.qms.service;

import java.util.Map;

import com.inn.qms.wrapper.CapaWrapper;


public interface ICapaService {

	String createCapa(CapaWrapper capaWrapper);

	void processNestedJson(Map<String, Object> nestedJson);
	
	void processNestedJsonnnnnn( Map<String, Object> nestedJson) throws Exception;
}
