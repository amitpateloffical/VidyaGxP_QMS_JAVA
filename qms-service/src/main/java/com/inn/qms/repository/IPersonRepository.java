package com.inn.qms.repository;

import com.inn.qms.dao.IPersonDao;
import com.inn.qms.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPersonRepository extends JpaRepository<Person,Long> {

}
