package com.inn.qms.service;

import com.inn.qms.model.ProcessAdditionalInfo;
import com.inn.qms.model.ProcessFlow;
import com.inn.qms.model.Site;

import java.util.List;

public interface IProcessFlowAddInfoService {

    ProcessAdditionalInfo create(ProcessAdditionalInfo processAdditionalInfo);

    ProcessAdditionalInfo getByIdAllDetails(Long id);

    public List<ProcessAdditionalInfo> getAllDetails();

    List<ProcessAdditionalInfo> getSiteProcessFlows();



}
