package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;
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
	 */
	public Sum() {

	}
	
	/**
	 * Method that calculates the value of the grade
	 * 
	 * @return 		sets the initial grade value to 0
	 * @param gradeCollection	the collection of grades
	 * 
	 */
	public double calculateValue(ArrayList<Grade> gradeCollection) {
		Iterator<Grade> it = gradeCollection.iterator();
		double sum = 0;
	    while (it.hasNext()) {
	    	Grade aGrade = it.next();
	    	sum += aGrade.getValue();
	    }
		return sum;
	}

}
