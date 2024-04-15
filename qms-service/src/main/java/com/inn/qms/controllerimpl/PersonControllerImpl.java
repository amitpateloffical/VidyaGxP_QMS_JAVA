package com.inn.qms.controllerimpl;

import com.inn.qms.controller.IPersonController;
import com.inn.qms.model.Person;
import com.inn.qms.serviceimpl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Person")
public class PersonControllerImpl implements IPersonController {

    @Autowired
    PersonServiceImpl personService;
    @Override
    @PostMapping("/create")

    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person createPerson= personService.createPerson(person);

        return new ResponseEntity<Person>(createPerson, HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/update/{id}")

    public ResponseEntity<Person> updatePerson(@RequestBody Person person,@PathVariable Long id) {
        Person updatePerson=personService.updatePerson(person, id);
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
}
