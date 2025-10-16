package Gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
/** The CustomerPage class
 * Thanks to this class, 
 * I ensure that the customer can access 
 * all the features with the help of buttons in this class.
 * 
 */
public class CustomerPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public CustomerPage(String name) {
		
		setTitle("Ku Travel Agency");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1374, 864);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Travel History");
		btnNewButton_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerTravelHistory frame = new CustomerTravelHistory(name);
				frame.setVisible(true);
				
				
			}
		});
		
		JButton btnNewButton_1_1_1_1_1 = new JButton("Cancel Reservation");
		btnNewButton_1_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnNewButton_1_1_1_1_1.setBounds(1091, 609, 259, 101);
		btnNewButton_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CustomerCancelReservation frame = new CustomerCancelReservation(name);
				frame.setVisible(true);
				
			}
		});
		
		
		
		contentPane.add(btnNewButton_1_1_1_1_1);
		btnNewButton_1_1_1_1.setBounds(1091, 385, 259, 101);
		contentPane.add(btnNewButton_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_2 = new JButton("Cancellation History");
		btnNewButton_1_1_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnNewButton_1_1_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CustomerCancelHistory frame = new CustomerCancelHistory(name);
				frame.setVisible(true);
				
			}
		});
		btnNewButton_1_1_1_1_2.setBounds(1091, 273, 259, 101);
		contentPane.add(btnNewButton_1_1_1_1_2);

		
        
		JLabel lblNewLabel = new JLabel("Welcome To KU Travel Agency " + name );
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 39));
		lblNewLabel.setBounds(10, 11, 1340, 71);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1_1 = new JButton("View Travel packages");
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewTravelPackages frame = new ViewTravelPackages();
				frame.setVisible(true);
			}
		});
		btnNewButton_1_1.setBounds(10, 715, 259, 101);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("View my statistics");
		btnNewButton_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerStatistics frame = new CustomerStatistics(name);
				frame.setVisible(true);
			}
		});
		btnNewButton_1_1_1.setBounds(1091, 721, 259, 101);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_2 = new JButton("Make new Reservation");
		btnNewButton_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnNewButton_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookingPage frame = new BookingPage(name);
				frame.setVisible(true);
				
		
			}
		});
		btnNewButton_1_1_2.setBounds(1091, 497, 259, 101);
		contentPane.add(btnNewButton_1_1_2);
		
		JButton btnNewButton_1_1_3 = new JButton("View Hotels");
		btnNewButton_1_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 41));
		btnNewButton_1_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewHotels vh = new ViewHotels();
				vh.setVisible(true);
			}
		});
		
		btnNewButton_1_1_3.setBounds(10, 267, 259, 101);
		contentPane.add(btnNewButton_1_1_3);
		
		JButton btnNewButton_1_1_4 = new JButton("View Flights");
		btnNewButton_1_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 41));
		btnNewButton_1_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewFlights vh = new ViewFlights();
				vh.setVisible(true);
			}
		});
				
		     
		
		btnNewButton_1_1_4.setBounds(10, 409, 259, 101);
		contentPane.add(btnNewButton_1_1_4);
		
		JButton btnNewButton_1_1_5 = new JButton("View Taxis");
		btnNewButton_1_1_5.setFont(new Font("Times New Roman", Font.PLAIN, 41));
		btnNewButton_1_1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewTaxis vh = new ViewTaxis();
				vh.setVisible(true);
			}
		});
		btnNewButton_1_1_5.setBounds(10, 568, 259, 101);
		contentPane.add(btnNewButton_1_1_5);
		


		JLabel lbl_Background = new JLabel(new ImageIcon(getClass().getResource("CustomerPImage.jpg")));
		lbl_Background.setBounds(-41, -13, 1471, 901);

		contentPane.add(lbl_Background);
		
		
		
	}
}
