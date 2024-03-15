package com.inn.qms.service.impl;


import com.inn.qms.dao.IProcessFlowAddtionalInfoRepository;
import com.inn.qms.dao.IProcessFlowRepository;
import com.inn.qms.dao.ISiteRepository;
import com.inn.qms.model.ProcessAdditionalInfo;
import com.inn.qms.model.ProcessFlow;
import com.inn.qms.model.Site;
import com.inn.qms.service.IProcessFlowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessFlowServiceImpl implements IProcessFlowService {
    private static final Logger logger = LoggerFactory.getLogger(ProcessFlowServiceImpl.class);

    @Autowired
    private IProcessFlowRepository iProcessFlowRepository;

    @Autowired
    private ISiteRepository iSiteRepository;

    @Autowired
    private IProcessFlowAddtionalInfoRepository iProcessFlowAddtionalInfoRepository;
    @Override
    public String create(ProcessFlow processFlow) {
        logger.info("Inside ProcessFlowServiceImpl class create method processFlow{}",processFlow);
        try {

            iProcessFlowRepository.save(processFlow);

        }
        catch (Exception exception){
            logger.info("logs of exception {}",exception.getMessage());
        }
        return "ok";
    }

    @Override
    public String create(Site site) {
        iSiteRepository.save(site);
        return "ok";
    }

    @Override
    public String create(ProcessAdditionalInfo processAdditionalInfo) {
       iProcessFlowAddtionalInfoRepository.save(processAdditionalInfo);
       return "ok";
    }
}
