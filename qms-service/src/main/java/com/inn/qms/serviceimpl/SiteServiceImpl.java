package com.inn.qms.serviceimpl;

import com.inn.qms.Respository.ISiteRepository;
import com.inn.qms.model.Site;
import com.inn.qms.service.ISiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteServiceImpl implements ISiteService {

    @Autowired
    ISiteRepository siteRepository ;
    @Override
    public Site createSite(Site site)
    {
        return siteRepository.save(site);
    }

    @Override
    public Site updateSite(Site site) {
        System.out.println("Update Data ");
        return siteRepository.save(site);
    }

    @Override
    public Site getByIdSiteDetails(Long id) {
        return siteRepository.findById(id).get();
    }

    @Override
    public List<Site> getAllSite() {
        return siteRepository.findAll();
    }

    @Override
    public Site getByNameDetails(String siteName) {
        return siteRepository.getBysiteName(siteName);
    }
}
