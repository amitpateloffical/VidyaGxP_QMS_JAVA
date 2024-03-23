package com.inn.qms.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.inn.qms.model.Site;

public interface ISiteController {
    
	ResponseEntity<Site> createSite( Site site);

    ResponseEntity<Site> updateSite( Site site,Long siteId);
    
    public Site getByIdSite(Long id);
    
    public List<Site> getAllSiteDetails();
    
    public Site getByNameSite(String siteName);



}
