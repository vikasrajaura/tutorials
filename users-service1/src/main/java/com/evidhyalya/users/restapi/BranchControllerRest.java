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
import com.evidhyalya.users.model.Branch;
import com.evidhyalya.users.service.IBranchService;

@RestController
@RequestMapping("api/v1/branchs")
public class BranchControllerRest {

	@Autowired
	IBranchService branchService;

	@GetMapping("/{branchId}")
	public ResponseEntity<Branch> getEntityById(@PathVariable("branchId") Long branchId)
			throws ResourceNotFoundException {
		Branch branch = branchService.findById(branchId)
				.orElseThrow(() -> new ResourceNotFoundException("Branch not found for branchId:" + branchId));
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Branch>(branch, headers, HttpStatus.OK);
	}

	@GetMapping("")
	public ResponseEntity<List<Branch>> getAllEntities() {
		return new ResponseEntity<List<Branch>>(branchService.findAll(), HttpStatus.OK);
	}

	@PostMapping(value="", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Branch> createEntity(@Valid @RequestBody Branch br) {
		return new ResponseEntity<Branch>(branchService.save(br), HttpStatus.CREATED);
	}

	@PutMapping("")
	public ResponseEntity<Branch> updateEntity(@Valid @RequestBody Branch br) throws ResourceNotFoundException {
		Branch branch = branchService.findById(br.getBranchId()).orElseThrow(
				() -> new ResourceNotFoundException("Branch not found while updating for branchId:" + br.getBranchId()));
		
		branch.setBranchName(br.getBranchName());
		branch.setDetails(br.getDetails());
		if(br.getOrg()!=null) {
			branch.setOrg(br.getOrg());
		}
		branch.setType(br.getType());
		branch.setAddress(br.getAddress());
		branchService.save(branch);
		return new ResponseEntity<Branch>(branch, HttpStatus.OK);
	}

	@DeleteMapping("/{branchId}")
	public ResponseEntity deleteEntityById(@PathVariable("branchId") Long branchId) throws ResourceNotFoundException {
		Branch branch = branchService.findById(branchId).orElseThrow(
				() -> new ResourceNotFoundException("Branch not found while deleting for branchId:" + branchId));
		branchService.deleteById(branchId);
		return new ResponseEntity<Branch>(branch, HttpStatus.OK);
	}
	
	
	
}
