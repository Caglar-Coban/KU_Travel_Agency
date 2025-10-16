package Gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import helpers.FileHelpers;
/**The EditTravelPackage class
 * With this class I allow the admin to edit any travelpackage admin chooses.
 */
public class EditTravelPackage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField packagename;
	private JTextField description;
	private JLabel lblNewLabel_2;
	private JTextField commisionrate;
	private JLabel lblNewLabel_3;
	private JTextField discount;
	private JLabel lblNewLabel_4;
	private JTextField stayday;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JButton btnNewButton;
	private JTable table;
	private JLabel lblNewLabel;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private int row;
	private int rowf ;
	private int rowt ;
	private int rowh ;
	
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getRowf() {
		return rowf;
	}

	public void setRowf(int rowf) {
		this.rowf = rowf;
	}

	public int getRowt() {
		return rowt;
	}

	public void setRowt(int rowt) {
		this.rowt = rowt;
	}

	public int getRowh() {
		return rowh;
	}

	public void setRowh(int rowh) {
		this.rowh = rowh;
	}

	

	/**
	 * Create the frame.
	 */
	public EditTravelPackage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1502, 928);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Change Packgage name :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblNewLabel_1.setBounds(958, 37, 270, 70);
		contentPane.add(lblNewLabel_1);
		
		packagename = new JTextField();
		packagename.setColumns(10);
		packagename.setBounds(1238, 37, 240, 70);
		contentPane.add(packagename);
		
		description = new JTextField();
		description.setColumns(10);
		description.setBounds(1238, 118, 240, 70);
		contentPane.add(description);
		
		lblNewLabel_2 = new JLabel("Change description :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		lblNewLabel_2.setBounds(958, 118, 270, 70);
		contentPane.add(lblNewLabel_2);
		
		commisionrate = new JTextField();
		commisionrate.setColumns(10);
		commisionrate.setBounds(1238, 199, 240, 70);
		contentPane.add(commisionrate);
		
		lblNewLabel_3 = new JLabel("Change Commision Rate :");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblNewLabel_3.setBounds(958, 199, 270, 70);
		contentPane.add(lblNewLabel_3);
		
		discount = new JTextField();
		discount.setColumns(10);
		discount.setBounds(1238, 280, 240, 70);
		contentPane.add(discount);
		
		lblNewLabel_4 = new JLabel("Apply discount :");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		lblNewLabel_4.setBounds(958, 280, 270, 70);
		contentPane.add(lblNewLabel_4);
		
		stayday = new JTextField();
		stayday.setColumns(10);
		stayday.setBounds(1238, 361, 240, 70);
		contentPane.add(stayday);
		
		lblNewLabel_5 = new JLabel("Change Stay Day :");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 33));
		lblNewLabel_5.setBounds(958, 361, 270, 70);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Select to Change the Taxi");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 33));
		lblNewLabel_6.setBounds(11, 622, 436, 37);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Select To Change the Hotel");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 33));
		lblNewLabel_7.setBounds(11, 378, 536, 37);
		contentPane.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Select to Change the Flight");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 33));
		lblNewLabel_8.setBounds(19, 178, 723, 37);
		contentPane.add(lblNewLabel_8);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 50, 936, 120);
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
			
			
			

			
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(7, 419, 944, 201);
			contentPane.add(scrollPane_1);
			
			table_1 = new JTable();
			List<String[]> lists = FileHelpers.SourceToList("data/FinalKU_Travel_Agency_Dataset_Hotels.csv"); 
			Object[][] dataArrays = new Object[lists.size()][];
			int rowcounts = 1;
			for (int i = 0; i < lists.size(); i++) {
				String[] row = lists.get(i);

				String[] newrow = new  String[row.length+1];
		
				newrow[0]= String.valueOf(rowcounts);
				for (int t = 1; t< row.length+1; t++ ) {
					newrow[t]= row[t-1];
				}
				++rowcounts;
				dataArrays[i] = newrow;
			}

			table_1.setModel(new DefaultTableModel(
				dataArrays,
				new String[] {
						"            ", "Hotel Name", "City", "Room Type", "Available Rooms", "Price per Night ($)", "Distance to Airport (km)"
				}
			));
			scrollPane_1.setViewportView(table_1);

			
			JScrollPane scrollPane_2 = new JScrollPane();
			scrollPane_2.setBounds(9, 664, 944, 222);
			contentPane.add(scrollPane_2);
			
			table_2 = new JTable();
			List<String[]> listss = FileHelpers.SourceToList("data/FinalKU_Travel_Agency_Dataset_Taxis.csv"); 
			Object[][] dataArrayss = new Object[listss.size()][16];
			int rowcountss = 1;
			for (int i = 0; i < listss.size(); i++) {
				String[] row = listss.get(i);

				String[] newrow = new  String[row.length+1];
		
				newrow[0]= String.valueOf(rowcountss);
				for (int t = 1; t< row.length+1; t++ ) {
					newrow[t]= row[t-1];
				}
				++rowcountss;
				dataArrayss[i] = newrow;
			}

			table_2.setModel(new DefaultTableModel(
				dataArrayss,
				new String[] {
						"            ", "City", "Taxi Type", "Available Taxis", "Base Fare ($)", "Per KM Rate ($)"
				}
			));

			scrollPane_2.setViewportView(table_2);
			
			JScrollPane scrollPane_3 = new JScrollPane();
			scrollPane_3.setBounds(12, 218, 936, 153);
			contentPane.add(scrollPane_3);
			table_3 = new JTable();
			
			
			
			List<String[]> lista = FileHelpers.SourceToList("data/FinalKU_Travel_Agency_Dataset_Flights.csv"); 
			
			
			Object[][] dataArraya = new Object[lista.size()][16];
			int rowcounta = 1;
			for (int i = 0; i < lista.size(); i++) {
				String[] row = lista.get(i);
				Object[] newRow = new Object[7];
				String[] newrow = new  String[row.length+1];
		
				newrow[0]= String.valueOf(rowcounta);
				for (int t = 1; t< row.length+1; t++ ) {
					newrow[t]= row[t-1];
				}
				++rowcounta;
				dataArraya[i] = newrow;
			}

			table_3.setModel(new DefaultTableModel(
				dataArraya,
				new String[] {
					"            ", "Flight ID", "Airline", "Departure City", "Arrival City", "Departure Time", ",Arrival Time","Ticket Class","Price ($)","Available Seats","Stopover City","Final Arrival City",
					"Leg 1 Departure Time","Leg 1 Arrival Time","Leg 2 Departure Time","Leg 2 Arrival Time"
				}
			));
			
			scrollPane_3.setViewportView(table_3);

			table.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	setRow( table.rowAtPoint(e.getPoint())+1);

	            }
	        });
			table_1.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	
	            	setRowh( table_1.rowAtPoint(e.getPoint())+1);

	            }
	        });
			table_2.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	setRowt( table_2.rowAtPoint(e.getPoint())+1);
	            }
	        });
			table_3.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	setRowf( table_2.rowAtPoint(e.getPoint())+1);
	            }
	        });
		btnNewButton = new JButton("Apply Changes");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(row==0) {
	            	   JOptionPane.showMessageDialog(null, "You Must Select a Package ","Message",JOptionPane.INFORMATION_MESSAGE);
					}
	                else {
	                	int indx = row; 
	                	String name = packagename.getText();
	                	String info = description.getText();
	                	double comrate;
	                	double disco;
	                	int iflight;
	                	int ihotel;
	                	int itaxi;
	                	int stday;
	                    if(!commisionrate.getText().equals("")) {
	    					comrate = Double.parseDouble(commisionrate.getText());
	    				}
	                    else {
	                    	comrate = -1;
	                    }
	                    if(!discount.getText().equals("")) {
	                    	disco = Double.parseDouble(discount.getText());
	    				}
	                    else {
	                    	disco = -1;
	                    }
	                    if(rowf != 0) {
	                    	iflight = rowf;
	    				}
	                    else {
	                    	iflight = -1;
	                    }
	                    if(rowh != 0) {
	                    	ihotel = rowh;
	    				}
	                    else {
	                    	ihotel = -1;
	                    }
	                    if(rowt != 0) {
	                    	itaxi = rowt;
	    				}
	                    else {
	                        itaxi = -1;
	                    }
	                    if(!stayday.getText().equals("")) {
	    					stday = Integer.parseInt(stayday.getText());
	    				}
	                    else {
	                    	stday = -1;
	                    }
	                    FileHelpers.EditTravelPackage(indx, name, info, comrate, disco, iflight, ihotel, itaxi, stday);
	                    dispose();
	                    EditTravelPackage frame = new EditTravelPackage();
						frame.setVisible(true);
                    
						JOptionPane.showMessageDialog(null, "Package Edited","Message",JOptionPane.INFORMATION_MESSAGE);
                
				
                
				
				
				
			}}
		});
		btnNewButton.setBounds(1152, 467, 335, 74);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("Select Package To Change");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblNewLabel.setBounds(10, 0, 606, 37);
		contentPane.add(lblNewLabel);
		
	
	}
}
