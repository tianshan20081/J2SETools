/**
 * 
 */
package com.aoeng.dp.cat1.ch1.t3;

import javax.swing.table.AbstractTableModel;

/**
 * Oct 17, 2013:9:45:47 AM
 */
public class RocketTableModel extends AbstractTableModel {
	private Rocket[] rockets;
	private String[] columnNames = new String[] { "Name", "Price", "Apogee" };

	/**
	 * @param rockets
	 */
	public RocketTableModel(Rocket[] rockets) {
		this.rockets = rockets;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rockets.length;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.AbstractTableModel#getColumnName(int)
	 */
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columnNames[column];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex) {
		case 0:
			return rockets[rowIndex].getName();

		case 1:
			return rockets[rowIndex].getPrice();
		case 2:
			return new Dollars(rockets[rowIndex].getApogee());
		default:
			return null;
		}
	}

}
