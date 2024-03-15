package com.inn.qms.controller;

import com.inn.qms.model.ProcessAdditionalInfo;
import com.inn.qms.model.ProcessFlow;
import com.inn.qms.model.Site;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IProcessFlowController {

    @PostMapping("/create")
    String create(@RequestBody ProcessFlow processFlow);


    @PostMapping("/siteCreate")
    String create(@RequestBody Site site);

    @PostMapping("/Create")
    String create(@RequestBody ProcessAdditionalInfo processAdditionalInfo);

}
