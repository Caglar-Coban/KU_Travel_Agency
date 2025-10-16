package Gui;

import java.awt.Color;
import java.awt.EventQueue;
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
import travelagency.Reservation;

/** The ReservationFlights class
 * With this class, I enable the customer 
 * to select an existing flights and make a reservation for it.
 * 
 */
public class ReservationFlights extends JFrame {

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
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservationFlights frame = new ReservationFlights("name");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReservationFlights(String names) {
		setTitle("Ku Travel Agency");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1374, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 944, 541);
		contentPane.add(scrollPane);

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textArea.setBounds(20, 78, 356, 395);
		
		
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
		
		panel = new JPanel();
		panel.setBounds(964, 11, 386, 541);
		contentPane.add(panel);
		panel.setLayout(null);
		

		
		table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	
                setRow( table.rowAtPoint(e.getPoint()));
                Object flightID = table.getValueAt(row, 1);
                Object airline = table.getValueAt(row, 2);
                Object departureCity = table.getValueAt(row, 3);
                Object arrivalCity = table.getValueAt(row, 4);
                Object departureTime = table.getValueAt(row, 5);
                Object arrivalTime = table.getValueAt(row, 6);
                Object ticketClass = table.getValueAt(row, 7);
                double price = Double.parseDouble((String)table.getValueAt(row, 8));
                Object availableSeats = table.getValueAt(row, 9);  
                Object stopoverCity = table.getValueAt(row, 10);  
                Object finalArrivalCity = table.getValueAt(row, 11);    
                Object leg1DepartureTime = table.getValueAt(row, 12);    
                Object leg1ArrivalTime = table.getValueAt(row, 13);      
                Object leg2DepartureTime = table.getValueAt(row, 14);     
                Object leg2ArrivalTime = table.getValueAt(row, 15); 
                
                textArea.setText("Flight Informations \n");
                textArea.append("Flight ID: " + flightID + "\n");
                textArea.append("Airline: " + airline+ "\n");
                textArea.append("Departure City: " + departureCity+ "\n");
                if((String)table.getValueAt(row, 4) ==""){
                	textArea.append("Flight Type: With Transfer");
                	textArea.append("Stopover City: " + stopoverCity+ "\n");
                    textArea.append("Final Arrival City: " + finalArrivalCity+ "\n");
                    textArea.append("Leg 1 Departure Time: " + leg1DepartureTime+ "\n");
                    textArea.append("Leg 1 Arrival Time: " + leg1ArrivalTime+ "\n");
                    textArea.append("Leg 2 Departure Time: " + leg2DepartureTime+ "\n");
                    textArea.append("Leg 2 Arrival Time: " + leg2ArrivalTime+ "\n");
                	textArea.append("Ticket Class: " + ticketClass+ "\n");
                    textArea.append("Price ($): " + price+ "\n");
                    textArea.append("Available Seats: " +  availableSeats+ "\n");
                	
                	
		         }
                else {
                	textArea.append("Flight Type: Direct");
                	textArea.append("Arrival City: " + arrivalCity+ "\n");
                    textArea.append("Departure Time: " + departureTime+ "\n");
                    textArea.append("Arrival Time: " + arrivalTime+ "\n");
                    textArea.append("Ticket Class: " + ticketClass+ "\n");
                    textArea.append("Price ($): " + price+ "\n");
                    textArea.append("Available Seats: " +  availableSeats+ "\n");
                	
                }
                textArea.append("\n"+"Total Cost: " +  (price*1.2)+ "\n");
  
                
                
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
		
		JLabel lblNewLabel_3 = new JLabel("Select Date time");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(20, 45, 103, 22);
		panel.add(lblNewLabel_3);
		btnNewButton = new JButton("Complete Reservation");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String flightID = (String) table.getValueAt(row, 1);
                String airline = (String)table.getValueAt(row, 2);
                String departureCity = (String)table.getValueAt(row, 3);
                String arrivalCity = (String)table.getValueAt(row, 4);
                String departureTime = (String)table.getValueAt(row, 5);
                String arrivalTime =(String) table.getValueAt(row, 6);
                String ticketClass = (String)table.getValueAt(row, 7);
                double price = Double.parseDouble((String)table.getValueAt(row, 8));
                int availableSeats = Integer.parseInt((String) table.getValueAt(row, 9));  
                String stopoverCity =(String) table.getValueAt(row, 10);  
                String finalArrivalCity = (String)table.getValueAt(row, 11);    
                String leg1DepartureTime = (String)table.getValueAt(row, 12);    
                String leg1ArrivalTime = (String)table.getValueAt(row, 13);      
                String leg2DepartureTime = (String)table.getValueAt(row, 14);     
                String leg2ArrivalTime = (String)table.getValueAt(row, 15); 

                Flight flight;
                String[] handm;
                String hour;
                String minute;
                if((String)table.getValueAt(row, 4) ==""){
                	flight = new Flight(flightID,airline,departureCity,ticketClass,price,availableSeats,stopoverCity,finalArrivalCity,leg1DepartureTime,leg1ArrivalTime,leg2DepartureTime,leg2ArrivalTime);
                	handm = flight.getLeg1departuretime().split(":");
                    hour = handm[0];
                    minute = handm[1];
                }
                else {
                	flight = new Flight(flightID,airline,departureCity,arrivalCity,departureTime,arrivalTime,ticketClass,price,availableSeats);
                	handm = flight.getDepartureTime().split(":");
                    hour = handm[0];
                    minute = handm[1];
                }
                
                
                if(flight.isavailable()) {
                	
                
                Reservation.saveReservation(names, 0, 0, flight, null, null, null,date,month,day,hour,minute,"00");
                
                JOptionPane.showMessageDialog(null, "Reservation Created","Message",JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                	JOptionPane.showMessageDialog(null, "Flight do not have available seats","Message",JOptionPane.INFORMATION_MESSAGE);
                }
			}
			
		});
		btnNewButton.setBounds(66, 484, 250, 46);
		panel.add(btnNewButton);
		
		
		
	}
}
