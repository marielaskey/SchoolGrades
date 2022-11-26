package edu.westga.cs.schoolgrades.controllers;

import edu.westga.cs.schoolgrades.model.Average;
import edu.westga.cs.schoolgrades.model.CalculateGrade;
import edu.westga.cs.schoolgrades.model.CompositeGrade;
import edu.westga.cs.schoolgrades.model.DropGrade;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.Sum;
import edu.westga.cs.schoolgrades.model.WeightDecorator;
import edu.westga.cs.schoolgrades.model.WeightedGrade;
import edu.westga.cs.schoolgrades.views.Gui;

/**
 * Class for GUI behavior
 * 
 * @author Lauramarie
 * @version 11/19/22
 *
 */

public class GuiController {

	private Gui gui;
	private CompositeGrade quizGrade;
	private CompositeGrade homeworkGrade;
	private CompositeGrade examGrade;

	/**
	 * Constructor for GuiController
	 */
	public GuiController(Gui theGui) {
		this.gui = theGui;
	}

	/**
	 * Method to refresh grade subtotals/totals.
	 * 
	 */
	public void refreshTotals() {
		this.quizGrade = buildGrades(this.gui.getQuizModel().getGrades());
		this.quizGrade.setStrategy(new Average());
		this.homeworkGrade = buildGrades(this.gui.getHomeworkModel().getGrades());
		CalculateGrade theStrategy = new Average();
		if (this.gui.shouldDropHomework()) {
			theStrategy.setCalculationDecorator(new DropGrade());
		}
		this.homeworkGrade.setStrategy(theStrategy);
		this.examGrade = buildGrades(this.gui.getExamModel().getGrades());
		this.examGrade.setStrategy(new Average());
				
		WeightedGrade weightedQuizGrade = new WeightedGrade(this.quizGrade.getValue(),
				new WeightDecorator(this.gui.getQuizWeight()));
		this.gui.subQuiz(weightedQuizGrade.getValue());

		WeightedGrade weightedHomeworkGrade = new WeightedGrade(this.homeworkGrade.getValue(),
				new WeightDecorator(this.gui.getHomeworkWeight()));
		this.gui.subHomework(weightedHomeworkGrade.getValue());

		WeightedGrade weightedExamGrade = new WeightedGrade(this.examGrade.getValue(),
				new WeightDecorator(this.gui.getExamWeight()));
		this.gui.subExam(weightedExamGrade.getValue());
		
		CompositeGrade finalGrade = new CompositeGrade();
		finalGrade.addGrade(new SimpleGrade(weightedQuizGrade.getValue()));
		finalGrade.addGrade(new SimpleGrade(weightedHomeworkGrade.getValue()));
		finalGrade.addGrade(new SimpleGrade(weightedExamGrade.getValue()));
		finalGrade.setStrategy(new Sum());
		this.gui.setFinalGrade(finalGrade.getValue());

		this.gui.repaint();
	}

	/**
	 * Helper method to build Grades
	 */
	private CompositeGrade buildGrades(Double[] grades) {
		CompositeGrade aGrade = new CompositeGrade();
		for (Double grade : grades) {
			aGrade.addGrade(new SimpleGrade(grade));
		}
		return aGrade;
	}

}
