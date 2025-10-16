package Gui;

import java.awt.Color;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import helpers.FileHelpers;
/** The ViewHotels class
 * With this class, 
 * I enable the customer or the 
 * admin to see all hotels objects according to the given data.
 */
public class ViewHotels extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;



	/**
	 * Create the frame.
	 */
	public ViewHotels() {
		setTitle("Ku Travel Agency");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1374, 864);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1340, 805);
		contentPane.add(scrollPane);
		
		table = new JTable();

		
		List<String[]> list = FileHelpers.SourceToList("data/FinalKU_Travel_Agency_Dataset_Hotels.csv"); 
		
		
		Object[][] dataArray = new Object[list.size()][7];
		int rowcount = 1;
		for (int i = 0; i < list.size(); i++) {
			String[] row = list.get(i);
			Object[] newRow = new Object[7];
			String[] newrow = new  String[row.length+1];
	
			newrow[0]= String.valueOf(rowcount);
			for (int t = 1; t< row.length+1; t++ ) {
				newrow[t]= row[t-1];
			}
			++rowcount;
			dataArray[i] = newrow;
		}

		table.setModel(new DefaultTableModel(
			dataArray,
			new String[] {
				"            ", "Hotel Name", "City", "Room Type", "Available Rooms", "Price per Night ($)", "Distance to Airport (km)"
			}
		));
		
		scrollPane.setViewportView(table);
		

		
		
	        
	}
}
