package com.inn.qms.controllerImpl;

import lombok.AllArgsConstructor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.inn.qms.controller.ISiteController;
import com.inn.qms.controller.ISiteController;
import com.inn.qms.model.Site;
import com.inn.qms.service.SiteService;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/sites")
public class SiteControllerImpl implements ISiteController {

	@Autowired
    private SiteService siteService;
	
	
    // build create site REST API
    @PostMapping("/createsite")
    public ResponseEntity<Site> createSite(@RequestBody Site site){
    	System.out.println(site);
        Site savedSite = siteService.createSite(site);
        return new ResponseEntity<>(savedSite, HttpStatus.CREATED);
    }

    // build get site by id REST API
    // http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<Site> getSiteById(@PathVariable("id") Long siteId){
        Site site = siteService.getSiteById(siteId);
        return new ResponseEntity<>(site, HttpStatus.OK);
    }

    // Build Get All Sites REST API
    // http://localhost:8080/api/users
    @GetMapping("/AllSites")
    public ResponseEntity<List<Site>> getAllSites(){
        List<Site> site = siteService.getAllSites();
        return new ResponseEntity<>(site, HttpStatus.OK);
    }

    // Build Update Site REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/users/1
    public ResponseEntity<Site> updateSite(@PathVariable("id") Long siteId, @RequestBody Site site){
        site.setSiteId(siteId);
        Site updatedSite = siteService.updateSite(site);
        return new ResponseEntity<>(updatedSite, HttpStatus.OK);
    }

   
}
