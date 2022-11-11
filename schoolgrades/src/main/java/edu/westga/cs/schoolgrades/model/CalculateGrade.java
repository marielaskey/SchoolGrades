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
	
	protected ArrayList<Grade> gradeCollection;
	private DropGrade calculationDecorator;

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
	 * 
	 */
	public double calculateValue() {
		if (this.calculationDecorator != null) {
			this.gradeCollection = this.calculationDecorator.dropLowestGrade(this.gradeCollection);
		}
		return 0;
	}

	/**
	 * Setter method for the gradeCollection
	 * @param gradeCollection the collection of grades
	 */
	public void setGradeCollection(ArrayList<Grade> gradeCollection) {
		this.gradeCollection = gradeCollection;
	}

	/**
	 * Setter for the calculationDecorator for a dropped grade
	 * 
	 * @param calculationDecorator the calculationDecorator for the dropped grade
	 */
	public void setCalculationDecorator(DropGrade calculationDecorator) {
		this.calculationDecorator = calculationDecorator;
	}

}
