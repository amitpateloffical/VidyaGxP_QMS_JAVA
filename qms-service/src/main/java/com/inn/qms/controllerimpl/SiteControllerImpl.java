package com.inn.qms.controllerimpl;

import com.inn.qms.controller.ISiteController;
import com.inn.qms.model.Site;
import com.inn.qms.service.ISiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "**",allowedHeaders = "**")
@RequestMapping("/Site")
public class SiteControllerImpl implements ISiteController {

	@Autowired
	ISiteService siteService;

	@Override
	@PostMapping("/createSite")
	public ResponseEntity<Site> createSite(@RequestBody Site site) {
		Site createdSite = siteService.createSite(site);
		return new ResponseEntity<Site>(createdSite, HttpStatus.CREATED);
	}

	@Override
	@PutMapping("/update/{siteId}")
	public ResponseEntity<Site> updateSite(@RequestBody Site site, @PathVariable Long siteId) {
		Site updatedSite = siteService.updateSite(site, siteId);
		return new ResponseEntity<>(updatedSite, HttpStatus.OK);
	}

	@Override
	@GetMapping("/{id}")
	public Site getByIdSite(@PathVariable("id") Long id) {
		return siteService.getByIdSiteDetails(id);
	}

	@Override
	@GetMapping("/getAllSite")
	@CrossOrigin(origins = "")
	public List<Site> getAllSiteDetails() {
		return siteService.getAllSite();
	}

	@Override
	@GetMapping("/name/{siteName}")
	public Site getByNameSite(@PathVariable("siteName") String siteName) {
		return siteService.getByNameDetails(siteName);
	}
}
