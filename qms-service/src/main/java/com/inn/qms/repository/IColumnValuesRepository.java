package com.inn.qms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inn.qms.model.ColumnValues;

@Repository
public interface IColumnValuesRepository extends JpaRepository<ColumnValues, Long> {
    // Add custom query methods if needed
}
