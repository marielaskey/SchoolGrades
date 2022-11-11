package edu.westga.cs.schoolgrades.model;

import java.util.Iterator;

/**
 * Class to calculate the sum of grades
 * 
 * @author Lauramarie Laskey
 * @version 11/5/22
 *
 */
public class Sum extends CalculateGrade {

	/**
	 * Constructor for sum.
	 * 
	 */
	public Sum() {
		
	}
	
	/**
	 * Method that calculates the value of the grade
	 * 
	 * @return sum	of the grades
	 * 
	 */
	@Override
	public double calculateValue() {
		double sum = super.calculateValue();
		Iterator<Grade> it = super.gradeCollection.iterator();
		while (it.hasNext()) {
	    	Grade aGrade = it.next();
	    	sum += aGrade.getValue();
	    }
		return sum;
	}

}
