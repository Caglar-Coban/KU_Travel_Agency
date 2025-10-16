package user;

import helpers.FileHelpers;

/**The Customer class is customers that created with login page 
 * 
 */
public class Customer implements Loggable {
	private String username ;
	private String password;
	private static int customerId = 1;
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String type;
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customer(String username,String password,int id) {
		this.username = username;
		this.password = password;
		this.type = "Customer";
		this.id = id;
		
	}
	
	/** The saveCustomer method that saves customer to the 
	 * Users.txt
	 * 
	 */
	public void saveCustomer() {
		//save customer
		FileHelpers.WriteToCustomer(username, password, type,id);
	}
	
	
	

}
