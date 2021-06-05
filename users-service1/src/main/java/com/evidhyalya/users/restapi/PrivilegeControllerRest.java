package com.evidhyalya.users.restapi;

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
import com.evidhyalya.users.model.Privilege;
import com.evidhyalya.users.service.IPrivilegeService;

@RestController
@RequestMapping("api/v1/privileges")
public class PrivilegeControllerRest {

	@Autowired
	IPrivilegeService privilegeService;

	@GetMapping("/{privId}")
	public ResponseEntity<Privilege> getEntityById(@PathVariable("privId") Long privId)
			throws ResourceNotFoundException {
		Privilege privilege = privilegeService.findById(privId)
				.orElseThrow(() -> new ResourceNotFoundException("Privilege not found for privId:" + privId));
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Privilege>(privilege, headers, HttpStatus.OK);
	}

	@GetMapping("")
	public ResponseEntity<List<Privilege>> getAllEntities() {
		return new ResponseEntity<List<Privilege>>(privilegeService.findAll(), HttpStatus.OK);
	}

	@PostMapping(value="", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Privilege> createEntity(@Valid @RequestBody Privilege priv) {
		return new ResponseEntity<Privilege>(privilegeService.save(priv), HttpStatus.CREATED);
	}

	@PutMapping("")
	public ResponseEntity<Privilege> updateEntity(@Valid @RequestBody Privilege priv) throws ResourceNotFoundException {
		Privilege privilege = privilegeService.findById(priv.getPrivId()).orElseThrow(
				() -> new ResourceNotFoundException("Privilege not found while updating for privId:" + priv.getPrivId()));
		
		privilege.setPrivName(priv.getPrivName());
		privilege.setDetails(priv.getDetails());
		privilegeService.save(privilege);
		return new ResponseEntity<Privilege>(privilege, HttpStatus.OK);
	}

	@DeleteMapping("/{privId}")
	public ResponseEntity deleteEntityById(@PathVariable("privId") Long privId) throws ResourceNotFoundException {
		Privilege privilege = privilegeService.findById(privId).orElseThrow(
				() -> new ResourceNotFoundException("Privilege not found while deleting for privId:" + privId));
		privilegeService.deleteById(privId);
		return new ResponseEntity<Privilege>(privilege, HttpStatus.OK);
	}
	
	
	
}
