package com.inn.qms.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inn.qms.respository.IProcessFlowAddInfoRepository;
import com.inn.qms.respository.IProcessFlowRepository;
import com.inn.qms.respository.ISiteRepository;
import com.inn.qms.model.ProcessAdditionalInfo;
import com.inn.qms.model.ProcessFlow;
import com.inn.qms.model.Site;
import com.inn.qms.service.IProcessFlowAddInfoService;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProcessFlowAddInfoServiceImpl implements IProcessFlowAddInfoService {
	
	@Autowired
	private ISiteRepository siteRepository;

	@Autowired
	private IProcessFlowRepository processFlowRepository;

	@Autowired
	private IProcessFlowAddInfoRepository processFlowAddInfoRepository;

	@Override
	public ProcessAdditionalInfo create(ProcessAdditionalInfo processAdditionalInfo) {
		ProcessAdditionalInfo updatedProcessAdditionalInfo = null;
  
		log.info("Inside ProcessFlowAddInfoServiceImpl class create method processAdditionalInfo {} ",
				processAdditionalInfo);
		try {
			Optional<Site> site = siteRepository.findById(processAdditionalInfo.getSite().getSiteId());
			log.info("Inside ProcessFlowAddInfoServiceImpl class create method site {} ", site.get());
			Optional<ProcessFlow> processFlow = processFlowRepository
					.findById(processAdditionalInfo.getProcessFlow().getId());
			log.info("Inside ProcessFlowAddInfoServiceImpl class create method processFlow {} ", processFlow.get());
			log.info("Inside ProcessFlowAddInfoServiceImpl class create method PROCESSflow AND site {},{} ",
					processFlow.isPresent(), site.isPresent());
			if (processFlow.isPresent() && site.isPresent()) {
				log.info("Inside ProcessFlowAddInfoServiceImpl class create method in if {} ", processAdditionalInfo);
				updatedProcessAdditionalInfo = processFlowAddInfoRepository.save(processAdditionalInfo);
			}

		} catch (Exception exception) {
			// exception.printStackTrace();
		}
		return updatedProcessAdditionalInfo;
	}

	@Override
	public ProcessAdditionalInfo getByIdAllDetails(Long id) {
		return processFlowAddInfoRepository.findById(id).get();
	}
}
