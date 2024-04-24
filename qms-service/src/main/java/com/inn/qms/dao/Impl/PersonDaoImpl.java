package com.inn.qms.dao.Impl;


import com.inn.qms.dao.IPersonDao;
import com.inn.qms.model.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class PersonDaoImpl implements IPersonDao {


    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Person> search(String _s) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Person> cq = cb.createQuery(Person.class);
        Root<Person>person = cq.from(Person.class);
        Predicate searchPredicate = cb.like(person.get("firstName"),"%"+_s+"%");
        cq.where(searchPredicate);
        TypedQuery<Person> query = em.createQuery(cq);
        return query.getResultList();
    }
}
