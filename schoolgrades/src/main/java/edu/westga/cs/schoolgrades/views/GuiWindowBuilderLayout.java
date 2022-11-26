package edu.westga.cs.schoolgrades.views;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JCheckBox;
import java.awt.Font;

/**
 * 
 * GUI layout for School Grades app
 * 
 * @author Lauramarie
 * @version 11/20/22
 *
 */
public class GuiWindowBuilderLayout extends JFrame {
	private static final long serialVersionUID = 8404049378028182418L;
	protected JLabel quizLbl;
	protected JLabel homeworkLbl;
	protected JLabel examLbl;
	protected JButton btnQuiz;
	protected JButton btnHomework;
	protected JButton btnExam;
	protected JTable tableQuiz;
	protected JTable tableHomework;
	protected JTable tableExam;
	protected JLabel lblWeight;
	protected JLabel lblSubtotals;
	protected JSpinner spinnerQuiz;
	protected JTextField textFieldQuiz;
	protected JSpinner spinnerHomework;
	protected JTextField textFieldHomework;
	protected JSpinner spinnerExam;
	protected JTextField textFieldExam;
	protected JCheckBox chckbxNewCheckBox;
	protected JLabel lblFinal;
	protected JTextField textField;

	/**
	 * Constructor for GuiWindowBuilderLayout
	 */
	public GuiWindowBuilderLayout() {
		setSize(new Dimension(600, 500));
		getContentPane().setLayout(null);

		this.quizLbl = new JLabel("Quizzes");
		this.quizLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.quizLbl.setBounds(148, 11, 46, 14);
		getContentPane().add(this.quizLbl);

		this.homeworkLbl = new JLabel("Homeworks");
		this.homeworkLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.homeworkLbl.setBounds(253, 11, 75, 14);
		getContentPane().add(this.homeworkLbl);

		this.examLbl = new JLabel("Exams");
		this.examLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.examLbl.setBounds(387, 11, 46, 14);
		getContentPane().add(this.examLbl);

		this.btnQuiz = new JButton("Add Quiz");
		this.btnQuiz.setBounds(148, 36, 94, 23);
		this.btnQuiz.setToolTipText("This button adds a new quiz of 0.0");
		getContentPane().add(this.btnQuiz);

		this.btnHomework = new JButton("Add Homework");
		this.btnHomework.setBounds(252, 36, 121, 23);
		this.btnHomework.setToolTipText("This button adds a new homework of 0.0");
		getContentPane().add(this.btnHomework);

		this.btnExam = new JButton("Add Exam");
		this.btnExam.setBounds(383, 36, 104, 23);
		this.btnQuiz.setToolTipText("This button adds a new exam of 0.0");
		getContentPane().add(this.btnExam);

		this.tableQuiz = new JTable();
		this.tableQuiz.setBounds(148, 67, 94, 209);
		getContentPane().add(this.tableQuiz);

		this.tableHomework = new JTable();
		this.tableHomework.setBounds(253, 67, 120, 209);
		getContentPane().add(this.tableHomework);

		this.tableExam = new JTable();
		this.tableExam.setBounds(383, 67, 104, 209);
		getContentPane().add(this.tableExam);

		this.lblWeight = new JLabel("Weight (0.0 - 1.0)");
		this.lblWeight.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.lblWeight.setHorizontalAlignment(SwingConstants.LEFT);
		this.lblWeight.setBounds(10, 290, 105, 14);
		getContentPane().add(this.lblWeight);

		this.lblSubtotals = new JLabel("Subtotals");
		this.lblSubtotals.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.lblSubtotals.setHorizontalAlignment(SwingConstants.LEFT);
		this.lblSubtotals.setBounds(10, 321, 63, 14);
		getContentPane().add(this.lblSubtotals);

		this.spinnerQuiz = new JSpinner();
		this.spinnerQuiz.setModel(new SpinnerNumberModel(0.0, 0.0, 1.0, 0.01));
		this.spinnerQuiz.setBounds(148, 287, 94, 20);
		this.spinnerQuiz.setToolTipText("Enter quiz category weight (0.0 - 1.0)");
		getContentPane().add(this.spinnerQuiz);

		this.textFieldQuiz = new JTextField();
		this.textFieldQuiz.setEditable(false);
		this.textFieldQuiz.setBounds(148, 318, 94, 20);
		this.textFieldQuiz.setToolTipText("Displays the subtotal for quiz grades");
		getContentPane().add(this.textFieldQuiz);
		this.textFieldQuiz.setColumns(10);

		this.spinnerHomework = new JSpinner();
		this.spinnerHomework.setModel(new SpinnerNumberModel(0.0, 0.0, 1.0, 0.01));
		this.spinnerHomework.setBounds(253, 287, 120, 20);
		this.spinnerHomework.setToolTipText("Enter homework category weight (0.0 - 1.0)");
		getContentPane().add(this.spinnerHomework);

		this.textFieldHomework = new JTextField();
		this.textFieldHomework.setEditable(false);
		this.textFieldHomework.setBounds(253, 318, 120, 20);
		this.textFieldHomework.setToolTipText("Displays the subtotal for homework grades");
		getContentPane().add(this.textFieldHomework);
		this.textFieldHomework.setColumns(10);

		this.spinnerExam = new JSpinner();
		this.spinnerExam.setModel(new SpinnerNumberModel(0.0, 0.0, 1.0, 0.01));
		this.spinnerExam.setBounds(387, 287, 100, 20);
		this.spinnerExam.setToolTipText("Enter exam category weight (0.0 - 1.0)");
		getContentPane().add(this.spinnerExam);

		this.textFieldExam = new JTextField();
		this.textFieldExam.setEditable(false);
		this.textFieldExam.setBounds(387, 318, 100, 20);
		this.textFieldHomework.setToolTipText("Displays the subtotal for exam grades");
		getContentPane().add(this.textFieldExam);
		this.textFieldExam.setColumns(10);

		this.chckbxNewCheckBox = new JCheckBox("Drop Lowest Homework?");
		this.chckbxNewCheckBox.setBounds(253, 354, 203, 23);
		this.chckbxNewCheckBox.setToolTipText("When selected the lowest homework is dropped from the calculation.");
		getContentPane().add(this.chckbxNewCheckBox);

		this.lblFinal = new JLabel("Final Grade");
		this.lblFinal.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.lblFinal.setBounds(387, 405, 69, 14);
		getContentPane().add(this.lblFinal);

		this.textField = new JTextField();
		this.textField.setEditable(false);
		this.textField.setBounds(386, 430, 101, 20);
		getContentPane().add(this.textField);
		this.textField.setColumns(10);

	}
}
