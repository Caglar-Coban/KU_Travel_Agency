package helpers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import reservationentities.Flight;
import reservationentities.Hotels;
import reservationentities.Taxi;
import reservationentities.TravelPackage;
import user.Admin;
import user.Customer;
import user.Loggable;
/** The FileHelpers class helps to write users to file or reads user from the file
 * or Read given data and return that data as list
 * 
 */
public class FileHelpers {
	/** The WriteToCustomer method basicaly take parameters and write to user.txt 
	 * file according to that parameters to save user
	 * 
	 * @param s username which taken from user
	 * @param p password which taken from user
	 * @param type Users Type (Customer)
	 * @param id users unique id 
	 */
	public static void WriteToCustomer(String s,String p, String type,int id){
		String filepath = "logs/Users.txt";
		
		try (PrintWriter writer = new PrintWriter(new FileWriter(filepath, true))) {
		    writer.println("Username:"+s +" - " +"Password:" + p +" - " +"Type:"+type +" - "+"Id:" + id); // save user to file

		} catch (IOException e) {
		    e.printStackTrace();
		}

        }
	/**
	 * The ReadLoggable  method reads users file and turn them into
	 * admin or customer object according to their type
	 * after that return a list of all Loggable
	 * 
	 * @return list of admins and customers
	 */
	public static ArrayList<Loggable>  ReadLoggable() {
		String filepath = "logs/Users.txt";
		ArrayList<Loggable> c = new ArrayList<>(); // users list

		
		 try {
			 BufferedReader reader = new BufferedReader(new FileReader(filepath));
	            String line;
	            if((line = reader.readLine()) == null) {
	            	reader.close();
	            	return c;
	            }
	            int id = 0;
	            while ((line = reader.readLine()) != null) {

	                String[] parts = line.split(" - ");
	                String username = parts[0].split(":")[1];
	                String password = parts[1].split(":")[1];
	                String type = parts[2].split(":")[1];
	                String Id = parts[3].split(":")[1];
	                
	                if (type.equals("Customer")) { // check it is customer
	                	c.add(new Customer(username, password,id)); // add to list
	                }
	                if(type.equals("Admin")) { // chech it is admin
	                	c.add(new Admin(username,password,id)); // add to list
	                }
	                id++;
	            
	                
	                
	                
	                
	            }
	        reader.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		 return c;
		
	}
	/** The SourceToList method basicaly takes file path 
	 * and turn data to string array 
	 * 
	 * @param filepath the path of convartable data  
	 * @return List of that datas Lines as a String array
	 */
	public static List<String[]> SourceToList(String filepath){
		
		 List<String[]> h = new ArrayList<>(); // crating array
		 
		 try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
	            String line;
	            
	            
	            br.readLine(); // dont read the first line
	            
	            
	            while ((line = br.readLine()) != null) {
	                
	            	String[] parts = line.split(","); // split data
	                
	                
	                
	                h.add(parts); //add parts to data
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	
		
		return h;
		
	}	
	/** The Travelpackagetolist method turns saved travel package to the
	 * List of String array and return it
	 * 
	 * @return List of String array of saved Travel packages 
	 */
	public static List<String[]> Travelpackagetolist() {
		List<String[]> h = new ArrayList<>();
		String filepath = "Data/FinalKU_Travel_Agency_TravelPackages.txt";
		 try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
	            String line;

	            
	            
	            while ((line = br.readLine()) != null) {
	            	String[] parts = line.split(" - "); // split the line
	                String[] c = new String[parts.length];
	                if(parts.length ==1) { // if line broken then break the loop 
	                	break;
	                }
	                // add all in parts to String array
	            	for(int i =0; i < parts.length;i++) {
	            		String p = parts[i].split(";")[1]; 
	            		c[i] =p; 
	            	}
	                
	                
	                
	                h.add(c); // add string array to List
	            }
	        } catch (IOException e) {
	            
	        }
		
	
		
		return h;
		
	}	
	/** The saveLogToFile method
	 *  Whenever a user logs into the system, 
	 *  it is used to record the logged in user
	 *   name and date in the log file.
	 * 
	 * @param Name username that login
	 */
	public static void saveLogToFile(String Name) {
    	String fileName = "logs/LoginLogs.txt";
    	LocalDateTime now = LocalDateTime.now(); // take system time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // create formatter
        String dateTime = now.format(formatter); // format the system time
    	try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
		    writer.println("Date-Time :"+ dateTime +"; User :"+ Name +"; Action :Login "); // save login action

		} catch (IOException e) {
		    e.printStackTrace();
		}
        
    } 	
	/** The CreatNewTravelPackage method
	 * This method records the incoming travel package object and the 
	 * hotel, taxi, flight indexes used while creating that object to the txt file.
	 * 
	 * @param travelPackage travel package object created by admin
	 * @param hindex Index number depending on where the hotel is located in the given data
	 * @param findex Index number depending on where the flight is located in the given data
	 * @param tindex Index number depending on where the taxi is located in the given data
	 */
	public static void CreatNewTravelPackage(TravelPackage travelPackage,int hindex,int findex,int tindex){
        String filepath = "data/FinalKU_Travel_Agency_TravelPackages.txt";
		
		try (PrintWriter writer = new PrintWriter(new FileWriter(filepath, true))) {
			writer.println("Package name ;" + travelPackage.getName() +" - " 
		            +" General Information ;"+ travelPackage.getGeneralInformation() +" - "
					+" Hotel ;" +travelPackage.getHotels().getName()+ " - " 
		            +" Duration of stay ;" + travelPackage.getStayDay() + " - "
		            + "Airline Option ;" + travelPackage.getFlight().getAirline() + " - "
		            + "Departure City ;" + travelPackage.getFlight().getDepartureCity() + " - "  
		            +"Arrival City ;" + travelPackage.getFlight().getArrivalCity()+ " - "
		            +" Departure Time ;" + travelPackage.getFlight().getDepartureTime() + " - "
		            +" Arrival Time ;" + travelPackage.getFlight().getArrivalTime() + " - "
		            +"Class ;" + travelPackage.getFlight().getTheClass() + " - " 
		            +"Available Seats ;" + travelPackage.getFlight().getAvailableSeats()+ " - "
		            +"Stopover City ;" +travelPackage.getFlight().getStopoverCity()+ " - "
		            +"Final Arrival City ;" +travelPackage.getFlight().getFinalArrivalCity()+ " - "
		            +"Leg 1 Departure Time ;" +travelPackage.getFlight().getLeg1departuretime()+ " - "
		            +"Leg 1 Arrival Time ;" +travelPackage.getFlight().getLeg2ArrivalTime()+ " - "
		            +"Leg 2 Departure Time ;" +travelPackage.getFlight().getLeg2DepartureTime()+ " - "
		            +"Leg 2 Arrival Time ;" +travelPackage.getFlight().getLeg2ArrivalTime()+ " - "
		            +"Taxi Type ;" + travelPackage.getTaxi().getType() + " - "
		            +"Taxi Service area ;" + travelPackage.getTaxi().getCity() + " - "
		            +"distance ;" + travelPackage.getHotels().getDistanceToAirport() + " - "
		            +"Total Fare ;" + travelPackage.TotalCost() + " - "
		            +"Hotel index ;" + hindex + " - "
		            +"Flight index ;" + findex + " - "
		            +"Taxi index ;" + tindex);

			
			
			
		} 
		catch (IOException e) {
		    e.printStackTrace();
		}

        }
	/** The DeleteTravelPackage method 
	 * This method deletes the travelpackage
	 *  that you want to delete by not writing it back to the file.
	 * 
	 * @param index the order in which the travelpackage you want to delete is located
	 */
	public static void DeleteTravelPackage(int index) {
    	String filePath = "data/FinalKU_Travel_Agency_TravelPackages.txt";
    	TravelPackage travelpackage = TravelPackage.getTravelpackagebyindex(index);
    	try {
            
            List<String> lines = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                int id =0;
                while ((line = reader.readLine()) != null) {
                    if (id +1 != index){ //check for the which travelpackage want to be deleted
                        lines.add(line);
                    }
                    id++;
                }
            }


            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                for (String line : lines) { 
                    writer.write(line); // write all travel packages again without deleted
                    writer.newLine();
                }
            }

        } catch (IOException e) {
            System.err.println("An error ");
        }
    }
	/** The EditTravelPackage method
	 * This method is used to create a new travelpackage by taking the travelpackage features 
	 * that the admin wants to change and combining the features that admin did not change.
	 * 
	 * @param id the order in which the travelpackage you want to delete is located
	 * @param name travelpackage objects name
	 * @param description travelpackage objects description
	 * @param commisionrate travelpackage objects comisionrate
	 * @param discount travelpackage objects discount
	 * @param flightindex travelpackage objects Index number depending on where the flight is located in the given data
	 * @param hotelindex travelpackage objects Index number depending on where the hotel is located in the given data
	 * @param taxiindex travelpackage objects Index number depending on where the taxi is located in the given data
	 * @param stayday travelpackage objects duration of stay
	 */
	public static void EditTravelPackage(int id,String name, String description,double commisionrate,double discount,int flightindex,int hotelindex,int taxiindex,int stayday) {
    	String filePath = "data/FinalKU_Travel_Agency_TravelPackages.txt";
    	String modifiedpart ="";
    	try {
            List<String> lines = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                int linenumber = 1;
                while ((line = reader.readLine()) != null) {
                	if (id ==linenumber) {
                		TravelPackage t = TravelPackage.getTravelpackagebyindex(id); // getting old travel package
                		modifiedpart = t.getName() + "- is Edited by admin -" + "Changes["; // create modification for that action
                		int hindex;
                		int findex;
                		int tindex;
                		//checking the changes
                		if(!name.equals("")) {
                			t.setName(name);
                			modifiedpart += ", Name Changed :" + name;
                		}
                		if(!description.equals("")) {
                			t.setGeneralInformation(description);
                			modifiedpart += ", Description Changed :" + description;
                		}
                		if(commisionrate != -1) {
                			t.setCommisionRate(commisionrate);
                			modifiedpart += ", Commision Rate Changed :" + commisionrate;
                		}
                		if(discount != -1) {
                			t.setPrice(t.getPrice()*((100-discount)/100));
                			modifiedpart += ", Discount Changed :" + discount;
                		}
                		if(flightindex != -1) {
                			t.setFlight(Flight.getFlightyindex(flightindex));
                			modifiedpart += ", Flight Changed :" + flightindex ;
                		}
                		if(hotelindex != -1) {
                			t.setHotels(Hotels.getHotelbyindex(hotelindex));
                			modifiedpart += ", Hotel Changed :" + flightindex ;
                		}
                		if(taxiindex != -1) {
                			t.setTaxi(Taxi.getTaxibyindex(taxiindex));
                			modifiedpart += ", Taxi Changed :" + taxiindex ;
                			
                		}
                		if(stayday != -1) {
                			t.setStayDay(stayday);
                			modifiedpart += ", Stayday Changed :" + stayday ;
                		}
                		modifiedpart += " ]";
                		String[] parts = line.split(" - ");
                		if(hotelindex == -1) {
                			hindex= Integer.parseInt(parts[21].split(";")[1]);
                		}
                		else {
                			hindex = hotelindex;
                		}
                		if(flightindex == -1) {
                			findex = Integer.parseInt(parts[22].split(";")[1]);
                		}
                		else {
                			findex = flightindex;
                		}
                		if(taxiindex == -1) {
                			tindex = Integer.parseInt(parts[23].split(";")[1]);
                		}
                		else {
                			tindex = taxiindex;
                		}
                		//adding the changes to that travelpackage
                		lines.add("Package name ;" + t.getName() +" - " 
    		            +" General Information ;"+ t.getGeneralInformation() +" - "
    					+" Hotel ;" +t.getHotels().getName()+ " - " 
    		            +" Duration of stay ;" + t.getStayDay() + " - "
    		            + "Airline Option ;" + t.getFlight().getAirline() + " - "
    		            + "Departure City ;" + t.getFlight().getDepartureCity() + " - "  
    		            +"Arrival City ;" + t.getFlight().getArrivalCity()+ " - "
    		            +" Departure Time ;" + t.getFlight().getDepartureTime() + " - "
    		            +" Arrival Time ;" + t.getFlight().getArrivalTime() + " - "
    		            +"Class ;" + t.getFlight().getTheClass() + " - " 
    		            +"Available Seats ;" + t.getFlight().getAvailableSeats()+ " - "
    		            +"Stopover City ;" +t.getFlight().getStopoverCity()+ " - "
    		            +"Final Arrival City ;" +t.getFlight().getFinalArrivalCity()+ " - "
    		            +"Leg 1 Departure Time ;" +t.getFlight().getLeg1departuretime()+ " - "
    		            +"Leg 1 Arrival Time ;" +t.getFlight().getLeg2ArrivalTime()+ " - "
    		            +"Leg 2 Departure Time ;" +t.getFlight().getLeg2DepartureTime()+ " - "
    		            +"Leg 2 Arrival Time ;" +t.getFlight().getLeg2ArrivalTime()+ " - "
    		            +"Taxi Type ;" + t.getTaxi().getType() + " - "
    		            +"Taxi Service area ;" + t.getTaxi().getCity() + " - "
    		            +"distance ;" + t.getHotels().getDistanceToAirport() + " - "
    		            +"Total Fare ;" + t.TotalCost() + " - "
    		            +"Hotel index ;" + hindex + " - "
    		            +"Flight index ;" + findex + " - "
    		            +"Taxi index ;" + tindex);
                		linenumber++;
                	}
                	else {
                		linenumber++;
                		lines.add(line);
                	}
              
                    

                    
                }

            }
            writemodification(modifiedpart); // save modifications to the logs
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {;
            	
                for (String line : lines) { // write all travelpackages again to file
                    writer.write(line);
                    writer.newLine();
                }
                
                
            }

        } catch (IOException e) {
            System.err.println("An error ");
        }
    	
    	
    	
    }
	/** The writemodification method 
	 * This method is used to save the line it receives to the modification file.
	 * 
	 * @param line ,line to write to modification file
	 */
    public static void writemodification(String line) {
        String filepath = "logs/Modifications.txt";
		
		try (PrintWriter writer = new PrintWriter(new FileWriter(filepath, true))) {
		    writer.println(line); // save to the file

		} catch (IOException e) {
		    e.printStackTrace();
		}
    }
    /**
     * The savePaymentToFile method
     * This method allows the payment received from the user to be recorded
     *  in the file together with the amount 
     *  paid by the user and the expense created by the user.
     * 
     * @param Name Username that do the payment
     * @param price price that taken from user
     * @param cost users cost to the agency
     * @param type Reservation type the users do
     * @param action Reservation action type
     * @param commisionrate the commisionrate which taken from user
     * @param discount discount that applied by the admin
     * @param airline airline brands name that user want to book
     * @param hotelname hotels name that user want to book
     * @param taxitype taxi type that user want to book
     * @param city taxi city that user want to book
     */
    public static void savePaymentToFile(String Name,double price,double cost, String type,String action,double commisionrate,double discount,String airline,String hotelname,String taxitype,String city) {
    	String fileName = "logs/Payments.txt";
    	LocalDateTime now = LocalDateTime.now(); // take system time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss"); // create formatter to format time
        String dateTime = now.format(formatter); // format the system time
        
        
        double newprice = price*((100.0+commisionrate)/100.0)*((100.0-discount)/100.0); //Calculating the amount paid by the user
    	try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
    		//save payment to the file
    		writer.println("Date-Time :"+ dateTime +"; User :"+ Name+"; Payment :"+ newprice +"; Booking type:" +type+"; Action :" + action + "; Cost :" + cost + "; Airline :" + airline + "; Hotelname :" + hotelname + "; Taxi type :" + taxitype + "; Taxi City :" + city);
    		


		} catch (IOException e) {
		    e.printStackTrace();
		}
        
    }
    
    }
	
		
	
	

