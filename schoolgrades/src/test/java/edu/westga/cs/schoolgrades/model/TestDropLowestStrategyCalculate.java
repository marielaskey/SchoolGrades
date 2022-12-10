package edu.westga.cs.schoolgrades.model;



import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestDropLowestStrategyCalculate {

	private DropLowestStrategy dropLowestStrategy;
	private GradeCalculationStrategy childStrategy;
	
	private static final double DELTA = 0.001;
	private Grade grade0;
	private Grade grade1;
	private Grade grade2;
	
	private List<Grade> grades;
	
	@BeforeEach
	public void setUp() throws Exception {
		grade0 = mock(Grade.class);
		when(grade0.getValue()).thenReturn(10.0);
		grade1 = mock(Grade.class);
		when(grade1.getValue()).thenReturn(20.0);
		grade2 = mock(Grade.class);
		when(grade2.getValue()).thenReturn(30.0);
		
		grades = new ArrayList<Grade>();
		
		childStrategy = mock(SumOfGradesStrategy.class);
		dropLowestStrategy = new DropLowestStrategy(childStrategy);
	}

	@Test
	public void shouldNotAllowNullGradesList() {
		assertThrows(IllegalArgumentException.class, () ->{ 
			dropLowestStrategy.calculate(null);
		});
	}

	@Test
	public void shouldNotDropLowestIfGradesListIsEmpty() {
		assertEquals(0, dropLowestStrategy.calculate(grades), DELTA);
	}
	
	public void shouldNotDropLowestIfGradesListHasOneElement() {
		grades.add(grade0);
		verify(childStrategy).calculate(eq(grades));
	}
	
	@Test
	public void canDropWhenLowestIsFirst() {
		grades.add(grade0);
		grades.add(grade1);
		grades.add(grade2);
		ArrayList<Grade> droppedList = new ArrayList<Grade>(grades);
		droppedList.remove(grade0);
		dropLowestStrategy.calculate(grades);
		verify(childStrategy).calculate(eq(droppedList));
	}
	
	
	@Test
	public void canDropWhenLowestIsLast() {
		grades.add(grade1);
		grades.add(grade2);
		grades.add(grade0);
		ArrayList<Grade> droppedList = new ArrayList<Grade>(grades);
		droppedList.remove(grade0);
		dropLowestStrategy.calculate(grades);
		verify(childStrategy).calculate(eq(droppedList));
	}
	
	@Test
	public void canDropWhenLowestIsInMiddle() {
		grades.add(grade1);
		grades.add(grade0);
		grades.add(grade2);
		ArrayList<Grade> droppedList = new ArrayList<Grade>(grades);
		droppedList.remove(grade0);
		dropLowestStrategy.calculate(grades);
		verify(childStrategy).calculate(eq(droppedList));
	}
	
	@Test
	public void dropsOnlyOneIfThereAreMultipleLowestGrades() {
		grades.add(grade1);
		grades.add(grade0);
		grades.add(grade2);
		grades.add(grade0);
		ArrayList<Grade> droppedList = new ArrayList<Grade>(grades);
		droppedList.remove(grade0);
		dropLowestStrategy.calculate(grades);
		verify(childStrategy).calculate(eq(droppedList));
	}
}
