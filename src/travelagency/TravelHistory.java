package travelagency;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/** The Travel History class takes data from the appropriate data
 * and turn in to them to table 
 * 
 */
public class TravelHistory {
	
	
	/**
	 * The Reservationwithname method return list of reservation that name have
	 * method take each line with while loop and
	 * its split to parts and check the given name then 
	 * it add it to list if given name equal to that lines name
	 * 
	 * 
	 * @param name The parameter that take name
	 * @return the list of reservations spesified for that name
	 */
	public static List<String[]> Reservationwithname(String name){
    	List<String[]> h = new ArrayList<>(); // the list of all reservation of that name
		String filepath = "logs/ReservationLogs.txt";
		 try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
	            String line;	            
	            while ((line = br.readLine()) != null) {
	            	String[] parts = line.split(";"); //splitting line to a list
	            	if(parts.length ==1) {
	            		break;
	            	}
	                String[] c = new String[parts.length];
	             // if name equals to the name parameter that given then line added to h 
	                if (parts[1].split(":")[1].equals(name)) { 
	                	String p = parts[0].split(":")[1] +":"+parts[0].split(":")[2] +":"+ parts[0].split(":")[3];
            			c[0] =p;

	                	for(int i =2; i < parts.length-2;i++) {
		            		if (parts[i].split(":").length == 1) {
		            		}
		            		else {
		            			String t = parts[i].split(":")[1]; 
			            		c[i-1] =t; 
		            			
		            		}
		            		
		            
		            	}
	                	String l = parts[parts.length-2].split("-")[1];
	                	c[parts.length-3] = l;
	                	
	                	 h.add(c); 	
	                }

	            }
	        } catch (IOException e) {
	            
	        }
		 return h;
    	
    }
	/**
	 * The Reservationwitouthname method return list of all reservations
	 * method take each line with while loop and
	 * its split to parts and add to list 
	 * 
	 * 
	 * @return list of all reservations 
	 *
	 */
    public static List<String[]> Reservationwitouthname(){
    	List<String[]> h = new ArrayList<>(); //list of all reservations
		String filepath = "logs/ReservationLogs.txt";
		 try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
	            String line; 
	            while ((line = br.readLine()) != null) {
	            	String[] parts = line.split(";"); //splitting line to a list
	                String[] c = new String[parts.length];
                        // takes all line and add to list of h
	                	for(int i =0; i < parts.length-2;i++) {
	                		if (parts[i].split(":").length>2) {
	                			String p = parts[i].split(":")[1] +":"+parts[i].split(":")[2] +":"+parts[i].split(":")[3];
	                			c[i] =p;
	                			
	                		}
	                			
	                			
	                	    else if (parts[i].split(":").length == 1) {
		            		}
		            		else {
		            			
		            			String t = parts[i].split(":")[1]; 
			            		c[i] =t; 
		            			
		            		}
		            		
		            
		            	}
	                	String t = parts[parts.length-2].split("-")[1]; 
	            		c[parts.length-2] =t; 
	                	h.add(c);	
	                }
	                
	                

	            }
	        catch (IOException e) {
	            
	        }
		 return h;
    	
    }
    /**
	 * The getCanceledWithName method return list of canceled reservation that name have
	 * method take each line with while loop and
	 * its split to parts and check the given name then 
	 * it add it to list if given name equal to that lines name
	 * 
	 * 
	 * @param name The parameter that take name
	 * @return the list of cancelled reservations spesified for that name
	 */
    public static List<String[]> getCanceledWithName(String name) {
    	String filePath = "logs/Cancellations.txt";
    	List<String[]> h = new ArrayList<>(); // the list of all canceled reservation of that name
    	try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
    		String line;
    		while ((line = br.readLine()) != null) {
    			String[] parts = line.split(";"); // splitting line to list 
    			String[] c = new String[parts.length];
    			// if name equals to the name parameter that given then line added to h 
    			if (parts[1].split(":")[1].equals(name)) {
                	String p = parts[0].split(":")[1] +":"+parts[0].split(":")[2] +":"+parts[0].split(":")[3];
        			c[0] =p;
                	for(int i =2; i < parts.length;i++) {
	            		if (parts[i].split(":").length == 1) {
	            		}
	            		else {
	            			String t = parts[i].split(":")[1]; 
		            		c[i-1] =t; 
	            			
	            		}
	            		
	            
	            	}
                	h.add(c); 	
                }
	               	
                }
    		return h;
    		}
    		
    	
    	catch (IOException e) {
            System.err.println("An error ");
    }
    	return null;
    }
    /**
	 * The getCanceledWithoutName name method return list of all cancelled reservations
	 * method take each line with while loop and
	 * its split to parts and add to list 
	 * 
	 * 
	 * @return list of all cancelled reservations 
	 *
	 */
    public static List<String[]>  getCanceledWithoutName() {
    	List<String[]> h = new ArrayList<>(); // list of all canceled reservations
		String filepath = "logs/Cancellations.txt";
		 try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
	            String line; 
	            while ((line = br.readLine()) != null) {
	            	String[] parts = line.split(";");  // splitting line to list 
	                String[] c = new String[parts.length];
	             // takes all line and add to list of h
	                String p = parts[0].split(":")[1] +":"+parts[0].split(":")[2] +":"+ parts[0].split(":")[3];
        			c[0] =p;
        			
	                	for(int i =1; i < parts.length-2;i++) {
	                		String t = parts[i].split(":")[1]; 
		            		c[i] =t; 
		            		
		            	}
	                	String s = parts[parts.length-2].split(":")[1]; 
	            		c[parts.length-1] =s;
	                	h.add(c);	
	                }
	                
	                

	            }
	        catch (IOException e) {
	            
	        }
		 return h;
    	
    }

}
