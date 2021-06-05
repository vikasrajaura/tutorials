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
import com.evidhyalya.users.model.UserDetails;
import com.evidhyalya.users.service.IUserService;

@RestController
@RequestMapping("api/v1/users")
public class UserDetailsControllerRest {

	@Autowired
	IUserService userService;

	@GetMapping("/{userId}")
	public ResponseEntity<UserDetails> getEntityById(@PathVariable("userId") Long userId)
			throws ResourceNotFoundException {
		UserDetails user = userService.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for userId:" + userId));
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<UserDetails>(user, headers, HttpStatus.OK);
	}

	@GetMapping("")
	public ResponseEntity<List<UserDetails>> getAllEntities() {
		return new ResponseEntity<List<UserDetails>>(userService.findAll(), HttpStatus.OK);
	}

	@PostMapping(value="", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDetails> createEntity(@Valid @RequestBody UserDetails user) {
		return new ResponseEntity<UserDetails>(userService.save(user), HttpStatus.CREATED);
	}

	@PutMapping("")
	public ResponseEntity<UserDetails> updateEntity(@Valid @RequestBody UserDetails usr) throws ResourceNotFoundException {
		UserDetails user = userService.findById(usr.getUserId()).orElseThrow(
				() -> new ResourceNotFoundException("User not found while updating for userId:" + usr.getUserId()));
		userService.save(user);
		return new ResponseEntity<UserDetails>(user, HttpStatus.OK);
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity deleteEntityById(@PathVariable("userId") Long userId) throws ResourceNotFoundException {
		UserDetails user = userService.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("UserDetails not found while deleting for userId:" + userId));
		userService.deleteById(userId);
		return new ResponseEntity<UserDetails>(user, HttpStatus.OK);
	}
	
}
