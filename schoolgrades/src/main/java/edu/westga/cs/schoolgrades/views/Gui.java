package edu.westga.cs.schoolgrades.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

/**
 * Class for additional GUI configuration
 * 
 * @author Lauramarie
 * @version 11/19/22
 *
 */
public class Gui extends GuiWindowBuilderLayout {
	private GradeTableModel quizModel;
	private GradeTableModel homeworkModel;
	private GradeTableModel examModel;

	public Gui() {
		super();
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

}
