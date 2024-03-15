package com.inn.qms.dao;

import com.inn.qms.model.DataFieldValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDataFieldValueRepository extends JpaRepository<DataFieldValue,Long> {
}
