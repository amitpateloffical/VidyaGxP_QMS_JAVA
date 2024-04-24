package com.inn.qms.controllerimpl;

import com.inn.qms.controller.IPersonController;
import com.inn.qms.model.Person;
import com.inn.qms.service.IPersonService;
import com.inn.qms.serviceimpl.PersonServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/Person")
@Slf4j
public class PersonControllerImpl implements IPersonController {

    @Autowired
    IPersonService personService;

    @Override
    @PostMapping("/create")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {

        person.setPid(generateId());
        Person createPerson = personService.createPerson(person);


        return new ResponseEntity<Person>(createPerson, HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/update/{id}")

    public ResponseEntity<Person> updatePerson(@RequestBody Person person, @PathVariable Long id) {
        Person updatePerson = personService.updatePerson(person, id);
        return new ResponseEntity<Person>(updatePerson, HttpStatus.OK);
    }

    @Override
    @GetMapping("/get/{id}")

    public Person getById(@PathVariable("id") Long id) {
        return personService.getPersonById(id);
    }

    @Override
    @GetMapping("/getAll")

    public List<Person> getAllPerson() {
        return personService.getAllPerson();
    }

    @Override
    public List<Person> search(String _s) {
        return personService.search(_s);
    }

    private String generateId() {
         final String PREFIX = "PID";
         final int NUM_DIGITS = 7; // Number of digits in the ID
         final String FORMAT = PREFIX + "%0" + NUM_DIGITS + "d";
         final AtomicInteger counter = new AtomicInteger(1);
         int id = counter.getAndIncrement();
         return String.format(FORMAT, id);
    }
}
