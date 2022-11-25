package edu.westga.cs.schoolgrades.views;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

/**
 * Class for the table model for the grades.
 * 
 * @author Lauramarie
 * @version 11/19/22
 *
 */
public class GradeTableModel extends AbstractTableModel {

	private static final long serialVersionUID = -1570136284525787480L;
	private ArrayList<Object> columns;
	private ArrayList<Object[]> rows;
	
	/**
	 * Constructor for the class.
	 * 	
	 */
	public GradeTableModel() {
		this.columns = new ArrayList<Object>();
		this.rows = new ArrayList<Object[]>();
	}

	/**
	 * Method for row count.
	 * 
	 */
	@Override
	public int getRowCount() {
		return this.rows.size();
	}

	/**
	 * Method for column count.
	 * 
	 */
	@Override
	public int getColumnCount() {
		return this.columns.size();
	}

	/**
	 * Method to get value for the rows.
	 * 
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return this.rows.get(rowIndex)[0];
	}
	
	/**
	 * Method to add a column to the table.
	 * @param aColumn	a column in the table
	 * 
	 */
	public void addColumn(Object aColumn) {
		this.columns.add(aColumn);
	}
	
	/**
	 * Method to add a column to the table.
	 * @param aRow	a row in the table
	 * 
	 */
	public void addRow(Object[] aRow) {
		this.rows.add(aRow);
	}
	
	/**
	 * Method that allows cell to be editable.
	 * 
	 */
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
	    return true;
	}
	
	/**
	 * Method to set the value entered in a cell.
	 * 
	 */
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		this.rows.set(rowIndex, new Object[] { aValue });
		fireTableCellUpdated(rowIndex, columnIndex);
	}
	
}
