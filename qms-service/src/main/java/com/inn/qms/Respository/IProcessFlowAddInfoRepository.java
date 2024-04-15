package com.inn.qms.Respository;

import com.inn.qms.model.ProcessAdditionalInfo;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface IProcessFlowAddInfoRepository extends JpaRepository<ProcessAdditionalInfo,Long> {
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
