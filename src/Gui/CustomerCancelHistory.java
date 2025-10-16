package Gui;

import java.awt.Color;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import travelagency.TravelHistory;
/** The CustomerCancelHistory class 
 * With this class, I enable the 
 * customer to see the reservations 
 * that they have previously canceled.
 * 
 */
public class CustomerCancelHistory extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;


	/**
	 * Create the frame.
	 */
	public CustomerCancelHistory(String name) {
		setTitle("Ku Travel Agency");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1463, 495);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1429, 443);
		contentPane.add(scrollPane);
		
		table = new JTable();

		
		List<String[]> list = TravelHistory.getCanceledWithName(name); 
		
		
		Object[][] dataArray = new Object[list.size()][6];
		int rowcount = 1;
		for (int i = 0; i < list.size(); i++) {
			String[] row = list.get(i);
			Object[] newRow = new Object[7];
			String[] newrow = new  String[row.length-1];
	
			newrow[0]= String.valueOf(rowcount);
			for (int t = 1; t< row.length-3; t++ ) {
				newrow[t]= row[t-1];
			}
			row[row.length-4] = "Canceled";
			newrow[row.length-3] = row[row.length-4];
			++rowcount;
			dataArray[i] = newrow;
		}

		table.setModel(new DefaultTableModel(
			dataArray,
			new String[] {
				"            ", "Date - Time", "Reservation Action", "Price","StayDay","Details" 
			}
		));
		
		scrollPane.setViewportView(table);
	}

}
