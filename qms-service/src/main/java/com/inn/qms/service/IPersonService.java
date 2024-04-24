package com.inn.qms.service;

import com.inn.qms.model.Person;

import java.util.List;

public interface IPersonService {


    public Person createPerson(Person person);

    public Person updatePerson(Person person, Long id);

    public List<Person> getAllPerson();

    public Person getPersonById(Long id);

    public List<Person> search(String _s);
}
