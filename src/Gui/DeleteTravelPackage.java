package Gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import helpers.FileHelpers;
/** The DeleteTravelPackage class
 * With this class, I enable the admin 
 * to permanently remove any travelpackage 
 * admin wants from the system.
 * 
 */
public class DeleteTravelPackage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField index;
	private JLabel lblReason;
	private JTextField Reason;
	private JTable table;
	private int row ;
	private JPanel panel;
	private JButton btnNewButton;
	
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	

	/**
	 * Create the frame.
	 */
	public DeleteTravelPackage() {
		setTitle("Ku Travel Agency");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1374, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 944, 471);
		contentPane.add(scrollPane);

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textArea.setBounds(20, 11, 356, 360);
		
		
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
		
		panel = new JPanel();
		panel.setBounds(964, 11, 386, 471);
		contentPane.add(panel);
		panel.setLayout(null);
		
		ArrayList<Integer> items = new ArrayList<>();
		
		for(int a =0; a<list.size();a++) {
			items.add(a);
		}
		
		table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	
            	 setRow( table.rowAtPoint(e.getPoint()));
                 Object packageName = table.getValueAt(row, 1);        
                 Object generalInfo = table.getValueAt(row, 2);           
                 Object hotel = table.getValueAt(row, 3);                
                 Object durationOfStay = table.getValueAt(row, 4);
                 Object airline = table.getValueAt(row, 5);
                 Object departureCity = table.getValueAt(row, 6);            
                 Object arrivalCity = table.getValueAt(row, 7);             
                 Object departureTime = table.getValueAt(row, 8);          
                 Object arrivalTime = table.getValueAt(row, 9);                 
                 Object ticketClass = table.getValueAt(row, 10);            
                 Object availableSeats = table.getValueAt(row, 11);         
                 Object stopoverCity = table.getValueAt(row, 12);            
                 Object finalArrivalCity = table.getValueAt(row, 13);       
                 Object leg1DepartureTime = table.getValueAt(row, 14);     
                 Object leg1ArrivalTime = table.getValueAt(row, 15);       
                 Object leg2DepartureTime = table.getValueAt(row, 16);      
                 Object leg2ArrivalTime = table.getValueAt(row, 17);   
                 Object taxiType = table.getValueAt(row, 18);              
                 Object taxiServiceArea = table.getValueAt(row, 19);        
                 Object distance = table.getValueAt(row, 20);               
                 double totalPrice =Double.parseDouble((String) table.getValueAt(row, 21));            
                 
                 textArea.setText("TravelPackage Informations \n");
                 textArea.append("Package name: " + packageName+ "\n");
                 textArea.append("General Information: " + generalInfo+ "\n");
                 textArea.append("Hotel: " + hotel+ "\n");
                 textArea.append("Duration of stay: " + durationOfStay+ "\n");
                 textArea.append("Airline: " + airline+ "\n");
                 textArea.append("Departure City: " + departureCity+ "\n");
                 if((boolean)table.getValueAt(row, 7).equals("")){
                 	textArea.append("Flight Type: With Transfer" + "\n");
                 	textArea.append("Stopover City: " + stopoverCity+ "\n");
                     textArea.append("Final Arrival City: " + finalArrivalCity+ "\n");
                     textArea.append("Leg 1 Departure Time: " + leg1DepartureTime+ "\n");
                     textArea.append("Leg 1 Arrival Time: " + leg1ArrivalTime+ "\n");
                     textArea.append("Leg 2 Departure Time: " + leg2DepartureTime+ "\n");
                     textArea.append("Leg 2 Arrival Time: " + leg2ArrivalTime+ "\n");
                 	
                 	
 		         }
                 else {
                 	textArea.append("Flight Type: Direct" + "\n");
                     textArea.append("Arrival City: " + arrivalCity+ "\n");
                     textArea.append("Departure Time: " + departureTime+ "\n");
                     textArea.append("Arrival Time: " + arrivalTime+ "\n");

                 	
                 }
                 textArea.append("Ticket Class: " + ticketClass+ "\n");
                 textArea.append("Available Seats: " + availableSeats+ "\n");
                 textArea.append("Taxi Type: " + taxiType+ "\n");
                 textArea.append("Taxi Service area: " + taxiServiceArea+ "\n");
                 textArea.append("distance: " + distance+ "\n");
                 
                 textArea.append("\n"+"Total Cost: " +  totalPrice+ "\n");
            }
        });
		
		panel.add(textArea);
		
		btnNewButton = new JButton("Delete Travel Package");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FileHelpers.DeleteTravelPackage(row+1);
				dispose();
				DeleteTravelPackage frame = new DeleteTravelPackage();
				frame.setVisible(true);
				JOptionPane.showMessageDialog(null, "TravelPackage Deleted","Message",JOptionPane.INFORMATION_MESSAGE);
				 
			}
			
		});
		btnNewButton.setBounds(66, 382, 250, 46);
		panel.add(btnNewButton);
		
	}
}
