package com.qa.springvegetables.domain; // base class this is what the projects is all about 

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// *STEP 5 Create this class now on to a table 
@Entity // imports from Java - we are able to mark this class as a table - every table
		// in SQL needs o have an identifier using its ID
public class Vegetables {

	// within this class we have

	// *STEP 1 1 variables
	@Id // *STEP 7 MARK IT AS A PRIMARY KEY
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment the ID -
	// whenever a new record is inserted in the table - java/sql will automatically
	// keep track
	private Long id; // *STEP 6 user shouldn't be responsible for entering this value to prevent them
						// from over writing an existing record
	private String vegName;
	private String monthSown;
	private int timeToGrow;
	private String colour;
	private boolean inTheGreenhouse;
	private int howManyGrown;

	// Constructors
	// *STEP 2 a DEFAULT CONSTRUCTOR - same name as the class -Vegetables // no
	// parameters
	public Vegetables() {
	}

	// *STEP 3 create a constructor using the object(6 variables) of this class
	public Vegetables(String vegName, String monthSown, int timeToGrow, String colour, boolean inTheGreenhouse,
			int howManyGrown) {
		this.vegName = vegName;
		this.monthSown = monthSown;
		this.timeToGrow = timeToGrow;
		this.colour = colour;
		this.inTheGreenhouse = inTheGreenhouse;
		this.howManyGrown = howManyGrown;

	}

	public Vegetables(Long id, String vegName, String monthSown, int timeToGrow, String colour, boolean inTheGreenhouse,
			int howManyGrown) {
		super();
		this.id = id;
		this.vegName = vegName;
		this.monthSown = monthSown;
		this.timeToGrow = timeToGrow;
		this.colour = colour;
		this.inTheGreenhouse = inTheGreenhouse;
		this.howManyGrown = howManyGrown;
	}

	
	// METHODS step 4 to getters and setters so that the private variables can be
	// accessed from other classes
	public String getVegName() {
		return vegName;
	}

	public void setVegName(String vegName) {
		this.vegName = vegName;
	}

	public String getMonthSown() {
		return monthSown;
	}

	public void setMonthSown(String monthSown) {
		this.monthSown = monthSown;
	}

	public int getTimeToGrow() {
		return timeToGrow;
	}

	public void setTimeToGrow(int timeToGrow) {
		this.timeToGrow = timeToGrow;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public boolean isInTheGreenhouse() {
		return inTheGreenhouse;
	}

	public void setInTheGreenhouse(boolean inTheGreenhouse) {
		this.inTheGreenhouse = inTheGreenhouse;
	}

	public int getHowManyGrown() {
		return howManyGrown;
	}

	public void setHowManyGrown(int howManyGrown) {
		this.howManyGrown = howManyGrown;
	}

}
