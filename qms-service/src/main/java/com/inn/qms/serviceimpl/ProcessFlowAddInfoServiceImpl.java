package com.inn.qms.serviceimpl;

import com.inn.qms.Respository.IProcessFlowAddInfoRepository;
import com.inn.qms.Respository.IProcessFlowRepository;
import com.inn.qms.Respository.ISiteRepository;
import com.inn.qms.controller.IProcessFlowAddInfoController;
import com.inn.qms.model.ProcessAdditionalInfo;
import com.inn.qms.model.ProcessFlow;
import com.inn.qms.model.Site;
import com.inn.qms.service.IProcessFlowAddInfoService;
import org.hibernate.resource.transaction.backend.jta.internal.synchronization.ExceptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProcessFlowAddInfoServiceImpl implements IProcessFlowAddInfoService {
    @Autowired
    private ISiteRepository siteRepository;

    @Autowired
    private IProcessFlowRepository processFlowRepository;

    @Autowired
    private IProcessFlowAddInfoRepository processFlowAddInfoRepository;

    @Override
    public ProcessAdditionalInfo create(ProcessAdditionalInfo processAdditionalInfo) {
       try {
                 Optional<Site> site =  siteRepository.findById(processAdditionalInfo.getSite().getSiteId());
                 Optional<ProcessFlow> processFlow = processFlowRepository.findById(processAdditionalInfo.getProcessFlow().getId());
                 if(processFlow.isPresent() && site.isPresent()){
                     processFlowAddInfoRepository.save(processAdditionalInfo);
                 }
                 
       }catch(Exception exception){
            exception.printStackTrace();
       }
        return null ;
    }

    @Override
    public ProcessAdditionalInfo getByIdAllDetails(Long id) {
        return processFlowAddInfoRepository.findById(id).get();
    }
}
