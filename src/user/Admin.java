package user;

/**The Admin class is admin in the system
 * 
 * 
 */
public class Admin implements Loggable {
	private String username ;
	private String password;
	private String type;
	private int id;
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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



	public Admin(String username,String password,int id) {
		this.username = username;
		this.password = password;
		this.type = "Admin";
		this.id = id;

	}




}
