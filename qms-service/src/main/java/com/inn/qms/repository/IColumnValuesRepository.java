package com.inn.qms.repository;

import com.inn.qms.model.ColumnValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IColumnValuesRepository extends JpaRepository<ColumnValues, Long> {

}
