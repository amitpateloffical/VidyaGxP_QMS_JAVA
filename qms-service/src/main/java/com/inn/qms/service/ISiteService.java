package com.inn.qms.service;

import com.inn.qms.model.Site;

import java.util.List;

public interface ISiteService {

    public Site createSite(Site site);
    public Site updateSite(Site site,Long siteId);
    public Site getByIdSiteDetails(Long id);
    public List<Site> getAllSite();
    public Site getByNameDetails(String siteName);



}
