package com.inn.qms.dao;

import com.inn.qms.model.DataField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDataFieldRepository extends JpaRepository<DataField,Long> {
}
