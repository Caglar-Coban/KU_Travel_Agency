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
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import helpers.FileHelpers;
import reservationentities.Flight;
import reservationentities.Hotels;
import reservationentities.Taxi;
import reservationentities.TravelPackage;
import travelagency.Reservation;

/** The ReservationTravelPackages class
 * With this class, I enable the customer 
 * to select an existing travel package and make a reservation for it.
 * 
 */
public class ReservationTravelPackages extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private int row ;
	private JPanel panel;
	private JButton btnNewButton;
	private String date;
	private String month;
	private String day;

	
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}



	/**
	 * Create the frame.
	 */
	public ReservationTravelPackages(String names) {
		setTitle("Ku Travel Agency");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1374, 721);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 944, 662);
		contentPane.add(scrollPane);

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textArea.setBounds(20, 78, 356, 516);
		
		
		table = new JTable();

		
       List<String[]> list = FileHelpers.Travelpackagetolist(); 
		
		
		Object[][] dataArray = new Object[list.size()][];
		int rowcount = 1;
		for (int i = 0; i < list.size(); i++) {
			String[] row = list.get(i);
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
				"            ","Package name","General Information", "Hotel","Duration of stay","Airline", "Departure City,", "Arrival City"," Departure Time", " Arrival Time", "Ticket Class","Available Seats","Stopover City","Final Arrival City","Leg 1 Departure Time","Leg 1 Arrival Time","Leg 2 Departure Time","Leg 2 Arrival Time\r\n",
						"Taxi Type", "Taxi Service area","distance","Total Price" 
			}
		));
		
		
		

		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		panel.setBounds(964, 11, 386, 662);
		contentPane.add(panel);
		panel.setLayout(null);
		

		
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
		JLabel lblNewLabel = new JLabel("Year");
		lblNewLabel.setBounds(134, 20, 74, 14);
		panel.add(lblNewLabel);
		
        ArrayList<Integer> years = new ArrayList<>();
        years.add(0);
		for(int a =2024; a<2034;a++) {
			years.add(a);
		}
		JComboBox<Integer>  comboBoxyear = new JComboBox<>(years.toArray(new Integer[0]));
		comboBoxyear.setBounds(134, 45, 74, 22);
		comboBoxyear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				String selectedItem = String.valueOf(comboBoxyear.getSelectedItem());
				setDate(selectedItem);
                
			}
		});
		panel.add(comboBoxyear);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setBounds(218, 20, 74, 14);
		panel.add(lblMonth);
		 ArrayList<Integer> months = new ArrayList<>();
			
			for(int a =1; a<13;a++) {
				months.add(a);
			}
		
		JComboBox<Integer>  comboBoxmonth = new JComboBox<>(months.toArray(new Integer[0]));
		comboBoxmonth.setBounds(218, 45, 74, 22);
        comboBoxmonth.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				String selectedItem = String.valueOf(comboBoxmonth.getSelectedItem());
				setMonth(selectedItem);
                
			}
		});
		panel.add(comboBoxmonth);
		
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setBounds(302, 20, 74, 14);
		panel.add(lblDay);
		
		ArrayList<Integer> days = new ArrayList<>();
			
			for(int a =1; a<31;a++) {
				days.add(a);
			}
		JComboBox<Integer>  comboBoxday= new JComboBox<>(days.toArray(new Integer[0]));
		comboBoxday.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedItem = String.valueOf(comboBoxday.getSelectedItem());
				setDay(selectedItem);
			}
		});
		comboBoxday.setBounds(302, 45, 74, 22);
		panel.add(comboBoxday);
		
		btnNewButton = new JButton("Complete Reservation");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String packageName = (String)table.getValueAt(row, 1);        
                String generalInfo = (String)table.getValueAt(row, 2);   
                int durationOfStay =Integer.parseInt((String) table.getValueAt(row, 4));
                double totalPrice =Double.parseDouble((String) table.getValueAt(row, 21)); 
                int rowcount = 0;
                int hotelindex =0;
                int flightindex =0;
                int taxiindex =0;
 
        		for (int i = 0; i < list.size(); i++) {
        			if (rowcount == row) {
        				String[] ha = list.get(rowcount);
        				taxiindex = Integer.parseInt(ha[ha.length-1]);
        				flightindex = Integer.parseInt(ha[ha.length-2]);
        				hotelindex = Integer.parseInt(ha[ha.length-3]);
        			}

        	
        			
        			++rowcount;
        			
        		}

        	   Hotels hotel = Hotels.getHotelbyindex(hotelindex);
               Flight flight = Flight.getFlightyindex(flightindex);
               Taxi taxi = Taxi.getTaxibyindex(taxiindex);

               double m = hotel.getPricePerNight()*durationOfStay + flight.getTicketPrice()+taxi.getBasefare()+ (taxi.getFarePerKm()*hotel.getDistanceToAirport());
               double g = totalPrice -m;
               double rate = ((g)/totalPrice)*100;
                
                
               TravelPackage travelpackage = new TravelPackage(packageName,generalInfo,Hotels.getHotelbyindex(hotelindex),Flight.getFlightyindex(flightindex),Taxi.getTaxibyindex(taxiindex),rate,durationOfStay);
               String[] handm;
               String hour;
               String minute;
                if(travelpackage.getFlight().getArrivalCity()==null) {
                	handm = travelpackage.getFlight().getLeg1departuretime().split(":");
                    hour = handm[0];
                    minute = handm[1];
                }
                else {
                	handm = travelpackage.getFlight().getDepartureTime().split(":");
                    hour = handm[0];
                    minute = handm[1];
                }
                
                
                Reservation.saveReservation(names, 0, 0, null, null, null, travelpackage,date,month,day,hour,minute,"00");
                
                JOptionPane.showMessageDialog(null, "Reservation Created","Message",JOptionPane.INFORMATION_MESSAGE);
			}
			
		});
		
		
		
		btnNewButton.setBounds(78, 605, 250, 46);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Select Date time");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(20, 45, 103, 22);
		panel.add(lblNewLabel_3);
		
		
		
		
		
	}
}
