package Gui;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import helpers.FileHelpers;
import user.Loggable;
/** The CreateDeleteReservations class
 * With this class, 
 * I enable the admin to see all users and 
 * access their private pages by clicking on them from the table object.
 */
public class CreateDeleteReservations extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private int row ;
	
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}
	

	/**
	 * Create the frame.
	 */
	public CreateDeleteReservations() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 464, 631);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 65, 430, 518);
		contentPane.add(scrollPane);
		
		table = new JTable();

		
		List<Loggable> list = FileHelpers.ReadLoggable(); 
		
		
		Object[][] dataArray = new Object[list.size()][];
		int rowcount = 1;
		for(int i =0; i<list.size();i++) {
			String[] newrow = new  String[6];
			if(list.get(i).getType().equals("Customer")) {
				String name = list.get(i).getUsername();
			    newrow[0] = String.valueOf(rowcount);	
			    newrow[1] = name;;



			    

			    ++rowcount;
			    dataArray[i] = newrow;			
			}
		}
		table.setModel(new DefaultTableModel(
			dataArray,
			new String[] {
				"            ", "User Name", 
			}
		));
		
		scrollPane.setViewportView(table);
		
		
		table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	setRow( table.rowAtPoint(e.getPoint()));
            	String names = (String)table.getValueAt(row, 1);
            	
            	CustomerPage c = new CustomerPage(names);
            	c.setVisible(true);
            	dispose();
                
            }
        });
		
		lblNewLabel = new JLabel("Click For the Go to that User Page and Edit Reservation");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 11, 430, 43);
		contentPane.add(lblNewLabel);
	}
}

