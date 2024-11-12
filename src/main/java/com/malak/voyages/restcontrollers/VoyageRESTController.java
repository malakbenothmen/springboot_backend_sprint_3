package com.malak.voyages.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.malak.voyages.entities.Voyage;
import com.malak.voyages.service.VoyageService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class VoyageRESTController {
	
	@Autowired
	VoyageService  voyageService ;
	
	@RequestMapping(path="all", method = RequestMethod.GET)
	public List<Voyage> getAllVoyages() {
	return voyageService.getAllVoyages();
	}
	
	
	@RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
	public Voyage getVoyageById(@PathVariable("id") Long id) {
	return voyageService.getVoyage(id);
	 }

	@RequestMapping(value="/addvoy",method = RequestMethod.POST)
	//@PostMapping("/addvoy")
	@PreAuthorize("hasAuthority('ADMIN')")
	public Voyage createVoyage(@RequestBody Voyage voyage) {
	return voyageService.saveVoyage(voyage);
	}
	
	@RequestMapping(value="/updatevoy",method = RequestMethod.PUT)
	public Voyage updateVoyage(@RequestBody Voyage voyage) {
	return voyageService.updateVoyage(voyage);
	}
	
	@RequestMapping(value="/delvoy/{id}",method = RequestMethod.DELETE)
	public void deleteVoyage(@PathVariable("id") Long id)
	{
		voyageService.deleteVoyageById(id);
	}
	
	@RequestMapping(value="/voystype/{idType}",method = RequestMethod.GET)
	public List<Voyage> getProduitsByCatId(@PathVariable("idType") Long idType) {
	return voyageService.findByTypeIdType(idType);
	}
	
	@RequestMapping(value="/voysByDestination/{destination}",method = RequestMethod.GET)
	public List<Voyage> findByDestinationContains(@PathVariable("destination") String destination) {
	return voyageService.findByDestinationContains(destination);
	}


}
