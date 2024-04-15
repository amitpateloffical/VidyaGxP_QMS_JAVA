package com.inn.qms.controller;

import com.inn.qms.model.Person;
import org.springframework.http.ResponseEntity;

import java.util.List;



public interface IPersonController {

    ResponseEntity<Person> createPerson(Person person);


    ResponseEntity<Person> updatePerson(Person person, Long id);


    public Person getById(Long id);


    public List<Person> getAllPerson();
}
