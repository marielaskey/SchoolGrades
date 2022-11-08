package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Testing for CompositeGrade
 * 
 * @author Lauramarie Laskey
 * @version 11/5/22
 *
 */
public class TestCompositeGradeGetValue {

	/**
	 * Testing getValue with valid grade value.
	 */
	@Test
	public void testValidCompositeGradeValue() {
		CompositeGrade testGrade = new CompositeGrade();
		testGrade.setStrategy(new Sum());
		testGrade.addGrade(new SimpleGrade(90));
		testGrade.addGrade(new SimpleGrade(65.2));
		assertEquals(155.2, testGrade.getValue());
	}

}
