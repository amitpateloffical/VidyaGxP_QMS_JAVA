package com.inn.qms.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inn.qms.model.ColumnNames;

import jakarta.transaction.Transactional;

@Repository
public interface IColumnNamesRepository extends JpaRepository<ColumnNames, Long> {
    
	@Query("SELECT c.id FROM ColumnNames c WHERE c.columnName = :columnName")
    Long findColumnIDByColumnName(@Param("columnName") String columnName);
	
//	@Modifying
//    @Transactional
//    @Query(value = "INSERT INTO ColumnNames (ColumnName) VALUES (:columnName)", nativeQuery = true)
//    void insertColumnName(@Param("columnName") String columnName);
	
	@Modifying
    @Transactional
    @Query(value = "INSERT INTO ColumnNames (ColumnName) VALUES (:columnName); SELECT LAST_INSERT_ID()", nativeQuery = true)
    Long insertColumnName(@Param("columnName") String columnName);
	
	
	ColumnNames findByColumnName(String columnName);
}
