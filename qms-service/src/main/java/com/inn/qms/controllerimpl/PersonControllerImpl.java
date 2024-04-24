package com.inn.qms.controllerimpl;

import com.inn.qms.controller.IPersonController;
import com.inn.qms.model.ImageUtils;
import com.inn.qms.model.Person;
import com.inn.qms.serviceimpl.PersonServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/Person")
@Slf4j
public class PersonControllerImpl implements IPersonController {

    @Autowired
    PersonServiceImpl personService;

//    @Override
//    public ResponseEntity<Person> createPerson(Person person) {
//
//        person.setPid(generateId());
//        Person createPerson = personService.createPerson(person);
//
//
//        return new ResponseEntity<Person>(createPerson, HttpStatus.CREATED);
//    }

    @Override
    public ResponseEntity<String> createPerson(String person, MultipartFile image, MultipartFile [] references) {
        log.info("Inside PersonControllerImpl class create method {} ",person);
        return personService.createPerson(person,image,references);
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
    @PostMapping("/upload")
    public String uploadprofilePhoto(@RequestParam("image")MultipartFile file) throws IOException {
        String uploadImage = personService.uploadprofilePhoto(file);
        return "upload ";
    }

    @Override
    public ResponseEntity<byte[]> downloadPhoto(String fileName) {

     byte[]  personData= personService.downloadImage(fileName);

     if (personData !=null)
     {
         return ResponseEntity.ok()
                 .contentType(MediaType.IMAGE_PNG)
                 .body(personData);
     }
        else
     {
         return ResponseEntity.notFound().build();
     }
    }


    // @Override
//    public ResponseEntity<byte[]> downloadImage(String fileName) {
//        byte[] imageData = personService.downloadImage(fileName);
//
//        if (imageData != null) {
//            return ResponseEntity.ok()
//                    .contentType(MediaType.IMAGE_PNG) // Assuming it's a PNG image, adjust accordingly
//                    .body(imageData);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }



    private String generateId() {
         final String PREFIX = "PID";
         final int NUM_DIGITS = 7; // Number of digits in the ID
         final String FORMAT = PREFIX + "%0" + NUM_DIGITS + "d";
         final AtomicInteger counter = new AtomicInteger(1);
         int id = counter.getAndIncrement();
         return String.format(FORMAT, id);
    }


}
