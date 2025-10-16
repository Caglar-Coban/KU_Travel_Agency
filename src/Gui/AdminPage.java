package Gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
/** The AdmingPage class
 * With this class, I create an admin page  
 * and allow the admin to use admin privileges.
 */
public class AdminPage extends JFrame {

	
	private JPanel contentPane;

	
	/**
	 * Create the frame.
	 */
	public AdminPage(String name) {
		setTitle("Ku Travel Agency");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1374, 918);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome " + name);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 52));
		lblNewLabel.setBounds(10, 35, 674, 87);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1360, 881);
		contentPane.add(panel);
		
		JButton btnCreateNewTravel = new JButton("Create New Travel Package");
		btnCreateNewTravel.setBounds(0, 151, 589, 138);
		btnCreateNewTravel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
		btnCreateNewTravel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CreatTravelPackage ctp = new CreatTravelPackage();
				ctp.setVisible(true);
				
				
			}
		});
		panel.setLayout(null);
		
		JButton btnViewAllCancellations = new JButton("View All Cancellations");
		btnViewAllCancellations.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		btnViewAllCancellations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				ViewAllCancellations frame = new ViewAllCancellations();
				frame.setVisible(true);
			}
		});
		btnViewAllCancellations.setBounds(735, 62, 605, 108);
		panel.add(btnViewAllCancellations);
		
		panel.add(btnCreateNewTravel);
		
		JButton btnView = new JButton("View All Reservations");
		btnView.setBounds(735, 181, 605, 108);
		btnView.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				ViewAllReservations frame = new ViewAllReservations();
				frame.setVisible(true);
			}
		});
		panel.add(btnView);
		
		JButton btnDeleteNewTravel = new JButton("Edit Travel Package");
		btnDeleteNewTravel.setBounds(0, 300, 589, 138);
		btnDeleteNewTravel.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		btnDeleteNewTravel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				EditTravelPackage frame = new EditTravelPackage();
				frame.setVisible(true);
			}
		});
		panel.add(btnDeleteNewTravel);
		
		JButton btnEditAllReservations = new JButton("Edit Specific Users Reservations");
		btnEditAllReservations.setBounds(735, 300, 605, 138);
		btnEditAllReservations.setFont(new Font("Times New Roman", Font.PLAIN, 38));
		btnEditAllReservations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CreateDeleteReservations frame = new CreateDeleteReservations();
				frame.setVisible(true);
				
			}
		});
		panel.add(btnEditAllReservations);
		
		JButton btnNewButton = new JButton("Delete Travel Package");
		btnNewButton.setBounds(0, 449, 589, 138);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DeleteTravelPackage frame = new DeleteTravelPackage();
				frame.setVisible(true);
				
				;
			}
		});
		panel.add(btnNewButton);
		
		JButton btnViewStatistics = new JButton("View Statistics");
		btnViewStatistics.setBounds(735, 449, 605, 138);
		btnViewStatistics.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		btnViewStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminStatisticsPage frame = new AdminStatisticsPage();
				frame.setVisible(true);
			}
		});
		panel.add(btnViewStatistics);
		
		JButton btnViewTravelpackages = new JButton("View TravelPackages");
		btnViewTravelpackages.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		btnViewTravelpackages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewTravelPackages frame = new ViewTravelPackages();
				frame.setVisible(true);
			}
		});
		btnViewTravelpackages.setBounds(0, 598, 589, 125);
		panel.add(btnViewTravelpackages);
		
		JButton btnViewHotels = new JButton("View Hotels");
		btnViewHotels.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		btnViewHotels.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				ViewHotels vh = new ViewHotels();
				vh.setVisible(true);												
			}
		});
		btnViewHotels.setBounds(0, 734, 589, 125);
		panel.add(btnViewHotels);
		
		JButton btnViewTaxis = new JButton("View Taxis");
		btnViewTaxis.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		btnViewTaxis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewTaxis vh = new ViewTaxis();
				vh.setVisible(true);
			}
		});
		btnViewTaxis.setBounds(735, 598, 605, 125);
		panel.add(btnViewTaxis);
		
		JButton btnViewFlights = new JButton("View Flights");
		btnViewFlights.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		btnViewFlights.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewFlights vh = new ViewFlights();
				vh.setVisible(true);
			}
		});
		btnViewFlights.setBounds(735, 734, 605, 125);
		panel.add(btnViewFlights);
		

		JLabel lbl_Background = new JLabel(new ImageIcon(getClass().getResource("AdminImage.png")));
		lbl_Background.setBounds(-4100, -200, 5760, 3840);

		panel.add(lbl_Background);
	}
}
