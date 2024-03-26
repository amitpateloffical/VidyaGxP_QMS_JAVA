package com.inn.qms.controller;


import com.inn.qms.model.Site;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ISiteController {
        ResponseEntity<Site> createSite(Site site);

        ResponseEntity<Site> updateSite(Site site, Long siteId);

        public Site getByIdSite(Long id);

        public List<Site> getAllSiteDetails();

        public Site getByNameSite(String siteName);

}