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
import javax.swing.JComboBox;
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
import reservationentities.Flight;
import reservationentities.Hotels;
import reservationentities.Taxi;
import reservationentities.TravelPackage;
/** The CreatTravelPackage class
 * With this class, 
 * I ensure that the travelpackage created
 *  by the admin on this page is saved to files.
 * 
 */
public class CreatTravelPackage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private int rowf ;
	private int rowt ;
	private int rowh ;
	private int comrate;
	
	private JPanel panel;
	private JButton btnNewButton;

	private JTable table_1;
	private JTable table_2;
	private JTextField Pname;
	private JTextField Pdescription;
	
	public int getRowF() {
		return rowf;
	}

	public void setRow(int row) {
		this.rowf = row;
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

	
	
	
	public int getComrate() {
		return comrate;
	}

	public void setComrate(int comrate) {
		this.comrate = comrate;
	}

	

	/**
	 * Create the frame.
	 */
	public CreatTravelPackage() {
		setTitle("Ku Travel Agency");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1571, 714);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 944, 215);
		contentPane.add(scrollPane);

		JTextArea textAreaf = new JTextArea();
		textAreaf.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textAreaf.setBounds(10, 11, 250, 284);
		
		
		table = new JTable();

		
       List<String[]> list = FileHelpers.SourceToList("data/FinalKU_Travel_Agency_Dataset_Flights.csv"); 
		Object[][] dataArray = new Object[list.size()][16];
		int rowcount = 1;
		for (int i = 0; i < list.size(); i++) {
			String[] row = list.get(i);

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
				"            ", "Flight ID", "Airline", "Departure City", "Arrival City", "Departure Time", "Arrival Time","Ticket Class","Price ($)","Available Seats","Stopover City","Final Arrival City",
				"Leg 1 Departure Time","Leg 1 Arrival Time","Leg 2 Departure Time","Leg 2 Arrival Time"
			}
		));

		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 237, 944, 203);
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
		scrollPane_2.setBounds(10, 451, 944, 215);
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

		
		scrollPane_1.setViewportView(table_1);
		scrollPane_2.setViewportView(table_2);
		
		
		panel = new JPanel();
		panel.setBounds(964, 11, 583, 655);
		contentPane.add(panel);
		panel.setLayout(null);
		JTextArea textAreah = new JTextArea();
		textAreah.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textAreah.setBounds(323, 11, 250, 284);
		panel.add(textAreah);
		
		JTextArea textAreat = new JTextArea();
		textAreat.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textAreat.setBounds(323, 306, 250, 177);
		panel.add(textAreat);
		
		JTextArea costarea = new JTextArea();
		costarea.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		costarea.setBounds(10, 306, 250, 56);
		panel.add(costarea);
		ArrayList<Integer> items = new ArrayList<>();
		
		for(int a =0; a<50;a++) {
			items.add(a);
		}
		
		table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	
                setRow( table.rowAtPoint(e.getPoint()));
                Object flightID = table.getValueAt(rowf, 1);
                Object airline = table.getValueAt(rowf, 2);
                Object departureCity = table.getValueAt(rowf, 3);
                Object arrivalCity = table.getValueAt(rowf, 4);
                Object departureTime = table.getValueAt(rowf, 5);
                Object arrivalTime = table.getValueAt(rowf, 6);
                Object ticketClass = table.getValueAt(rowf, 7);
                double price = Double.parseDouble((String)table.getValueAt(rowf, 8));
                Object availableSeats = table.getValueAt(rowf, 9);  
                Object stopoverCity = table.getValueAt(rowf, 10);  
                Object finalArrivalCity = table.getValueAt(rowf, 11);    
                Object leg1DepartureTime = table.getValueAt(rowf, 12);    
                Object leg1ArrivalTime = table.getValueAt(rowf, 13);      
                Object leg2DepartureTime = table.getValueAt(rowf, 14);     
                Object leg2ArrivalTime = table.getValueAt(rowf, 15); 
                
                textAreaf.setText("Flight Informations \n");
                textAreaf.append("Flight ID: " + flightID + "\n");
                textAreaf.append("Airline: " + airline+ "\n");
                textAreaf.append("Departure City: " + departureCity+ "\n");
                if((String)table.getValueAt(rowf, 4) ==""){
                	textAreaf.append("Flight Type: With Transfer"+ "\n");
                	textAreaf.append("Stopover City: " + stopoverCity+ "\n");
                    textAreaf.append("Final Arrival City: " + finalArrivalCity+ "\n");
                    textAreaf.append("Leg 1 Departure Time: " + leg1DepartureTime+ "\n");
                    textAreaf.append("Leg 1 Arrival Time: " + leg1ArrivalTime+ "\n");
                    textAreaf.append("Leg 2 Departure Time: " + leg2DepartureTime+ "\n");
                    textAreaf.append("Leg 2 Arrival Time: " + leg2ArrivalTime+ "\n");
                	textAreaf.append("Ticket Class: " + ticketClass+ "\n");
                    textAreaf.append("Price ($): " + price+ "\n");
                    textAreaf.append("Available Seats: " +  availableSeats+ "\n");
                	
                	
		         }
                else {
                	textAreaf.append("Flight Type: Direct");
                	textAreaf.append("Arrival City: " + arrivalCity+ "\n");
                    textAreaf.append("Departure Time: " + departureTime+ "\n");
                    textAreaf.append("Arrival Time: " + arrivalTime+ "\n");
                    textAreaf.append("Ticket Class: " + ticketClass+ "\n");
                    textAreaf.append("Price ($): " + price+ "\n");
                    textAreaf.append("Available Seats: " +  availableSeats+ "\n");
                	
                }
  
                
                
            }
        });
		
		table_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	
                setRowh( table_1.rowAtPoint(e.getPoint()));
                Object name = table_1.getValueAt(rowh, 1);
                Object city = table_1.getValueAt(rowh, 2);
                Object roomtype = table_1.getValueAt(rowh, 3);
                Object arooms = table_1.getValueAt(rowh, 4);
                Object priceper = table_1.getValueAt(rowh, 5);
                Object distanceto = table_1.getValueAt(rowh, 6);
                textAreah.setText("Hotel Informations \n");
                textAreah.append("Hotel Name: " + name + "\n");
                textAreah.append("City: " + city+ "\n");
                textAreah.append("Room Type: " + roomtype+ "\n");
                textAreah.append("Available Rooms: " + arooms+ "\n");
                textAreah.append("Price per Night ($): " + priceper+ "\n");
                textAreah.append("Distance to Airport (km): " + distanceto+ "\n");
                
            }
        });
		
		table_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	
                setRowt( table_2.rowAtPoint(e.getPoint()));
                Object name = table_2.getValueAt(rowt, 1);
                Object city = table_2.getValueAt(rowt, 2);
                Object roomtype = table_2.getValueAt(rowt, 3);
                Object arooms = table_2.getValueAt(rowt, 4);
                Object priceper = table_2.getValueAt(rowt, 5);

                textAreat.setText("Taxi Informations \n");
                textAreat.append("City: " + name + "\n");
                textAreat.append("Taxi Type: " + city+ "\n");
                textAreat.append("Available Taxis:" + roomtype+ "\n");
                textAreat.append("Base Fare ($): " + arooms+ "\n");
                textAreat.append("Per KM Rate ($): " + priceper+ "\n");

            }
        });
		
		
		
		panel.add(textAreaf);
        ArrayList<Integer> items1 = new ArrayList<>();
		
		for(int a =0; a<50;a++) {
			items1.add(a);
		}
		JComboBox<Integer>  comboBox = new JComboBox<>(items1.toArray(new Integer[0]));

		
           
		comboBox.setBounds(154, 430, 159, 31);
		
		panel.add(comboBox);
		
		
       comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				double price = Double.parseDouble((String)table.getValueAt(rowf, 8));
				double priceper = Double.parseDouble((String)table_1.getValueAt(rowh, 5));
				double arooms = Double.parseDouble((String)table_2.getValueAt(rowt, 4));
				double pricepert = Double.parseDouble((String)table_2.getValueAt(rowt, 5));
				double distanceto =  Double.parseDouble((String)table_1.getValueAt(rowh, 6));
				
				
				int selectedItem = (Integer) comboBox.getSelectedItem();
				costarea.setText("\n");
                costarea.append("Total Cost: " + ((price + arooms + (priceper*selectedItem)+ (pricepert*distanceto))*((comrate+100)/100)) + "\n");
                
			}
		});
		
		
		
		
		JLabel lblNewLabel = new JLabel("Select Stayday");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(10, 426, 159, 31);
		panel.add(lblNewLabel);
		Pname = new JTextField();
		Pname.setBounds(225, 512, 348, 31);
		panel.add(Pname);
		Pname.setColumns(10);
		
		Pdescription = new JTextField();
		Pdescription.setColumns(10);
		Pdescription.setBounds(225, 556, 348, 31);
		panel.add(Pdescription);

		
		btnNewButton = new JButton("Creat TravelPackage");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int selectedItem = (Integer) comboBox.getSelectedItem();
				String flightID =(String) table.getValueAt(rowf, 1);
                String airline = (String) table.getValueAt(rowf, 2);
                String departureCity = (String) table.getValueAt(rowf, 3);
                String arrivalCity =(String)  table.getValueAt(rowf, 4);
                String departureTime = (String) table.getValueAt(rowf, 5);
                String arrivalTime = (String) table.getValueAt(rowf, 6);
                String ticketClass = (String) table.getValueAt(rowf, 7);
                double price = Double.parseDouble((String)table.getValueAt(rowf, 8));
                int availableSeats = Integer.parseInt((String) table.getValueAt(rowf, 9));  
                String stopoverCity = (String) table.getValueAt(rowf, 10);  
                String finalArrivalCity = (String) table.getValueAt(rowf, 11);    
                String leg1DepartureTime =(String)  table.getValueAt(rowf, 12);    
                String leg1ArrivalTime =(String)  table.getValueAt(rowf, 13);      
                String leg2DepartureTime =(String)  table.getValueAt(rowf, 14);     
                String leg2ArrivalTime =(String)  table.getValueAt(rowf, 15); 
                
                String name = (String) table_1.getValueAt(rowh, 1);
                String city = (String) table_1.getValueAt(rowh, 2);
                String roomtype = (String) table_1.getValueAt(rowh, 3);
                int arooms = Integer.parseInt((String) table_1.getValueAt(rowh, 4));
                double priceper = Double.parseDouble((String) table_1.getValueAt(rowh, 5));
                double distanceto = Double.parseDouble((String) table_1.getValueAt(rowh, 6));
                
                String cityt = (String) table_2.getValueAt(rowt, 1);
                String taxitype = (String) table_2.getValueAt(rowt, 2);
                int availabilet =Integer.parseInt((String)  table_2.getValueAt(rowt, 3));
                double basefare = Double.parseDouble((String) table_2.getValueAt(rowt, 4));
                double priceperkm = Double.parseDouble((String) table_2.getValueAt(rowt, 5));
                
                Flight flight;
                if(arrivalCity == ""){
                	flight = new Flight(flightID,airline,departureCity,ticketClass,price,availableSeats,stopoverCity,finalArrivalCity,leg1DepartureTime,leg1ArrivalTime,leg2DepartureTime,leg2ArrivalTime);
                }
                else {
                	flight = new Flight(flightID,airline,departureCity,arrivalCity,departureTime,arrivalTime,ticketClass,price,availableSeats);
                }
                
                Hotels hotel = new Hotels(name,city,roomtype,priceper,arooms,distanceto); 
                
                Taxi taxi = new Taxi(cityt,taxitype,availabilet,basefare,priceperkm);
                String packagename = Pname.getText();
                String info = Pdescription.getText();
				if (arrivalCity == "") {
					if(finalArrivalCity.equals(city) && city.equals(cityt)&&flight.isavailable()&&taxi.isavailable()&&hotel.isavailable()) {
						TravelPackage t = new TravelPackage(packagename,info,hotel,flight,taxi,comrate,selectedItem);
						FileHelpers.CreatNewTravelPackage(t, rowh+1, rowf+1, rowt+1);
						JOptionPane.showMessageDialog(null, "TravelPackage Created","Message",JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "The Cities of Flight,Taxi,Hotel is not matching or availability of entities is false","Message",JOptionPane.INFORMATION_MESSAGE);
					}
					
					
				}
				else {
					if(arrivalCity.equals(city) && city.equals(cityt)&& flight.isavailable()&&taxi.isavailable()&&hotel.isavailable()) {
						TravelPackage t = new TravelPackage(packagename,info,hotel,flight,taxi,comrate,selectedItem);
						FileHelpers.CreatNewTravelPackage(t, rowh+1, rowf+1, rowt+1);
						JOptionPane.showMessageDialog(null, "TravelPackage Created","Message",JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "The Cities of Flight,Taxi,Hotel is not matching","Message",JOptionPane.INFORMATION_MESSAGE);
					}
					
				}
				
			}
			
		});
		btnNewButton.setBounds(10, 598, 250, 46);
		panel.add(btnNewButton);
		
		JLabel lblPackagename = new JLabel("PackageName :");
		lblPackagename.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblPackagename.setBounds(10, 514, 159, 31);
		panel.add(lblPackagename);
		
		JLabel lblPackageDescription = new JLabel("Package Description:");
		lblPackageDescription.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblPackageDescription.setBounds(10, 556, 205, 31);
		panel.add(lblPackageDescription);
		

		
		JLabel lblCommisionRate = new JLabel("Commision Rate:");
		lblCommisionRate.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCommisionRate.setBounds(10, 465, 134, 31);
		panel.add(lblCommisionRate);
		
		 ArrayList<Integer> items11 = new ArrayList<>();
			
			for(int a =0; a<50;a++) {
				items11.add(a);
			}
			JComboBox<Integer>  comboBox1 = new JComboBox<>(items11.toArray(new Integer[0]));

			
	           
			comboBox1.setBounds(154, 468, 159, 31);
			
			panel.add(comboBox1);
			
			
	       comboBox1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					double price = Double.parseDouble((String)table.getValueAt(rowf, 8));
					double priceper = Double.parseDouble((String)table_1.getValueAt(rowh, 5));
					double arooms = Double.parseDouble((String)table_2.getValueAt(rowt, 4));
					double pricepert = Double.parseDouble((String)table_2.getValueAt(rowt, 5));
					double distanceto =  Double.parseDouble((String)table_1.getValueAt(rowh, 6));
					
				
					int selectedItem = (Integer) comboBox.getSelectedItem();
					int selectedItem1 = (Integer) comboBox1.getSelectedItem();
					setComrate(selectedItem1);
					costarea.setText("\n");
	                costarea.append("Total Cost: " + ((price + arooms + (priceper*selectedItem)+ (pricepert*distanceto))*((selectedItem1+100.0)/100.0)) + "\n");
	                System.out.print(((selectedItem1+100.0)/100.0));
				}
			});
		
		
		
		
        
		
	}
}
