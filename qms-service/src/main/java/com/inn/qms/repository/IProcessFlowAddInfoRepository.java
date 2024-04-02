package com.inn.qms.repository;

import com.inn.qms.model.ProcessAdditionalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProcessFlowAddInfoRepository extends JpaRepository<ProcessAdditionalInfo,Long> {
    @Query(value = "SELECT s.site_name, GROUP_CONCAT(pf.flow_name SEPARATOR ', ') AS process_flows " +
            "FROM site s LEFT JOIN process_additional_info pai ON s.site_id = pai.siteid_fk " +
            "LEFT JOIN process_flow pf ON pai.processflowid_fk = pf.id GROUP BY s.site_name", nativeQuery = true)
    List<Object[]> getSiteProcessFlows();
}