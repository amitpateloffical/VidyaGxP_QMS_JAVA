package com.inn.qms.controller;

import com.inn.qms.model.ProcessAdditionalInfo;
import com.inn.qms.model.ProcessFlow;

import java.util.List;

public interface IProcessFlowAddInfoController {

    ProcessAdditionalInfo create(ProcessAdditionalInfo processAdditionalInfo);
    ProcessAdditionalInfo getById(long id);

    public List<ProcessAdditionalInfo> getAllDetails();

}
