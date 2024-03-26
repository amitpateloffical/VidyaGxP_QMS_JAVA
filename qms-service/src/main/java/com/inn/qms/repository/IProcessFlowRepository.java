package com.inn.qms.repository;


import com.inn.qms.model.ProcessFlow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProcessFlowRepository extends JpaRepository<ProcessFlow,Long>
{

}