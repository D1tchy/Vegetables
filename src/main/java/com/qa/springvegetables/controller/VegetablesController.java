package com.qa.springvegetables.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springvegetables.domain.Vegetables;
import com.qa.springvegetables.service.VegetablesService;

// * STEP8 This controller is responsible for handling requests and sending meaning full responses -@RestController 
@RestController // handles requests
@RequestMapping("/vegetable") // *STEP 9 give my mapping a prefix -any request will go to the local host
								// http://localhost:8080/vegetable/...value...
// @RequestMapping the above will always be the base URL because we have supplied a @Requestmapping at the start of the controller 
public class VegetablesController {

	// *STEP 10 user now needs to create a CRUD Application
	// @GetMapping - Fetching data from a database
	// @PostMapping : Send data to a database
	// @DeleteMapping : Remove data from database
	// @PutMapping : Replace an existing record
	// @PatchMapping when we want to partially update a db
//@RequestBody : used to get information from the user
	// @PathVariable :template holder for a value we get from the user

	// Dependency cdi - controller depends on service
	private VegetablesService service;

	@Autowired
	public VegetablesController(VegetablesService service) {
		this.service = service;
	}

	@GetMapping("/test") // aim of controller is to match a location URL to a specific method
	public String test() { // when the user is at this location it will execute this test method
		return "This is a vege test"; // its will return this string
	}

// CREATE
	@PostMapping("/create") // What data do you want to return in response
	public ResponseEntity<Vegetables> create(@RequestBody Vegetables vg) {
		// now put in some logic - once the logic has executed we will need to return -
		// not put in the logic here as it belongs in the service layer
		// new response
		return new ResponseEntity<Vegetables>(this.service.create(vg), HttpStatus.CREATED); // always first is body
																							// information sending
		// back // back
		// then the status code
	}

	// READ
	@GetMapping("/read")
	public ResponseEntity<List<Vegetables>> read() {
		return new ResponseEntity<List<Vegetables>>(this.service.read(), HttpStatus.OK);

	}

	// UPDATE
	@PutMapping("/replace/{id}") // not sure what the ID is - this is a template holder - it will be updated with
									// a value
	public ResponseEntity<Vegetables> update(@PathVariable Long id, @RequestBody Vegetables vg) {
		// //@RequestBody this will like the template holder with a value should be
		// identical to the name is {}
		// logic
		return new ResponseEntity<Vegetables>(this.service.update(id, vg), HttpStatus.ACCEPTED);
	}
	
	
	
	// DELETE
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id) {
		// logic
		return new ResponseEntity<Boolean>(this.service.delete(id), HttpStatus.NO_CONTENT);

	}
}
