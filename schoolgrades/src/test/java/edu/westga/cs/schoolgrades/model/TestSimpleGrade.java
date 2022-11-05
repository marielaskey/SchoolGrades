package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Testing for SimpleGrade
 * 
 * @author Lauramarie Laskey
 * @version 11/5/22
 *
 */
public class TestSimpleGrade {

	/**
	 * Testing getValue with valid grade value.
	 */
	@Test
	public void testValidSimpleGradeValue() {
		SimpleGrade testGrade = new SimpleGrade(92.44);
		assertEquals(92.44, testGrade.getValue());
	}
	
	/**
	 * Testing getValue with negative grade value.
	 */
	@Test
	public void testNegativeSimpleGradeValue() {
		SimpleGrade testGrade;
		try {
			testGrade = new SimpleGrade(-92.44);
			assertTrue(false);
		} catch (Exception ex) {
			assertTrue(true);
		}
	}

}
