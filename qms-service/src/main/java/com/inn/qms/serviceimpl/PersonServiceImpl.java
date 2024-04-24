package com.inn.qms.serviceimpl;


import com.inn.qms.dao.IPersonDao;
import com.inn.qms.model.Person;
import com.inn.qms.repository.IPersonRepository;
import com.inn.qms.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private IPersonRepository personRepository;

    @Autowired
    private IPersonDao iPersonDao;

    @Override
    public Person createPerson(Person person) {
        Person persson=	personRepository.save(person);

        return persson;
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

    @Override
    public List<Person> search(String _s) {
        return iPersonDao.search(_s);
    }
}
