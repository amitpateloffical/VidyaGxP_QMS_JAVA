package com.inn.qms.service;

import com.inn.qms.model.ProcessAdditionalInfo;
import com.inn.qms.model.Site;

public interface IProcessFlowAddInfoService {

    ProcessAdditionalInfo create(ProcessAdditionalInfo processAdditionalInfo);

    ProcessAdditionalInfo getByIdAllDetails(Long id);

}
