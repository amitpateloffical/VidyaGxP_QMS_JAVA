package com.inn.qms.service;

import com.inn.qms.model.ProcessAdditionalInfo;
import com.inn.qms.model.ProcessFlow;
import com.inn.qms.model.Site;

public interface IProcessFlowService {
    String create(ProcessFlow processFlow);

    String create(Site site);

    String create(ProcessAdditionalInfo processAdditionalInfo);
}
