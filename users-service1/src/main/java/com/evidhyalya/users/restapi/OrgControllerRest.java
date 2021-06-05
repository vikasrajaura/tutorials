package com.evidhyalya.users.restapi;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evidhyalya.users.exception.ResourceNotFoundException;
import com.evidhyalya.users.model.Org;
import com.evidhyalya.users.service.IOrgService;

@RestController
@RequestMapping("api/v1/orgs")
public class OrgControllerRest {

	@Autowired
	IOrgService orgService;

	@GetMapping("/{orgId}")
	public ResponseEntity<Org> getEntityById(@PathVariable("orgId") Long orgId)
			throws ResourceNotFoundException {
		Org org = orgService.findById(orgId)
				.orElseThrow(() -> new ResourceNotFoundException("Org not found for orgId:" + orgId));
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Org>(org, headers, HttpStatus.OK);
	}

	@GetMapping("")
	public ResponseEntity<List<Org>> getAllEntities() {
		return new ResponseEntity<List<Org>>(orgService.findAll(), HttpStatus.OK);
	}

	@PostMapping(value="", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Org> createEntity(@Valid @RequestBody Org o) {
		return new ResponseEntity<Org>(orgService.save(o), HttpStatus.CREATED);
	}

	@PutMapping("")
	public ResponseEntity<Org> updateEntity(@Valid @RequestBody Org o) throws ResourceNotFoundException {
		Org org = orgService.findById(o.getOrgId()).orElseThrow(
				() -> new ResourceNotFoundException("Org not found while updating for orgId:" + o.getOrgId()));
		
		org.setOrgName(o.getOrgName());
		org.setDetails(o.getDetails());
		orgService.save(org);
		return new ResponseEntity<Org>(org, HttpStatus.OK);
	}

	@DeleteMapping("/{orgId}")
	public ResponseEntity deleteEntityById(@PathVariable("orgId") Long orgId) throws ResourceNotFoundException {
		Org org = orgService.findById(orgId).orElseThrow(
				() -> new ResourceNotFoundException("Org not found while deleting for orgId:" + orgId));
		orgService.deleteById(orgId);
		return new ResponseEntity<Org>(org, HttpStatus.OK);
	}
	
	
	
}
