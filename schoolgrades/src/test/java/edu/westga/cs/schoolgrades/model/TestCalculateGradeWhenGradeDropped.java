package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Testing for CalculateGrade
 * 
 * @author Lauramarie Laskey
 * @version 11/5/22
 *
 */
public class TestCalculateGradeWhenGradeDropped {

	/**
	 * Testing getValue with valid grade value with sum + dropped grade.
	 */
	@Test
	public void testValidCompositeGradeValueSumWithDecorator() {
		CompositeGrade testGrade = new CompositeGrade();
		CalculateGrade theStrategy = new Sum();
		theStrategy.setCalculationDecorator(new DropGrade());
		testGrade.setStrategy(theStrategy);
		testGrade.addGrade(new SimpleGrade(90));
		testGrade.addGrade(new SimpleGrade(65.2));
		testGrade.addGrade(new SimpleGrade(62));
		assertEquals(155.2, testGrade.getValue());
	}
	
	/**
	 * Testing getValue with valid grade value with average + dropped grade.
	 */
	@Test
	public void testValidCompositeGradeValueAvgWithDecorator() {
		CompositeGrade testGrade = new CompositeGrade();
		CalculateGrade theStrategy = new Average();
		theStrategy.setCalculationDecorator(new DropGrade());
		testGrade.setStrategy(theStrategy);
		testGrade.addGrade(new SimpleGrade(90));
		testGrade.addGrade(new SimpleGrade(65.2));
		testGrade.addGrade(new SimpleGrade(70.8));
		assertEquals(80.4, testGrade.getValue());
	}
	
	/**
	 * Testing getValue with valid grade value with average + dropped grade,
	 * where the value of the two lowest grades are the same.
	 */
	@Test
	public void testValidCompositeGradeValueSumWithDecoratorTwoLowestGrades() {
		CompositeGrade testGrade = new CompositeGrade();
		CalculateGrade theStrategy = new Sum();
		theStrategy.setCalculationDecorator(new DropGrade());
		testGrade.setStrategy(theStrategy);
		testGrade.addGrade(new SimpleGrade(90));
		testGrade.addGrade(new SimpleGrade(65.2));
		testGrade.addGrade(new SimpleGrade(65.2));
		testGrade.addGrade(new SimpleGrade(70.8));
		assertEquals(226, testGrade.getValue());
	}
	
	/**
	 * Testing getValue with valid grade value with average + dropped grade,
	 * where the value of the two lowest grades are the same.
	 */
	@Test
	public void testValidCompositeGradeValueAvgWithDecoratorTwoLowestGrades() {
		CompositeGrade testGrade = new CompositeGrade();
		CalculateGrade theStrategy = new Average();
		theStrategy.setCalculationDecorator(new DropGrade());
		testGrade.setStrategy(theStrategy);
		testGrade.addGrade(new SimpleGrade(90));
		testGrade.addGrade(new SimpleGrade(65.2));
		testGrade.addGrade(new SimpleGrade(65.2));
		testGrade.addGrade(new SimpleGrade(70.8));
		assertEquals(75.33, testGrade.getValue());
	}

}
