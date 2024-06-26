package com.inn.qms.repository;

import com.inn.qms.model.ProcessAdditionalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inn.qms.model.ProcessFlowFieldDefinition;

import java.util.List;

@Repository
public interface IProcessFlowFieldDefinitionRepository extends JpaRepository<ProcessFlowFieldDefinition, Long> {
    // Add custom query methods if needed

    @Repository
    interface IProcessFlowAddInfoRepository extends JpaRepository<ProcessAdditionalInfo,Long> {
        @Query(value = "SELECT s.site_name, GROUP_CONCAT(pf.flow_name SEPARATOR ', ') AS process_flows " +
                "FROM site s " +
                "LEFT JOIN process_additional_info pai ON s.siteid = pai.siteid_fk " +
                "LEFT JOIN process_flow pf ON pai.processflowid_fk = pf.processflowid_fk " +
                "GROUP BY s.site_name;", nativeQuery = true)
        List<ProcessAdditionalInfo> getSiteProcessFlows();


    /*    SELECT s.site_name, GROUP_CONCAT(pf.flow_name SEPARATOR ', ') AS process_flows
        FROM site s
        LEFT JOIN process_additional_info pai ON s.siteid = pai.siteid_fk
        LEFT JOIN process_flow pf ON pai.processflowid_fk = pf.processflowid
        GROUP BY s.site_name;*/





    }
}

