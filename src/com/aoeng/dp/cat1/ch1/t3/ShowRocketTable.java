/**
 * 
 */
package com.aoeng.dp.cat1.ch1.t3;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableModel;

/**
 * Oct 17, 2013:5:45:11 PM
 */
public class ShowRocketTable {
	public static void main(String[] args) {
		setFonts();
		JTable table = new JTable(getRocketTable());
		table.setRowHeight(36);
		JScrollPane pane = new JScrollPane(table);
		pane.setPreferredSize(new Dimension(300, 200));
		display(pane, "Rocket");
	}

	/**
	 * @param pane
	 * @param string
	 */
	private static void display(JScrollPane c, String title) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame(title);
		frame.getContentPane().add(c);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * @return
	 */
	private static RocketTableModel getRocketTable() {
		// TODO Auto-generated method stub
		Rocket r1 = new Rocket("Shooter", 1.0, new Dollars(3.95), 50.0, 4.5);
		Rocket r2 = new Rocket("Orbit", 2.0, new Dollars(29.03), 5000, 3.2);
		return new RocketTableModel(new Rocket[] { r1, r2 });
	}

	/**
	 * 
	 */
	private static void setFonts() {
		// TODO Auto-generated method stub
		Font font = new Font("Dialog", Font.PLAIN, 18);
		UIManager.put("Table.font", font);
		UIManager.put("TableHeader.font", font);
	}
}
