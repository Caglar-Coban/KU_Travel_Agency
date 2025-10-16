package user;
/**The Loggable interface is contains Admin
 * and Customer objects.With this interface, 
 * admin and customer objects can be listed 
 * and evaluated together under the name loggable.
 * 
 */

public interface Loggable {
	String getUsername();
	String getPassword();
	String getType();
	int getId();
	

}
