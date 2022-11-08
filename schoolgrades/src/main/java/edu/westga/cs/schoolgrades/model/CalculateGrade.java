package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * Abstract class for a calculating grades
 * 
 * @author Lauramarie Laskey
 * @version 11/5/22
 *
 */

public abstract class CalculateGrade {

	/**
	 * Constructor for CalculateGrade
	 * 
	 */
	public CalculateGrade() {

	}
	
	/**
	 * Method that calculates the value of the grade
	 * 
	 * @return 0		sets the initial grade value to 0
	 * @param gradeCollection	the collection of grades
	 * 
	 */
	public double calculateValue(ArrayList<Grade> gradeCollection) {
		return 0;
	}

}
