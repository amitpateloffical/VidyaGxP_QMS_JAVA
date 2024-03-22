package com.inn.qms.service;


import java.util.List;

import com.inn.qms.model.Site;

public interface SiteService {
	
	
    Site createSite(Site site);

    Site getSiteById(Long siteId);

    Site updateSite(Site site);

	List<Site> getAllSites();

 
}
