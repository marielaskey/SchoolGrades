package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class for dropping a grade.
 * 
 * @author Lauramarie Laskey
 * @version 11/5/22
 *
 */
public class DropGrade {

	/**
	 * Constructor for DropGrade
	 */
	public DropGrade() {

	}

	/**
	 * Method to drop lowest grade.
	 * 
	 * @param gradeCollection the collection of grades
	 * @return gradeCollection the collection without the lowest grade
	 * 
	 */
	public ArrayList<Grade> dropLowestGrade(ArrayList<Grade> gradeCollection) {
		Iterator<Grade> it = gradeCollection.iterator();
		double lowGrade = 100.0;
		Grade dropGrade = null;
		while (it.hasNext()) {
			Grade aGrade = it.next();
			if (aGrade.getValue() < lowGrade) {
				lowGrade = aGrade.getValue();
				dropGrade = aGrade;
			}
		}
		gradeCollection.remove(dropGrade);
		return gradeCollection;
	}

}
