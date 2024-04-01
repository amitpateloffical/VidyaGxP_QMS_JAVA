package com.inn.qms.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inn.qms.model.ColumnNames;

@Repository
public interface IColumnNamesRepository extends JpaRepository<ColumnNames, Long> {
    // Add custom query methods if needed
}
