package edu.westga.cs.schoolgrades.model;

/**
 * Class for a weighted grade
 * 
 * @author Lauramarie Laskey
 * @version 11/5/22
 *
 */
public class WeightDecorator {
	
	private double weight;
	
	/**
	 * Constructor for the weight decorator.
	 * 
	 * @param weightValue	the weight value to be applied
	 * 
	 */
	public WeightDecorator(double weightValue) throws IllegalArgumentException {
		this.weight = weightValue;
		if (this.weight < 0 || this.weight > 1.0) {
			throw new IllegalArgumentException("Invalid weight value");
		}
	}
	
	/**
	 * Method that applies the weight value to the grade value.
	 * 
	 * @param theGrade	the grade value
	 * @return the value of the weighted grade
	 * 
	 */
	public double applyWeight(double theGrade) {
		return this.weight * theGrade;
	}

}
