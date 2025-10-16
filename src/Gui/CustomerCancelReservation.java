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

import travelagency.Reservation;
import travelagency.TravelHistory;
/** The CustomerCancelReservation class
 * With this class, I enable the customer 
 * to choose one of their reservations and, 
 * if possible, cancel by writing the reason or not.
 * 
 */
public class CustomerCancelReservation extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField index;
	private JLabel lblReason;
	private JTextField Reason;
	private JTable table;
	private int row ;
	private JPanel panel;
	private JButton btnNewButton;
	private JTextField reason;
	
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	

	/**
	 * Create the frame.
	 */
	public CustomerCancelReservation(String name) {
		setTitle("Ku Travel Agency");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1374, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 944, 471);
		contentPane.add(scrollPane);

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textArea.setBounds(20, 150, 356, 221);
		
		
		table = new JTable();

		
        List<String[]> list = TravelHistory.Reservationwithname(name); 
		
		
		Object[][] dataArray = new Object[list.size()][6];
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
				"            ", "Date - Time", "Reservation Action", "Price","StayDay","Details" 
			}
		));
		
		
		
		

		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		panel.setBounds(964, 11, 386, 471);
		contentPane.add(panel);
		panel.setLayout(null);
		
		ArrayList<Integer> items = new ArrayList<>();
		
		for(int a =0; a<list.size();a++) {
			items.add(a);
		}
		
		table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	
                setRow( table.rowAtPoint(e.getPoint()));
                String datet = (String)table.getValueAt(row, 1);
                Object resa = table.getValueAt(row, 2);
                Object price = table.getValueAt(row, 3);
                Object stayday = table.getValueAt(row, 4);
                Object deta = table.getValueAt(row, 5);
                double remain = Reservation.CancellationTimecalculate(datet);
                if(remain <0) {
					remain = 0.0;
				}
                textArea.setText("Reservation informations \n");
                textArea.append("Date - Time: " + datet + "\n");
                textArea.append("Reservation Action: " + resa+ "\n");
                textArea.append("Price:" + price+ "\n");
                textArea.append("StayDay: " + stayday+ "\n");
                textArea.append("Time Remaining: " + remain + " Hours");
            }
        });
		
		panel.add(textArea);
		
		btnNewButton = new JButton("Cancel Reservation");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String datet = (String)table.getValueAt(row, 1);
				double remain = Reservation.CancellationTimecalculate(datet);
				double late =0.0;
                if(remain <0) {
                	JOptionPane.showMessageDialog(null, "This is old Reservation you cannot cancel it","Message",JOptionPane.INFORMATION_MESSAGE);
				}
                else {
                	if(remain >72.0) {
    					 int result = JOptionPane.showConfirmDialog(null, "Do you accept that a 0% deduction will be applied since the remaining time for the reservation is more than 72 hours?"
    							 ,"Question", JOptionPane.YES_NO_OPTION  );
    					 if (result == JOptionPane.YES_OPTION) {
    						 Reservation.CancelReservation(row+1, name, reason.getText(),late);
    						 JOptionPane.showMessageDialog(null, "Reservation Canceled","Message",JOptionPane.INFORMATION_MESSAGE);
    						 dispose();
    						 CustomerCancelReservation frame = new CustomerCancelReservation(name);
    							frame.setVisible(true);
    					 }
    				}
                if(48.0 < remain && remain <72.0) {
					late = 15.0;
					 int result = JOptionPane.showConfirmDialog(null, "Do you accept that a 15% deduction will be applied since the remaining time for the reservation is less than 72 hours?"
							 ,"Question", JOptionPane.YES_NO_OPTION  );
					 if (result == JOptionPane.YES_OPTION) {
						 Reservation.CancelReservation(row+1, name, reason.getText(),late);
						 JOptionPane.showMessageDialog(null, "Reservation Canceled","Message",JOptionPane.INFORMATION_MESSAGE);
						 dispose();
						 CustomerCancelReservation frame = new CustomerCancelReservation(name);
							frame.setVisible(true);
					 }
				}
                if(remain <48.0) {
					late = 30.0;
					int result = JOptionPane.showConfirmDialog(null, "Do you accept that a 30% deduction will be applied since the remaining time for the reservation is less than 48 hours?"
							 ,"Question", JOptionPane.YES_NO_OPTION  );
					if (result == JOptionPane.YES_OPTION) {
						Reservation.CancelReservation(row+1, name, reason.getText(),late);
						 JOptionPane.showMessageDialog(null, "Reservation Canceled","Message",JOptionPane.INFORMATION_MESSAGE);
						 dispose();
						 CustomerCancelReservation frame = new CustomerCancelReservation(name);
							frame.setVisible(true);
					}
				}
				
				 
                	
                }
			}
			
		});
		btnNewButton.setBounds(66, 382, 250, 46);
		panel.add(btnNewButton);
		
		JLabel lblWriteYourReason = new JLabel("Write Your Reason");
		lblWriteYourReason.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblWriteYourReason.setBounds(20, 11, 251, 26);
		panel.add(lblWriteYourReason);
		
		reason = new JTextField();
		reason.setBounds(20, 48, 356, 32);
		panel.add(reason);
		reason.setColumns(10);
		
	}
}
