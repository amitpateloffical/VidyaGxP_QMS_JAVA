package com.inn.qms.repository;

import com.inn.qms.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonRepository extends JpaRepository<Person,Long> {
}
