package com.inn.qms.repository;

import com.inn.qms.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IPersonRepository extends JpaRepository<Person,Long> {
    Optional<Person> findByFirstName(String fileName);
}
