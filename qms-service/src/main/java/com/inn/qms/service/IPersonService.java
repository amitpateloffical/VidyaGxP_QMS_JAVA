package com.inn.qms.service;

import com.inn.qms.model.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IPersonService {


    public ResponseEntity<String> createPerson(String person, MultipartFile image, MultipartFile [] references);

    public Person updatePerson(Person person, Long id);

    public List<Person> getAllPerson();

    public Person getPersonById(Long id);

    public String uploadprofilePhoto(MultipartFile file) throws IOException;

    public byte[] downloadImage(String fileName);
}
