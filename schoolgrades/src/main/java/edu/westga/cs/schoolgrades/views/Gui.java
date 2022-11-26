package edu.westga.cs.schoolgrades.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import edu.westga.cs.schoolgrades.controllers.GuiController;

/**
 * Class for additional GUI configuration
 * 
 * @author Lauramarie
 * @version 11/19/22
 *
 */
public class Gui extends GuiWindowBuilderLayout {

	private static final long serialVersionUID = 1652085772697458042L;
	private GuiController guiController;
	private GradeTableModel quizModel;
	private GradeTableModel homeworkModel;
	private GradeTableModel examModel;

	/**
	 * Constructor for Gui
	 * 
	 */
	public Gui() {
		super();
		this.guiController = new GuiController(this);
		this.quizModel = new GradeTableModel();
		this.quizModel.addColumn("");
		this.tableQuiz.setModel(this.quizModel);
		this.tableQuiz.setDefaultEditor(Object.class, new GradeTableEditor());
		this.homeworkModel = new GradeTableModel();
		this.homeworkModel.addColumn("");
		this.tableHomework.setModel(this.homeworkModel);
		this.tableHomework.setDefaultEditor(Object.class, new GradeTableEditor());
		this.examModel = new GradeTableModel();
		this.examModel.addColumn("");
		this.tableExam.setModel(this.examModel);
		this.tableExam.setDefaultEditor(Object.class, new GradeTableEditor());
		super.btnQuiz.addActionListener(new AssignmentListener());
		super.btnHomework.addActionListener(new AssignmentListener());
		super.btnExam.addActionListener(new AssignmentListener());
		this.quizModel.addTableModelListener(new TableListener());
		this.homeworkModel.addTableModelListener(new TableListener());
		this.examModel.addTableModelListener(new TableListener());
		this.spinnerQuiz.addChangeListener(new SpinnerListener());
		this.spinnerHomework.addChangeListener(new SpinnerListener());
		this.spinnerExam.addChangeListener(new SpinnerListener());
		this.chckbxNewCheckBox.addActionListener(new CheckboxListener());
	}

	/**
	 * Getter method for the quizModel.
	 * 
	 * @return the quizModel
	 */
	public GradeTableModel getQuizModel() {
		return this.quizModel;
	}

	/**
	 * Getter method for the homeworkModel.
	 * 
	 * @return the homeworkModel
	 */
	public GradeTableModel getHomeworkModel() {
		return this.homeworkModel;
	}

	/**
	 * Getter method for the examModel.
	 * 
	 * @return the examModel
	 */
	public GradeTableModel getExamModel() {
		return this.examModel;
	}

	/**
	 * Method to set quiz grade subtotal.
	 * 
	 * @param subtotal the subtotal of the grade values
	 *
	 */
	public void subQuiz(Double subtotal) {
		PlainDocument quizDoc = new PlainDocument();
		Double roundedSubtotal = Math.round(subtotal * 100.0) / 100.0;
		try {
			quizDoc.insertString(0, roundedSubtotal.toString(), null);
		} catch (BadLocationException ex) {
			System.out.println(ex.getMessage());
		}
		this.textFieldQuiz.setDocument(quizDoc);
	}

	/**
	 * Method to set homework grade subtotal.
	 *
	 * @param subtotal the subtotal of the grade values
	 *
	 */
	public void subHomework(Double subtotal) {
		PlainDocument homeworkDoc = new PlainDocument();
		Double roundedSubtotal = Math.round(subtotal * 100.0) / 100.0;
		try {
			homeworkDoc.insertString(0, roundedSubtotal.toString(), null);
		} catch (BadLocationException ex) {
			System.out.println(ex.getMessage());
		}
		this.textFieldHomework.setDocument(homeworkDoc);
	}

	/**
	 * Method to set exam grade subtotal.
	 * 
	 * @param subtotal the subtotal of the grade values
	 *
	 */
	public void subExam(Double subtotal) {
		PlainDocument examDoc = new PlainDocument();
		Double roundedSubtotal = Math.round(subtotal * 100.0) / 100.0;
		try {
			examDoc.insertString(0, roundedSubtotal.toString(), null);
		} catch (BadLocationException ex) {
			System.out.println(ex.getMessage());
		}
		this.textFieldExam.setDocument(examDoc);

	}

	/**
	 * Getter method for quiz weight applied.
	 * 
	 * @return quizWeight the weight for the quiz subtotal
	 *
	 */
	public Double getQuizWeight() {
		return (Double) this.spinnerQuiz.getModel().getValue();
	}

	/**
	 * Getter method for homework weight applied.
	 * 
	 * @return homeworkWeight the weight for the homework subtotal
	 *
	 */
	public Double getHomeworkWeight() {
		return (Double) this.spinnerHomework.getModel().getValue();
	}

	/**
	 * Getter method for exam weight applied.
	 * 
	 * @return examWeight the weight for the exam subtotal
	 *
	 */
	public Double getExamWeight() {
		return (Double) this.spinnerExam.getModel().getValue();
	}

	/**
	 * Method to set final grade total.
	 * 
	 * @param total grade value
	 *
	 */
	public void setFinalGrade(Double total) {
		PlainDocument finalDoc = new PlainDocument();
		Double roundedTotal = Math.round(total * 100.0) / 100.0;
		try {
			finalDoc.insertString(0, roundedTotal.toString(), null);
		} catch (BadLocationException ex) {
			System.out.println(ex.getMessage());
		}
		this.textField.setDocument(finalDoc);

	}

	/**
	 * Method that determines if the lowest homework grade should be dropped.
	 * 
	 * @return whether checkbox is selected
	 *
	 */
	public boolean shouldDropHomework() {
		return this.chckbxNewCheckBox.getModel().isSelected();
	}

	private class AssignmentListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			GradeTableModel modelChanged = null;
			if (event.getSource() == Gui.super.btnQuiz) {
				modelChanged = Gui.this.quizModel;
			} else if (event.getSource() == Gui.super.btnHomework) {
				modelChanged = Gui.this.homeworkModel;
			} else {
				modelChanged = Gui.this.examModel;
			}
			modelChanged.addRow(new Object[] { new Double(0.0) });
			Gui.this.repaint();
		}
	}

	private class TableListener implements TableModelListener {

		@Override
		public void tableChanged(TableModelEvent event) {
			if (event.getType() == TableModelEvent.UPDATE) {
				Gui.this.guiController.refreshTotals();
			}
		}

	}

	private class SpinnerListener implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent event) {
			Gui.this.guiController.refreshTotals();
		}

	}

	private class CheckboxListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == Gui.super.chckbxNewCheckBox) {
				Gui.this.guiController.refreshTotals();
			}

		}

	}

}
