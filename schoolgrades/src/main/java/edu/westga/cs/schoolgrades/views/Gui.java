package edu.westga.cs.schoolgrades.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private DefaultTableModel quizModel;
	private DefaultTableModel homeworkModel;
	private DefaultTableModel examModel;

	public Gui() {
		super();
		this.quizModel = new DefaultTableModel();
		this.quizModel.addColumn("");
		this.tableQuiz.setModel(this.quizModel);
		this.homeworkModel = new DefaultTableModel();
		this.homeworkModel.addColumn("");
		this.tableHomework.setModel(this.homeworkModel);
		this.examModel = new DefaultTableModel();
		this.examModel.addColumn("");
		this.tableExam.setModel(this.examModel);
		super.btnQuiz.addActionListener(new AssignmentListener());
		super.btnHomework.addActionListener(new AssignmentListener());
		super.btnExam.addActionListener(new AssignmentListener());
	}

	private class AssignmentListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			DefaultTableModel modelChanged = null;
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
