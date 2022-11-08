package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;

/**
 * Class for a composite grade
 * 
 * @author Lauramarie Laskey
 * @version 11/5/22
 *
 */
public class CompositeGrade implements Grade {

	private double grade;
	private ArrayList<Grade> gradeCollection;
	private CalculateGrade calculationStrategy;

	/**
	 * Constructor for simple grade.
	 * 
	 */
	public CompositeGrade() {
		this.gradeCollection = new ArrayList<Grade>();
	}

	/**
	 * Getter method for the grade.
	 * 
	 */
	@Override
	public double getValue() {
		this.grade = this.calculationStrategy.calculateValue(this.gradeCollection);
		return this.grade;
	}
	
	/**
	 * Method to add grade to the collection.
	 * 
	 * @param aGrade	a grade added to the collection
	 * 
	 */
	public void addGrade(Grade aGrade) {
		this.gradeCollection.add(aGrade);
	}
	
	/**
	 * Method that sets the strategy used to calculate the grade.
	 * 
	 * @param theStrategy	the strategy set to calculate the grade
	 * 
	 */
	public void setStrategy(CalculateGrade theStrategy) {
		this.calculationStrategy = theStrategy;
	}

}
