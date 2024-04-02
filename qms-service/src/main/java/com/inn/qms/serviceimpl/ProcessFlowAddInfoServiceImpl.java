package com.inn.qms.serviceimpl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.inn.qms.customeException.DataNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inn.qms.repository.IProcessFlowAddInfoRepository;
import com.inn.qms.repository.IProcessFlowRepository;
import com.inn.qms.repository.ISiteRepository;
import com.inn.qms.model.ProcessAdditionalInfo;
import com.inn.qms.model.ProcessFlow;
import com.inn.qms.model.Site;
import com.inn.qms.service.IProcessFlowAddInfoService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProcessFlowAddInfoServiceImpl implements IProcessFlowAddInfoService {

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private ISiteRepository siteRepository;

	@Autowired
	private IProcessFlowRepository processFlowRepository;

	@Autowired
	private IProcessFlowAddInfoRepository processFlowAddInfoRepository;

	@Override
	public ProcessAdditionalInfo create(ProcessAdditionalInfo processAdditionalInfo) {

		ProcessAdditionalInfo updatedProcessAdditionalInfo = null;
		log.info("Inside ProcessFlowAddInfoServiceImpl class create method processAdditionalInfo {} ", processAdditionalInfo);
		try {
			if (processAdditionalInfo.getProcessFlow() == null || processAdditionalInfo.getSite() == null) {
				throw new com.inn.qms.customeException.DataNotFoundException("Flow Name or Site is Null");
			}

			Optional<Site> siteOptional = siteRepository.findById(processAdditionalInfo.getSite().getSiteId());
			Site site = siteOptional.orElse(null);
			log.info("Inside ProcessFlowAddInfoServiceImpl class create method site {} ", site);

			Optional<ProcessFlow> processFlowOptional = processFlowRepository.findById(processAdditionalInfo.getProcessFlow().getId());
			ProcessFlow processFlow = processFlowOptional.orElse(null);
			log.info("Inside ProcessFlowAddInfoServiceImpl class create method processFlow {} ", processFlow);

			if (processFlow != null && site != null) {
				if (processAdditionalInfo.getProcessFlow().getFlowName() == null) {
					processAdditionalInfo.setProcessFlow(processFlow);
				}
				if (processAdditionalInfo.getSite().getSiteName() == null) {
					processAdditionalInfo.setSite(site);
				}

				log.info("Inside ProcessFlowAddInfoServiceImpl class create method in if {} ", processAdditionalInfo);
				updatedProcessAdditionalInfo = processFlowAddInfoRepository.save(processAdditionalInfo);
			} else {
				throw new com.inn.qms.customeException.DataNotFoundException("ProcessFlow or Site not found");
			}
			return updatedProcessAdditionalInfo;
		} catch (DataNotFoundException e) {
			throw e; // Re-throwing the custom exception
		} catch (Exception exception) {
			log.error("Error Creating ProcessAddInfo: {}", exception.getMessage());
			throw new RuntimeException("Error Creating ProcessAddInfo: " + exception.getMessage());
		}
	}

	@Override
	public ProcessAdditionalInfo getByIdAllDetails(Long id) {

		Optional<ProcessAdditionalInfo> processAdditionalInfoOptional = processFlowAddInfoRepository.findById(id);
		try {
			if (!processAdditionalInfoOptional.isPresent()) {
				throw new com.inn.qms.customeException.DataNotFoundException("ProcessFlowAddInfo provided ID not found");
			}
			return processAdditionalInfoOptional.get();
		} catch (NoSuchElementException e) {
			throw new com.inn.qms.customeException.DataNotFoundException("ProcessFlowAddInfo provided ID not found");
		}
	}

	@Override
	public List<Object[]> getSiteProcessFlows() {
		return processFlowAddInfoRepository.getSiteProcessFlows();
	}
	/*public List<Object[]> getSiteProcessFlows() {
		Query query = entityManager.createNativeQuery("SELECT s.site_name, GROUP_CONCAT(pf.flow_name SEPARATOR ', ') AS process_flows " +
				"FROM site s " +
				"LEFT JOIN process_additional_info pai ON s.site_id = pai.siteid_fk " +
				"LEFT JOIN process_flow pf ON pai.processflowid_fk = pf.id " +
				"GROUP BY s.site_name");
		return query.getResultList();
	}*/


}
