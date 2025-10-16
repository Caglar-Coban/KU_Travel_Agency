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
import reservationentities.Taxi;
import travelagency.Reservation;

/** The ReservationTaxis class
 * With this class, I enable the customer 
 * to select an existing taxis and make a reservation for it.
 * 
 */
public class ReservationTaxis extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private int row ;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private String date;
	private String month;
	private String day;
	private String hour;
	private String minute;
	
	
	
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

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getMinute() {
		return minute;
	}

	public void setMinute(String minute) {
		this.minute = minute;
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
	public ReservationTaxis(String names) {
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
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		textArea.setBounds(20, 174, 356, 197);
		
		
		table = new JTable();

		
		List<String[]> list = FileHelpers.SourceToList("data/FinalKU_Travel_Agency_Dataset_Taxis.csv"); 
		
		
		Object[][] dataArray = new Object[list.size()][7];
		int rowcount = 1;
		for (int i = 0; i < list.size(); i++) {
			String[] row = list.get(i);
			Object[] newRow = new Object[7];
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
				"            ", "City", "Taxi Type", "Available Taxis", "Base Fare ($)", "Per KM Rate ($)"
			}
		));
		
		
		

		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		panel.setBounds(964, 11, 386, 471);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Select Distance");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(10, 11, 155, 32);
		panel.add(lblNewLabel);
		
		ArrayList<Integer> items = new ArrayList<>();
		
		for(int a =0; a<50;a++) {
			items.add(a);
		}
		JComboBox<Integer>  comboBox = new JComboBox<>(items.toArray(new Integer[0]));

		
           
		comboBox.setBounds(175, 11, 201, 32);
		
		panel.add(comboBox);
		
		table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	
                setRow( table.rowAtPoint(e.getPoint()));
                Object name = table.getValueAt(row, 1);
                Object city = table.getValueAt(row, 2);
                Object roomtype = table.getValueAt(row, 3);
                Object arooms = table.getValueAt(row, 4);
                Object priceper = table.getValueAt(row, 5);

                textArea.setText("Taxi Informations \n");
                textArea.append("City: " + name + "\n");
                textArea.append("Taxi Type: " + city+ "\n");
                textArea.append("Available Taxis:" + roomtype+ "\n");
                textArea.append("Base Fare ($): " + arooms+ "\n");
                textArea.append("Per KM Rate ($): " + priceper+ "\n");

            }
        });
		
       comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object name = table.getValueAt(row, 1);
                Object city = table.getValueAt(row, 2);
                Object roomtype = table.getValueAt(row, 3);
                double arooms = Double.parseDouble((String)table.getValueAt(row, 4));
                double priceper = Double.parseDouble((String) table.getValueAt(row, 5));
                textArea.setText("Taxi Informations \n");
                textArea.append("City: " + name + "\n");
                textArea.append("Taxi Type: " + city+ "\n");
                textArea.append("Available Taxis:" + roomtype+ "\n");
                textArea.append("Base Fare ($): " + arooms+ "\n");
                textArea.append("Per KM Rate ($): " + priceper+ "\n");
                
				int selectedItem = (Integer) comboBox.getSelectedItem();
				textArea.append("\n");
                textArea.append("Total Cost: " + (arooms+(priceper*selectedItem)*1.2) + "\n");
                
			}
		});
		
		panel.add(textArea);
		
		ArrayList<Integer> years = new ArrayList<>();
        years.add(0);
		for(int a =2024; a<2034;a++) {
			years.add(a);
		}
		JComboBox<Integer>  comboBoxyear = new JComboBox<>(years.toArray(new Integer[0]));
		comboBoxyear.setBounds(119, 67, 74, 22);
		comboBoxyear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				String selectedItem = String.valueOf(comboBoxyear.getSelectedItem());
				setDate(selectedItem);
                
			}
		});
		panel.add(comboBoxyear);
		
		JLabel lblNewLabel_1 = new JLabel("Year");
		lblNewLabel_1.setBounds(123, 53, 74, 14);
		panel.add(lblNewLabel_1);
		
		ArrayList<Integer> months = new ArrayList<>();
		
		for(int a =1; a<13;a++) {
			months.add(a);
		}
	
	    JComboBox<Integer>  comboBoxmonth = new JComboBox<>(months.toArray(new Integer[0]));
	    comboBoxmonth.setBounds(203, 67, 74, 22);
        comboBoxmonth.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {

			String selectedItem = String.valueOf(comboBoxmonth.getSelectedItem());
			setMonth(selectedItem);
            
		 }
	     });
	    panel.add(comboBoxmonth);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setBounds(207, 53, 74, 14);
		panel.add(lblMonth);
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
	   comboBoxday.setBounds(287, 67, 74, 22);
	    panel.add(comboBoxday);
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setBounds(291, 53, 74, 14);
		panel.add(lblDay);
		
		JLabel lblNewLabel_3 = new JLabel("Select Date");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(10, 66, 103, 22);
		panel.add(lblNewLabel_3);
		
		JLabel lblSelectHour = new JLabel("Select Hour");
		lblSelectHour.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSelectHour.setBounds(10, 100, 99, 26);
		panel.add(lblSelectHour);
         ArrayList<Integer> hours = new ArrayList<>();
		
		for(int a =1; a<24;a++) {
			hours.add(a);
		}
		
		JComboBox<Integer> comboBoxhour = new JComboBox<>(hours.toArray(new Integer[0]));
		 comboBoxhour.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String selectedItem = String.valueOf(comboBoxhour.getSelectedItem());
					setHour(selectedItem);
				}
			    });
		comboBoxhour.setBounds(119, 106, 121, 19);
		panel.add(comboBoxhour);
		
		JLabel lblSelectMinute = new JLabel("Select Minute");
		lblSelectMinute.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSelectMinute.setBounds(10, 137, 99, 26);
		panel.add(lblSelectMinute);
		ArrayList<Integer> minutes = new ArrayList<>();
		for(int a =1; a<60;a++) {
			minutes.add(a);
		}
		
		JComboBox<Integer> comboBoxminute = new JComboBox<>(minutes.toArray(new Integer[0]));
		comboBoxminute.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String selectedItem = String.valueOf(comboBoxminute.getSelectedItem());
					setMinute(selectedItem);
				}
			    });
		comboBoxminute.setBounds(119, 143, 121, 19);
		panel.add(comboBoxminute);
		
		btnNewButton = new JButton("Complete Reservation");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = (String) table.getValueAt(row, 1);
                String city = (String) table.getValueAt(row, 2);
                int roomtype = Integer.parseInt((String) table.getValueAt(row, 3));
                double arooms = Double.parseDouble((String)table.getValueAt(row, 4));
                double priceper = Double.parseDouble((String) table.getValueAt(row, 5));

                int selectedItem = (Integer) comboBox.getSelectedItem();
                
                Taxi taxi = new Taxi(name,city,roomtype,arooms,priceper);
                if(taxi.isavailable()) {
                	
                
                Reservation.saveReservation(names, 0, selectedItem, null,taxi, null, null,date,month,day,hour,minute,"00");
                
                JOptionPane.showMessageDialog(null, "Reservation Created","Message",JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                	JOptionPane.showMessageDialog(null, "taxi is not available","Message",JOptionPane.INFORMATION_MESSAGE);
                }
			}
			
		});
		btnNewButton.setBounds(66, 382, 250, 46);
		panel.add(btnNewButton);
		
		
		
	}
}
