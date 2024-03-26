package com.inn.qms.repository;

import com.inn.qms.model.ProcessAdditionalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProcessFlowAddInfoRepository extends JpaRepository<ProcessAdditionalInfo,Long>
{

}