package com.inn.qms.controller;

import com.inn.qms.model.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;



public interface IPersonController {

    ResponseEntity<Person> createPerson(Person person);


    ResponseEntity<Person> updatePerson(Person person, Long id);


    public Person getById(Long id);


    public List<Person> getAllPerson();

    @GetMapping("/search")
    public List<Person> search(@RequestParam String _s);
}
