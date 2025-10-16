package Gui;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import helpers.FileHelpers;
import travelagency.Statistics;
import travelagency.TravelHistory;
import user.Loggable;
/** The AdminStatisticsPage class
 * With this class,
 *  I allow the admin to access 
 *  and view all statistics of the travel agency.
 * 
 */
public class AdminStatisticsPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JPanel panel;
	private JLabel lblOverallSuccessAnd;
	private JLabel lblTotalRevenueGenerated;
	private JLabel lblOverallSuccessAnd_2;
	private JLabel TotalSuccessful;
	private JLabel TotalCanceled;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;

	

	/**
	 * Create the frame.
	 */
	public AdminStatisticsPage() {
		setTitle("Ku Travel Agency");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1374, 864);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 633, 328);
		contentPane.add(scrollPane);
		
		table = new JTable();

		
		List<Loggable> list = FileHelpers.ReadLoggable(); 
		List<String[]> succesfulres = TravelHistory.Reservationwitouthname();
		List<String[]> canceledres = TravelHistory.getCanceledWithoutName();
		double totalres = succesfulres.size()+canceledres.size();
		double succesrate =(succesfulres.size()/totalres)*100;
		double canceledrate =(canceledres.size()/totalres)*100;
		
		double[] payments = Statistics.CalculateTotalfrompayment();
		double flightpayments = payments[0];
		double hotelpayments = payments[1];
		double taxitpayments = payments[2];
		double travelpayments = payments[3];
		
		double[] costs = Statistics.CalculateTotalcosts();
		double flightcosts = costs[0];
		double hotelcosts = costs[1];
		double taxitcosts= costs[2];
		double travelcosts= costs[3];

		System.out.println("hey");
		int rowcount = 1;
		Object[][] dataArray = new Object[list.size()][7];
		for(int i =0; i<list.size();i++) {
			String[] newrow = new  String[6];
			if(list.get(i).getType().equals("Customer")) {
				String name = list.get(i).getUsername();
			    newrow[0] = String.valueOf(rowcount);	
			    newrow[1] = name;
			    newrow[2] = String.valueOf(TravelHistory.Reservationwithname(name).size() +TravelHistory.getCanceledWithName(name).size());
			    double [] moneys = Statistics.CalculateUserfrompayment(name);
			    System.out.println(moneys.length);
			    double money = 0.0;
			    for(int a =0;a<moneys.length;a++) {
			    	money += moneys[a];
			    }

			    
			    newrow[3] = String.valueOf(Math.round(money)*10.0/10.0 );
			    newrow[4]=String.valueOf(TravelHistory.Reservationwithname(name).size() );
			    newrow[5]=String.valueOf(TravelHistory.getCanceledWithName(name).size());
			    ++rowcount;
			    dataArray[i] = newrow;			
			}
		
		}
		table.setModel(new DefaultTableModel(
			dataArray,
			new String[] {
				"            ", "User Name", "Number of Reservations Made", "Total Amount Spent ($)", "Successful Reservations", "Canceled Reservations"
			}
		));
		

		
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		panel.setBounds(10, 350, 633, 466);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblOverallSuccessAnd = new JLabel("Overall Success and Cancellation Rates");
		lblOverallSuccessAnd.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		lblOverallSuccessAnd.setBounds(10, 142, 415, 47);
		panel.add(lblOverallSuccessAnd);
		
		lblTotalRevenueGenerated = new JLabel("Total Revenue Generated ($) : "+(Math.round((flightpayments - flightcosts)+(hotelpayments-hotelcosts)+(taxitpayments-taxitcosts)+(travelpayments-travelcosts))*10.0/10.0) );
		lblTotalRevenueGenerated.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		lblTotalRevenueGenerated.setBounds(10, 271, 436, 52);
		panel.add(lblTotalRevenueGenerated);
		
		lblOverallSuccessAnd_2 = new JLabel("Total Reservations Across All Users : " +(Math.round(((succesfulres.size()+canceledres.size())))));
		lblOverallSuccessAnd_2.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		lblOverallSuccessAnd_2.setBounds(10, 11, 436, 31);
		panel.add(lblOverallSuccessAnd_2);
		System.out.println("hey");
		TotalSuccessful = new JLabel("Successful :" + succesfulres.size());
		TotalSuccessful.setFont(new Font("Tahoma", Font.PLAIN, 22));
		TotalSuccessful.setBounds(10, 53, 167, 31);
		panel.add(TotalSuccessful);
		
		TotalCanceled = new JLabel("Canceled :" + canceledres.size());
		TotalCanceled.setFont(new Font("Tahoma", Font.PLAIN, 22));
		TotalCanceled.setBounds(10, 95, 167, 31);
		panel.add(TotalCanceled);
		
		JLabel OverallSuccessful = new JLabel("Successful : %"+succesrate);
		OverallSuccessful.setFont(new Font("Tahoma", Font.PLAIN, 22));
		OverallSuccessful.setBounds(10, 187, 350, 31);
		panel.add(OverallSuccessful);
		
		JLabel OverallCanceled = new JLabel("Canceled : %"+canceledrate);
		OverallCanceled.setFont(new Font("Tahoma", Font.PLAIN, 22));
		OverallCanceled.setBounds(10, 229, 330, 31);
		panel.add(OverallCanceled);
		
		JLabel lblNewLabel_1_1 = new JLabel("From Flights:" + (Math.round((flightpayments - flightcosts)*10.0/10.0)));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(10, 327, 415, 25);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("From Hotels :" +(Math.round((hotelpayments-hotelcosts)*10.0/10.0)));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(10, 358, 350, 25);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("From Taxis:" + (Math.round((taxitpayments-taxitcosts)*10.0/ 10.0)));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(10, 388, 330, 25);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("From Travel Packages :" + (Math.round((travelpayments-travelcosts)*10.0/10.0)));
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3_1.setBounds(10, 419, 330, 25);
		panel.add(lblNewLabel_1_3_1);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(653, 11, 697, 274);
		contentPane.add(scrollPane_1);
		List<List<String[]>> alldata = Statistics.CalculateTotalEarnings();
		List<String[]> hotels =alldata.get(0);
		List<String[]> flights = alldata.get(1);
		List<String[]> taxis =alldata.get(2);

		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		int rowcount1 = 1;
		Object[][] dataArray1 = new Object[flights.size()][];
		for(int i =0; i<flights.size();i++) {
			String[] newrow = new  String[3];
			newrow[0] = String.valueOf(rowcount1);	
			String[] t = flights.get(i);
			for(int a = 0; a<t.length;a++) {
				newrow[a+1] = t[a];
			}
			
			++rowcount1;
			dataArray1[i] = newrow;
		}
		table_1.setModel(new DefaultTableModel(
			dataArray1,
			new String[] {
				"            ", "Airline", "Earnings"
			}
		));
		

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(653, 296, 697, 253);
		contentPane.add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		
		int rowcount2 = 1;
		Object[][] dataArray2 = new Object[hotels.size()][];
		for(int i =0; i<hotels.size();i++) {
			String[] newrow = new  String[3];
			newrow[0] = String.valueOf(rowcount2);	
			String[] t = hotels.get(i);
			for(int a = 0; a<t.length;a++) {
				newrow[a+1] = t[a];
			}
			
			++rowcount2;
			dataArray2[i] = newrow;
		}
		table_2.setModel(new DefaultTableModel(
			dataArray2,
			new String[] {
				"            ", "Hotel Name", "Earnings"
			}
		));

		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(653, 560, 697, 256);
		contentPane.add(scrollPane_3);
		
		table_3 = new JTable();
		scrollPane_3.setViewportView(table_3);
		
		int rowcount3 = 1;
		Object[][] dataArray3 = new Object[taxis.size()][];
		for(int i =0; i<taxis.size();i++) {
			String[] newrow = new  String[3];
			newrow[0] = String.valueOf(rowcount3);	
			String[] t = taxis.get(i);
			for(int a = 0; a<t.length;a++) {
				newrow[a+1] = t[a];
			}
			
			++rowcount3;
			dataArray3[i] = newrow;
		}
		table_3.setModel(new DefaultTableModel(
			dataArray3,
			new String[] {
				"            ", "Taxi type - City","Earnings"
			}
		));
		

		
		
		
	}
}
