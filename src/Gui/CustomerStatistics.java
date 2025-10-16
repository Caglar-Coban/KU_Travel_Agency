package Gui;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import travelagency.TravelHistory;
/** The CustomerStatistics class
 * With this class
 *  I enable the customer to see their own custom statistics.
 * 
 */
public class CustomerStatistics extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public CustomerStatistics(String name) {
		List<String[]> p =  TravelHistory.Reservationwithname(name);
		List<String[]> s =  TravelHistory.getCanceledWithName(name);

		double numberofreservation = p.size();
		double totalprice = 0;

		for (String[] t : p ) {
			totalprice += Double.parseDouble(t[2]);
			
		}
		double numberofcanceled = s.size();
		int totalres = p.size()+s.size();
		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 677, 762);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Number Of Reservation  : " + totalres);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel.setBounds(10, 118, 431, 73);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Successful Reservations : " + numberofreservation);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(10, 192, 431, 73);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Canceled Reservations :   " + numberofcanceled );
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_1_1.setBounds(10, 276, 431, 73);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Total Amount Spent ($)  :  " + Math.round(totalprice*10)/10);
		lblNewLabel_1_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_1_2.setBounds(10, 360, 431, 73);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("The statistics of :" + name);
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel_2.setBounds(10, 11, 431, 73);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Reservation Success Rate : %" + (numberofreservation /(numberofreservation+numberofcanceled))*100 );
		lblNewLabel_1_1_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1_2.setBounds(10, 530, 431, 73);
		contentPane.add(lblNewLabel_1_1_2);
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Average Spending per Reservation : " + (Math.round((totalprice)/numberofreservation)*10)/10);
		lblNewLabel_1_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1_1.setBounds(10, 444, 630, 73);
		contentPane.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Cancellation Rate : %" + (numberofcanceled /(numberofreservation+numberofcanceled))*100);
		lblNewLabel_1_1_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1_3.setBounds(10, 606, 343, 73);
		contentPane.add(lblNewLabel_1_1_3);
		lblNewLabel_1_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		
		
		
	}

}
