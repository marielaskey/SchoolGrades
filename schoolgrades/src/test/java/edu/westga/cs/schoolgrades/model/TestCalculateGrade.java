package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Testing for CompositeGrade
 * 
 * @author Lauramarie Laskey
 * @version 11/5/22
 *
 */
public class TestCalculateGrade {

	/**
	 * Testing getValue with valid grade value with sum.
	 */
	@Test
	public void testValidCompositeGradeValueSum() {
		CompositeGrade testGrade = new CompositeGrade();
		testGrade.setStrategy(new Sum());
		testGrade.addGrade(new SimpleGrade(90));
		testGrade.addGrade(new SimpleGrade(65.2));
		assertEquals(155.2, testGrade.getValue());
	}
	
	/**
	 * Testing getValue with valid grade value with average.
	 */
	@Test
	public void testValidCompositeGradeValueAvg() {
		CompositeGrade testGrade = new CompositeGrade();
		testGrade.setStrategy(new Average());
		testGrade.addGrade(new SimpleGrade(90));
		testGrade.addGrade(new SimpleGrade(65.2));
		assertEquals(77.6, testGrade.getValue());
	}

}
