package com.inn.qms.dao;

import com.inn.qms.model.ProcessFlowAttachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProcessFlowAttachmentRepository extends JpaRepository<ProcessFlowAttachment,Long> {
}
