package com.inn.qms.controller;

import com.inn.qms.model.Person;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;



public interface IPersonController {

    @PostMapping(value = "/create",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<String> createPerson(@RequestParam String person, @RequestParam("image")MultipartFile image, @RequestParam("references")MultipartFile [] references);


    ResponseEntity<Person> updatePerson(Person person, Long id);


    public Person getById(Long id);


    public List<Person> getAllPerson();

    public String uploadprofilePhoto(MultipartFile file) throws IOException;

  //  public byte[] downloadImage(String fileName);
    ResponseEntity<byte[]> downloadPhoto(String fileName);
}
