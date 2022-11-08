package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;
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
	 */
	public Average() {

	}
	
	/**
	 * Method that calculates the value of the grade
	 * 
	 * @return 	average of the grades
	 * @param gradeCollection	the collection of grades
	 * 
	 */
	@Override
	public double calculateValue(ArrayList<Grade> gradeCollection) {
		Iterator<Grade> it = gradeCollection.iterator();
		double sum = 0;
		int size = gradeCollection.size();
	    while (it.hasNext()) {
	    	Grade aGrade = it.next();
	    	sum += aGrade.getValue();
	    }
	    return sum / size;
	}

}
