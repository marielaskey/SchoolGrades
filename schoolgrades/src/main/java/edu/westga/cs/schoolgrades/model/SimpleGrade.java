package edu.westga.cs.schoolgrades.model;

/**
 * Class for a simple grade
 * 
 * @author Lauramarie Laskey
 * @version 11/5/22
 *
 */
public class SimpleGrade implements Grade {
	
	private double grade;

	/**
	 * Constructor for simple grade.
	 * 
	 * @param grade	the numerical grade
	 * 
	 */
	public SimpleGrade(double grade) throws IllegalArgumentException {
		this.grade = grade;
		if (this.grade < 0) {
			throw new IllegalArgumentException("Invalid grade value");
		}
	}

	/**
	 * Getter method for the grade.
	 * 
	 */
	@Override
	public double getValue() {
		return this.grade;
	}

}
