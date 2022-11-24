package edu.westga.cs.schoolgrades.views;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
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
		this.btnQuiz.setBounds(148, 36, 75, 23);
		getContentPane().add(this.btnQuiz);
		
		this.btnHomework = new JButton("Add Homework");
		this.btnHomework.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			}
		});
		this.btnHomework.setBounds(252, 36, 105, 23);
		getContentPane().add(this.btnHomework);
		
		this.btnExam = new JButton("Add Exam");
		this.btnExam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			}
		});
		this.btnExam.setBounds(383, 36, 89, 23);
		getContentPane().add(this.btnExam);
		
		this.tableQuiz = new JTable();
		this.tableQuiz.setBounds(148, 275, 75, -209);
		getContentPane().add(this.tableQuiz);
		
		this.tableHomework = new JTable();
		this.tableHomework.setBounds(253, 275, 104, -209);
		getContentPane().add(this.tableHomework);
		
		this.tableExam = new JTable();
		this.tableExam.setBounds(383, 275, 89, -209);
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
		this.spinnerQuiz.setModel(new SpinnerNumberModel(new Double(0), null, null, new Double(1)));
		this.spinnerQuiz.setBounds(148, 287, 75, 20);
		getContentPane().add(this.spinnerQuiz);
		
		this.textFieldQuiz = new JTextField();
		this.textFieldQuiz.setBounds(148, 318, 75, 20);
		getContentPane().add(this.textFieldQuiz);
		this.textFieldQuiz.setColumns(10);
		
		this.spinnerHomework = new JSpinner();
		this.spinnerHomework.setModel(new SpinnerNumberModel(new Double(0), null, null, new Double(1)));
		this.spinnerHomework.setBounds(253, 287, 104, 20);
		getContentPane().add(this.spinnerHomework);
		
		this.textFieldHomework = new JTextField();
		this.textFieldHomework.setBounds(253, 318, 104, 20);
		getContentPane().add(this.textFieldHomework);
		this.textFieldHomework.setColumns(10);
		
		this.spinnerExam = new JSpinner();
		this.spinnerExam.setModel(new SpinnerNumberModel(new Double(0), null, null, new Double(1)));
		this.spinnerExam.setBounds(387, 287, 85, 20);
		getContentPane().add(this.spinnerExam);
		
		this.textFieldExam = new JTextField();
		this.textFieldExam.setBounds(387, 318, 85, 20);
		getContentPane().add(this.textFieldExam);
		this.textFieldExam.setColumns(10);
		
		this.chckbxNewCheckBox = new JCheckBox("Drop Lowest Homework?");
		this.chckbxNewCheckBox.setBounds(253, 354, 154, 23);
		getContentPane().add(this.chckbxNewCheckBox);
		
		this.lblFinal = new JLabel("Final Grade");
		this.lblFinal.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.lblFinal.setBounds(387, 405, 69, 14);
		getContentPane().add(this.lblFinal);
		
		this.textField = new JTextField();
		this.textField.setBounds(386, 430, 86, 20);
		getContentPane().add(this.textField);
		this.textField.setColumns(10);
		
	}
}
