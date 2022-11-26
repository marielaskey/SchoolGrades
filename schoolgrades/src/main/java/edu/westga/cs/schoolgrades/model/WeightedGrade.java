package edu.westga.cs.schoolgrades.model;

/**
 * Class for a weighted grade
 * 
 * @author Lauramarie Laskey
 * @version 11/5/22
 *
 */
public class WeightedGrade implements Grade {
	
	private double grade;
	private WeightDecorator weight;

	/**
	 * Constructor for WeightedGrade
	 * 
	 * @param grade		the grade value
	 * @param weight	the weight value
	 * 
	 */
	public WeightedGrade(double grade, WeightDecorator weight) throws IllegalArgumentException {
		this.grade = grade;
		this.weight = weight;
		if (this.grade < 0) {
			throw new IllegalArgumentException("Invalid grade value");
		}
		
	}
	
	/**
	 * Getter method for the weighted grade.
	 * 
	 */
	@Override
	public double getValue() {
		double theGrade = this.grade;
		if (this.weight != null) {
			theGrade = this.weight.applyWeight(this.grade);
		}
		return theGrade;
	}

}
