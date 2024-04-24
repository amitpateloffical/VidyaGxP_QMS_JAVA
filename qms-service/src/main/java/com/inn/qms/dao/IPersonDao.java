package com.inn.qms.dao;

import com.inn.qms.model.Person;

import java.util.List;

public interface IPersonDao {
    List<Person> search(String _s);
}
