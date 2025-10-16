package Gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import helpers.FileHelpers;
import user.Customer;
import user.Loggable;
/**The LoginPage Class
 * With this class, I create a login page and get the 
 * username and password from the person who will log in and 
 * direct the person to either the customer page or the admin page.
 */
public class LoginPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField Usernamefield;
	private JLabel lblNewLabel;

	

	/**
	 * Create the frame.
	 */
	public LoginPage() {
		setTitle("Ku Travel Agency");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1374, 864);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		
		passwordField = new JPasswordField();
		passwordField.setBounds(496, 395, 368, 46);
		contentPane.add(passwordField);
		
		Usernamefield = new JTextField();
		Usernamefield.setBounds(496, 338, 368, 46);
		contentPane.add(Usernamefield);
		Usernamefield.setColumns(10);
		
		lblNewLabel = new JLabel(" KU Travel Agency");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 38));
		lblNewLabel.setBounds(525, 207, 309, 102);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("     Welcome To");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 38));
		lblNewLabel_1.setBounds(525, 168, 309, 67);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(" User Name:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(356, 338, 130, 46);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel(" Password:");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_2_1.setBounds(356, 395, 130, 46);
		contentPane.add(lblNewLabel_2_1);
		
		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnSignUp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = Usernamefield.getText();
                String password = new String(passwordField.getPassword());
                ArrayList<Loggable> l = FileHelpers.ReadLoggable();
                boolean signupable = true;
                for(Loggable a: l) {
                	if(a.getUsername().equals(username)) {
                		JOptionPane.showMessageDialog(null, "Username already exist","Message",JOptionPane.INFORMATION_MESSAGE);
                		signupable = false;
                		break;
                	}
                }
                if(signupable) {
                	Customer c1 = new Customer(username, password,l.size());
                    c1.saveCustomer();
                    JOptionPane.showMessageDialog(null, "Signed Up, Please login to start","Message",JOptionPane.INFORMATION_MESSAGE);
                }

                
                
				
				
			}
		});
		btnSignUp.setBounds(590, 533, 180, 54);
		contentPane.add(btnSignUp);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Usernamefield.getText().length() == 0 || passwordField.getPassword().length == 0) {
					JOptionPane.showMessageDialog(null, "Username or Password cannot be blank!","Message",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					String uname = Usernamefield.getText();
					char[] pchar = passwordField.getPassword();
					String password = new String(pchar);
					
					ArrayList<Loggable> l = FileHelpers.ReadLoggable();
					
					
					

					
					boolean exsist = false;
					for(int i = 0; i< l.size();i++) {
						if (uname.equals( l.get(i).getUsername()) && password.equals(l.get(i).getPassword()) && l.get(i).getType()== "Customer" ) {
							FileHelpers.saveLogToFile(uname);
							CustomerPage cstmpg = new CustomerPage(uname);
							cstmpg.setVisible(true);
							dispose();
							exsist = true;
							break;
							
						}
						else if (uname.equals( l.get(i).getUsername()) && password.equals(l.get(i).getPassword()) && l.get(i).getType()== "Admin" ) {
							AdminPage admnpg = new AdminPage(uname);
							admnpg.setVisible(true);
							dispose();
							exsist = true;
							break;
							
						}
					
						
					}
					
					
					if (exsist == false) {
						JOptionPane.showMessageDialog(null, "Username or Password is wrong or user does not exist.","Message",JOptionPane.INFORMATION_MESSAGE);
					}					
					
				}
				
			}
		});
		btnLogin.setBounds(590, 468, 180, 54);
		contentPane.add(btnLogin);
		


		JLabel lbl_Background = new JLabel(new ImageIcon(getClass().getResource("LoginImage.jpg")));
		lbl_Background.setBounds(0, -12, 2218, 1000);

		contentPane.add(lbl_Background);
		
		
		
		
		
		
	}
}
