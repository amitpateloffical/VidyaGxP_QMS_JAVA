package com.inn.qms.serviceimpl;



import com.inn.qms.model.Person;
import com.inn.qms.repository.IPersonRepository;
import com.inn.qms.service.IPersonService;
import com.inn.qms.utils.JsonUtils;
import com.inn.qms.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class PersonServiceImpl implements IPersonService {

    @Autowired
    IPersonRepository personRepository;


    @Override
    public ResponseEntity<String> createPerson(String person,MultipartFile image,MultipartFile [] references) {
      log.info("Inside PersonServiceImpl class create method");
        Person personObject = null;
        try{
            if(!StringUtils.isEmpty(person)){
            personObject = JsonUtils.fromJson(person,Person.class);}
            log.info("Parse String into Person Object {}",personObject);
            if(personObject==null  || image==null || references==null)
            {
                throw new IllegalArgumentException("Invalid request data");
            }
             personObject.setProfilePhoto(image.getBytes());
             personRepository.save(personObject);
            return new ResponseEntity<>("User Create Successfully",HttpStatus.CREATED);

        } catch (IllegalArgumentException e) {
            log.error("Inside PersonServiceImpl class create method {}",e.getMessage());

            // Return error response for invalid request data
            return ResponseEntity.badRequest().body("Invalid request: " + e.getMessage());
        }catch (Exception e) {
            log.error("Inside PersonService Class craete Method {}",e.getMessage());
            // Return error response for IO exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error uploading files: " + e.getMessage());
        }
    }

    @Override
    public Person updatePerson(Person person, Long id) {
        Person PersonId=personRepository.findById(id).orElseThrow(()-> new RuntimeException("Person Not Found"));
        PersonId.setFirstName(person.getFirstName());
        personRepository.save(PersonId);

        return PersonId;
    }

    @Override
    public List<Person> getAllPerson() {
        List<Person> personDetails=personRepository.findAll();
        return personDetails;
    }

    @Override
    public Person getPersonById(Long id) {

        Optional<Person> person	= personRepository.findById(id);
        return person.get();

    }


    public String uploadprofilePhoto(MultipartFile file) throws IOException {

//        Person personData = personRepository.save(Person.builder()
//                .firstName(file.getOriginalFilename()) // Correct this attribute for image data
//                .lastName(file.getContentType()) // Correct this attribute for image data
//                .profilePhoto(ImageUtils.compressImage(file.getBytes())).build()); // Correct this attribute for image data
//        if (personData != null) {
//            return "file uploaded successfully : " + file.getOriginalFilename();
    //    }
        return "Test";

    }

    @Override
    public byte[] downloadImage(String fileName) {

       Optional<Person> personImage =personRepository.findByFirstName(fileName);
       //byte[] images= ImageUtils.decompressImage(personImage.get().getProfilePhoto());
       return null;
//
    }
}

