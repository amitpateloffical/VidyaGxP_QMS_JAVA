package com.inn.qms.serviceImpl;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.inn.qms.model.Site;
import com.inn.qms.repository.SiteRepository;
import com.inn.qms.service.SiteService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SiteServiceImpl implements SiteService {

	@Autowired
    private SiteRepository siteRepository;

    
    public Site createSite(Site site) {
        return siteRepository.save(site);
    }


	@Override
	public Site getSiteById(Long siteId) {
		
		 Optional<Site> optionalSite = siteRepository.findById(siteId);
	        return optionalSite.get();
	}


	@Override
    public Site updateSite(Site site) {
        Site existingSite = siteRepository.findById(site.getSiteId()).get();
        existingSite.setSiteName(site.getSiteName());
        Site updatedSite = siteRepository.save(existingSite);
        return updatedSite;
    }


	@Override
	public List<Site> getAllSites() {
        return siteRepository.findAll();
	}
    }