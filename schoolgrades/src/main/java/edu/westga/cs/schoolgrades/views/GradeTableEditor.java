package edu.westga.cs.schoolgrades.views;

import java.awt.Component;

import javax.swing.AbstractCellEditor;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.TableCellEditor;

/**
 * Model class for the spinner in the grades tables.
 * 
 * @author Lauramarie
 * @version 11/19/22
 * 
 */
public class GradeTableEditor extends AbstractCellEditor implements TableCellEditor {

	private static final long serialVersionUID = 4145617872813860667L;
	private JSpinner spinner;
	private SpinnerNumberModel spinnerModel;
	protected static final String EDIT = "edit";
	
	/**
	 * Constructor for GradeTableEditor.
	 * 
	 */
	public GradeTableEditor() {
		this.spinner = new JSpinner();
		this.spinnerModel = new SpinnerNumberModel(0.0, 0.0, 100.00, 1.0);
		this.spinner.setModel(this.spinnerModel);
	}

	/**
	 * Method that returns the value of the spinner.
	 * 
	 */
	@Override
	public Object getCellEditorValue() {
		return this.spinnerModel.getValue();
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		return this.spinner;
	}

}
