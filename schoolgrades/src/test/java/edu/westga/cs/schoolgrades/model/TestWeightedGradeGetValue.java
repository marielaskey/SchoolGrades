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
public class TestWeightedGradeGetValue {

	/**
	 * Testing getValue for a grade with the weight decorator applied.
	 */
	@Test
	public void testWeightedGradeWithValidDecorator() {
		WeightedGrade testGrade = new WeightedGrade(80, new WeightDecorator(0.8));
		assertEquals(64, testGrade.getValue());
	}

	/**
	 * Testing getValue for a grade without weight decorator applied.
	 */
	@Test
	public void testWeightedGradeWithNullDecorator() {
		WeightedGrade testGrade = new WeightedGrade(80, null);
		assertEquals(80, testGrade.getValue());
	}

	/**
	 * Testing getValue with negative grade value.
	 */
	@Test
	public void testNegativeWeightedGradeValue() {
		WeightedGrade testGrade;
		try {
			testGrade = new WeightedGrade(-20.1, null);
			assertTrue(false);
		} catch (Exception ex) {
			assertTrue(true);
		}
	}

	/**
	 * Testing getValue with invalid weight decorator.
	 */
	@Test
	public void testWeightedGradeWithInvalidDecorator() {
		WeightedGrade testGrade;
		try {
			testGrade = new WeightedGrade(20, new WeightDecorator(3.3));
			assertTrue(false);
		} catch (Exception ex) {
			assertTrue(true);
		}
	}

}
