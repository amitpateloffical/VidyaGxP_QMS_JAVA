package com.inn.qms.controller;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inn.qms.wrapper.CapaWrapper;

@RestController
@RequestMapping("/capa")
public interface ICapaController {

	@PostMapping(path = "create", consumes = MediaType.APPLICATION_JSON_VALUE)
	String createCapa(@RequestBody(required = true) CapaWrapper capaWrapper);

	@PostMapping("/process")
	public void processNestedJson(@RequestBody Map<String, Object> nestedJson) ;

}
