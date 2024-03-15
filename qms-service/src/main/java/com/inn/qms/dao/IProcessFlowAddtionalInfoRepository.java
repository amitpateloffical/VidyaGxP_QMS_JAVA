package com.inn.qms.dao;

import com.inn.qms.model.ProcessAdditionalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProcessFlowAddtionalInfoRepository extends JpaRepository<ProcessAdditionalInfo,Long> {
}
