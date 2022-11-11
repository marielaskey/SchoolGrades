package edu.westga.cs.schoolgrades.model;

import java.util.Iterator;

/**
 * Class to calculate the average of grades
 * 
 * @author Lauramarie Laskey
 * @version 11/5/22
 *
 */
public class Average extends CalculateGrade {

	/**
	 * Constructor for average.
	 * 
	 */
	public Average() {

	}
	
	/**
	 * Method that calculates the value of the grade
	 * 
	 * @return 	average of the grades
	 * 
	 */
	@Override
	public double calculateValue() {
		double sum = super.calculateValue();
		Iterator<Grade> it = gradeCollection.iterator();
		int size = gradeCollection.size();
	    while (it.hasNext()) {
	    	Grade aGrade = it.next();
	    	sum += aGrade.getValue();
	    }
	    return Math.round((sum / size) * 100.0) / 100.0;
	}

}
