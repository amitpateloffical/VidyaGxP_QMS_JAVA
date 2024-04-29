package com.inn.qms.repository;

import com.inn.qms.model.PersonFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPersonFilterRepository extends JpaRepository<PersonFilter,Long>
{
 public PersonFilter findByname(String name);
}
