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
/** The ViewTravelPackages class
 * With this class I enable the 
 * admin and customers to see all created travelpackages.
 */
public class ViewTravelPackages extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;


	/**
	 * Create the frame.
	 */
	public ViewTravelPackages() {
		setTitle("Ku Travel Agency");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1675, 876);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1641, 805);
		contentPane.add(scrollPane);
		
		table = new JTable();

		
		List<String[]> list = FileHelpers.Travelpackagetolist(); 
		
		
		Object[][] dataArray = new Object[list.size()][];
		int rowcount = 1;
		for (int i = 0; i < list.size(); i++) {
			String[] row = list.get(i);
			Object[] newRow = new Object[7];
			String[] newrow = new  String[row.length+1];
	
			newrow[0]= String.valueOf(rowcount);
			for (int t = 1; t< row.length+1; t++ ) {
				if (row[t-1].equals("null")) {
					newrow[t] = "";
				}
				else {
					newrow[t]= row[t-1];
				}
	
			}
			++rowcount;
			dataArray[i] = newrow;
		}

		table.setModel(new DefaultTableModel(
			dataArray,
			new String[] {
				"            ","Package name","General Information", "Hotel", "Duration of stay"," Airline Options", "Departure City,", "Arrival City"," Departure Time", " Arrival Time", "Ticket Class","Available Seats","Stopover City","Final Arrival City","Leg 1 Departure Time","Leg 1 Arrival Time","Leg 2 Departure Time","Leg 2 Arrival Time\r\n",
						"Taxi Type", "Taxi Service area","distance","Total Price" 
			}
		));
		
		scrollPane.setViewportView(table);
		

		
		
	        
	}
}
