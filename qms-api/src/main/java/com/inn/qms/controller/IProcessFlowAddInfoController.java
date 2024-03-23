package com.inn.qms.controller;

import com.inn.qms.model.ProcessAdditionalInfo;

public interface IProcessFlowAddInfoController {

    ProcessAdditionalInfo create(ProcessAdditionalInfo processAdditionalInfo);
    
    ProcessAdditionalInfo getById(long id);

}
