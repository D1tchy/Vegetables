package com.qa.springvegetables.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.springvegetables.domain.Vegetables;
import com.qa.springvegetables.repo.VegetablesRepo;

@Service // handles all the business logic
public class VegetablesService {

	// Dependency repo is now a dependancy
	private VegetablesRepo repo; // Spring needs to bring down the vegetablesRepo when it initialises the
									// VegetableService

	public VegetablesService(VegetablesRepo repo) { // constructor assigned repo to this class
		this.repo = repo;

	}

	// create the method for the interaction between controller and repo

	// Create - when we create we expect an object

	public Vegetables create(Vegetables vg) {
		return this.repo.saveAndFlush(vg); // save the entity we are working with Vegetables and flush the changes
											// instantly back to the Db and user

	}

	// Read a list of all the vegetable objects
	public List<Vegetables> read() {
		return this.repo.findAll();

	}
	// Update - when we are updating a method there is a likely hood
	// the user will update something that doesnt exist
	// so we use an optional.

	public Vegetables update(Long id, Vegetables newvg) { // get existing object that lives in the data base
		Vegetables existing = this.repo.getById(id); // going to get the existing record in the DB
		existing.setVegName(newvg.getVegName()); // get the value from the existing object and update wit new one
		existing.setMonthSown(newvg.getMonthSown());
		existing.setTimeToGrow(newvg.getTimeToGrow());
		existing.setColour(newvg.getColour());
		existing.setInTheGreenhouse(newvg.isInTheGreenhouse());
		existing.setHowManyGrown(newvg.getHowManyGrown());

		Vegetables updated = this.repo.save(existing); // save it back to overwrite the original
		return updated; // return it
	}

	// DELETE
	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return this.repo.existsById(id);
	}

}
