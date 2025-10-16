package Gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
/** The BookingPage  class
 * With this class, 
 * I can enable the customer to 
 * select a new reservation type and go to its page.
 * 
 */
public class BookingPage extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public BookingPage(String name) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 749, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Make Booking for Hotel");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnNewButton_1.setBounds(228, 59, 278, 38);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				ReservationHotels frame = new ReservationHotels(name);
				frame.setVisible(true);

			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_2 = new JButton("Make Booking for Taxi");
		btnNewButton_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				ReservationTaxis frame = new ReservationTaxis(name);
				frame.setVisible(true);
				
			}
		});
		btnNewButton_1_2.setBounds(228, 118, 278, 38);
		contentPane.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_2_1 = new JButton("Make Booking for Flight");
		btnNewButton_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnNewButton_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				ReservationFlights frame = new ReservationFlights(name);
				frame.setVisible(true);
			}
		});
		btnNewButton_1_2_1.setBounds(228, 179, 278, 38);
		contentPane.add(btnNewButton_1_2_1);
		
		JButton btnNewButton_1_2_1_1 = new JButton("Make Booking for TravelPackage");
		btnNewButton_1_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		
		btnNewButton_1_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				ReservationTravelPackages frame = new ReservationTravelPackages(name);
				frame.setVisible(true);
				
			}
		});
		btnNewButton_1_2_1_1.setBounds(184, 238, 366, 38);
		contentPane.add(btnNewButton_1_2_1_1);
		
		JButton btnNewButton_1_2_1_1_1 = new JButton("Make Booking for Custom Travel Package");
		btnNewButton_1_2_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnNewButton_1_2_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				ReservationCustomTravelPackages frame = new ReservationCustomTravelPackages(name);
				frame.setVisible(true);
			}
		});
		btnNewButton_1_2_1_1_1.setBounds(143, 300, 448, 38);
		contentPane.add(btnNewButton_1_2_1_1_1);
	}
}
