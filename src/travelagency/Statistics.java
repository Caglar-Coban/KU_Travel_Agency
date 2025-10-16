package travelagency;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *  The Statistics class calculate agency's earning , users payments
 *  users cost to the agency and earning of each entitie brand
 */
public class Statistics {
	
	/**The CalculateTotalEarnings method is calculating each brands earning
	 * take data from the ReservationLogs.txt and returns is List of lists
	 * 
	 * 
	 * @return list of all hotel flight taxis brands and their earnings
	 */
	public static List<List<String[]>> CalculateTotalEarnings(){
    	String fileName = "logs/ReservationLogs.txt";
        List<List<String[]>> allEntities = new ArrayList<>(); // list of all brands and their earnings
        
        Map<String, Double> hotelMap = new HashMap<>(); // Map of hotel brands and earnings
        Map<String, Double> flightMap = new HashMap<>(); // Map of flight brands and earning
        Map<String, Double> taxiMap = new HashMap<>(); // Map of taxi city and types and earnings

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
 
                String type = parts[2].split(":")[1];


             // checking reservation type
                if (type.equals("Taxi Booking")) {
                	double price = Double.parseDouble(parts[3].split(":")[1]);
                    String details = parts[5].split("-")[1];
                    String[] detailParts = details.split("_");
                    String taxiType = detailParts[0].split(":")[1];
                    String taxiCity = detailParts[1].split(":")[1];
                    String taxinifo  = taxiType + " " + taxiCity;
                    // checking that taxi is already exist or not
                    if (taxiMap.containsKey(taxinifo )) {
                        double currentPrice = taxiMap.get(taxinifo );
                        taxiMap.put(taxinifo , currentPrice + price);  // if exists add the price
                    } 
                    else {
                       
                        taxiMap.put(taxinifo , price); // if not put taxi to the map
                    }
                    

                } 
             // checking reservation type
                if (type.equals("Flight Booking")) {
                	double price = Double.parseDouble(parts[3].split(":")[1]);
                    String details = parts[5].split("-", 2)[1];
                    String[] detailParts = details.split("_");
                    String airline = detailParts[0].split(":")[1];
                    // checking that flight is already exist or not
                    if (flightMap.containsKey(airline)) {          
                        double currentPrice = flightMap.get(airline);
                        flightMap.put(airline, currentPrice + price);  // if exists add the price
                    } 
                    else {                        
                        flightMap.put(airline, price); // if not put flight to the map
                    }

                }
             // checking reservation type
                if (type.equals("Hotel Reservation")) {
                	double price = Double.parseDouble(parts[3].split(":")[1]);
                    String details = parts[5].split("-")[1];
                    String[] detailParts = details.split("_");
                    String hotelName = detailParts[0].split(":")[1];
                    // checking that hotel is already exist or not
                    if (hotelMap.containsKey(hotelName)) {
                        double currentPrice = hotelMap.get(hotelName);
                        hotelMap.put(hotelName, currentPrice + price);  // if exists add the price
                    } 
                    else {
                        hotelMap.put(hotelName, price); // if not put hotel to the map
                    }

                }
             // checking reservation type
                if (type.equals("TravelPackage booking")) {

                    String details = parts[5].split("-")[1];
                    String[] detailParts = details.split("_");

               
                    String hotelName = detailParts[2].split(":")[1]; 
                    String airline = detailParts[3].split(":")[1]; 
                    String taxiType = detailParts[5].split(":")[1]; 
                    String taxiCity = detailParts[4].split(":")[1]; 
                    String taxinifo = taxiType + " " + taxiCity;
                    double hotelprice = Double.parseDouble(detailParts[6].split(":")[1]); // the hotel price in the package
                    double flightprice = Double.parseDouble(detailParts[7].split(":")[1]); // the flight price in the package
                    double taxiprice = Double.parseDouble(detailParts[8].split(":")[1]); // the taxi price in the package
                    // checking that flight is already exist or not
                    if (flightMap.containsKey(airline)) {          
                        double currentPrice = flightMap.get(airline);
                        flightMap.put(airline, currentPrice + flightprice);  // if exists add the price
                    } 
                    else {                        
                        flightMap.put(airline, flightprice); // if not put flight to the map
                    }
                    
                   // checking that hotel is already exist or not
                    if (hotelMap.containsKey(hotelName)) {
                    	
                        double currentPrice = hotelMap.get(hotelName);
                        hotelMap.put(hotelName, currentPrice + hotelprice);  // if exists add the price
                    } 
                    else {
                    	
                    	
                        hotelMap.put(hotelName, hotelprice); // if not put hotel to the map
                    }
                    // checking that taxi is already exist or not
                    if (taxiMap.containsKey(taxinifo )) {

                        double currentPrice = taxiMap.get(taxinifo );
                        taxiMap.put(taxinifo , currentPrice + taxiprice); // if exists add the price
                    } 
                    else {
                        
                        taxiMap.put(taxinifo , taxiprice);  // if not put taxi to the map
                    }
                    
                }
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        
        List<String[]> taxis = new ArrayList<>(); // the list of taxis 
        List<String[]> hotels = new ArrayList<>(); // the list of hotels
        List<String[]> flights = new ArrayList<>(); // the list of flights 
        // taking all key set and putting brand name to list then putting total price
        for (String hotelName : hotelMap.keySet()) {
            String[] hotelData = new String[2];
            hotelData[0] = hotelName;
            hotelData[1] = String.valueOf(hotelMap.get(hotelName));
            
            hotels.add(hotelData);
            
        }
     // taking all key set and putting brand name to list then putting total price
        for (String airline : flightMap.keySet()) {
            String[] flightData = new String[2];
            flightData[0] = airline;
            flightData[1] = String.valueOf(flightMap.get(airline));
            
            flights.add(flightData);
            
        }
     // taking all key set and putting brand name to list then putting total price
        for (String key : taxiMap.keySet()) {
            String[] taxiData = new String[2];
            taxiData[0] = key;
            taxiData[1] = String.valueOf(taxiMap.get(key));
            
            taxis.add(taxiData);
            
        }
        
        allEntities.add(hotels);
        allEntities.add(flights);
        allEntities.add(taxis);

        return allEntities;
    }
	/** The CalculateUserscosts method that takes username and according to that username
	 * calculates the cost of agency made for that user from taking data Payments.txt
	 * 
	 * @param name of the username 
	 * @return double array that contains users flight,hotel,taxi,travelpackage agency spending
	 */
    public static double[] CalculateUsercosts(String name) {
    	double[] total = new double[4];
    	String fileName = "logs/Payments.txt";
    	double flightpay = 0.0;
    	double hotelpay = 0.0;
    	double taxipay = 0.0;
    	double travelpay = 0.0;
    	
    	
    	try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int linenumber = 0;
            while ((line = reader.readLine()) != null) {
            	String[] parts = line.split(";");
            	if(parts.length ==1) {
            		break;
            	}
            	//checking for the name
            	if(parts[1].split(":")[1].equals(name)) {
            		//checking for the type of the reservation
            		if(parts[3].split(":")[1].equals("TravelPackage booking")) {
                		
                		travelpay += Double.parseDouble(parts[5].split(":")[1]);
                	}
                    if(parts[3].split(":")[1].equals("Flight Booking")) {
                		
                		flightpay += Double.parseDouble(parts[5].split(":")[1]);
                	}
                    if(parts[3].split(":")[1].equals("Hotel Reservation")) {
                		
                    	hotelpay  += Double.parseDouble(parts[5].split(":")[1]);
                	}
                    if(parts[3].split(":")[1].equals("Taxi Booking")) {
                		
                    	taxipay += Double.parseDouble(parts[5].split(":")[1]);
                	}
            	}     	        	
            }            	
    }
    	catch (IOException e) {
		    e.printStackTrace();
		}
    	total[0] = flightpay;
    	total[1] = hotelpay;
    	total[2] = taxipay;
    	total[3] = travelpay;
    	return total;
    }
    /** The CalculateUserfrompayment method that takes username and according to that username
	 * calculates the cost of agency made for that user from taking data Payments.txt
	 * 
	 * @param name of the username 
	 * @return double array that contains users flight,hotel,taxi,travelpackage spendings
	 */
    public static double[] CalculateUserfrompayment(String name) {
    	double[] total = new double[4];
    	String fileName = "logs/Payments.txt";
    	double flightpay = 0.0;
    	double hotelpay = 0.0;
    	double taxipay = 0.0;
    	double travelpay = 0.0;
    	
    	
    	try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
            	String[] parts = line.split(";");
            	if(parts.length ==1) {
            		break;
            	}
            	//checking for the name
            	if(parts[1].split(":")[1].equals(name)) {
            		//checking for the type of the reservation
            		if(parts[3].split(":")[1].equals("TravelPackage booking")) {
                		travelpay += Double.parseDouble(parts[2].split(":")[1]);
                	}
                    if(parts[3].split(":")[1].equals("Flight Booking")) {
                		
                		flightpay += Double.parseDouble(parts[2].split(":")[1]);
                	}
                    if(parts[3].split(":")[1].equals("Hotel Reservation")) {
                		
                    	hotelpay += Double.parseDouble(parts[2].split(":")[1]);
                	}
                    if(parts[3].split(":")[1].equals("Taxi Booking")) {
                		
                    	taxipay += Double.parseDouble(parts[2].split(":")[1]);
                	}
            	}	
            }
    }
    	catch (IOException e) {
		    e.printStackTrace();
		}
    	total[0] = flightpay;
    	total[1] = hotelpay;
    	total[2] = taxipay;
    	total[3] = travelpay;	
    	return total;
    }
    /** The CalculateUserscosts method 
	 * calculates the cost of agency made for that all from taking data Payments.txt
	 * 
	 * 
	 * @return double array that  flight,hotel,taxi,travelpackage agency spending for all users
	 */
    public static double[] CalculateTotalcosts() {

    	double[] total = new double[4];
    	String fileName = "logs/Payments.txt";
    	double flightpay = 0.0;
    	double hotelpay = 0.0;
    	double taxipay = 0.0;
    	double travelpay = 0.0;
    	
    	
    	try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int linenumber = 0;
            while ((line = reader.readLine()) != null) {
            	String[] parts = line.split(";");
            	if(parts.length ==1) {
            		break;
            	}
            	//checking for the type of the reservation
            	if(parts[3].split(":")[1].equals("TravelPackage booking")) {
            		
            		travelpay += Double.parseDouble(parts[5].split(":")[1]);
            	}
                if(parts[3].split(":")[1].equals("Flight Booking")) {
            		
            		flightpay += Double.parseDouble(parts[5].split(":")[1]);
            	}
                if(parts[3].split(":")[1].equals("Hotel Reservation")) {
            		
                	hotelpay  += Double.parseDouble(parts[5].split(":")[1]);
            	}
                if(parts[3].split(":")[1].equals("Taxi Booking")) {
            		
                	taxipay += Double.parseDouble(parts[5].split(":")[1]);
            	}

            	
            	
            }
            
    	
    }
    	catch (IOException e) {
		    e.printStackTrace();
		}
    	total[0] = flightpay;
    	total[1] = hotelpay;
    	total[2] = taxipay;
    	total[3] = travelpay;
    			 
    	
    	
    	return total;

    }
    /** The CalculateUserscosts method 
	 * calculates the payments taken by agency made for that all from taking data Payments.txt
	 * 
	 * 
	 * @return double array that  flight,hotel,taxi,travelpackage user spending for all users
	 */
    public static double[] CalculateTotalfrompayment() {
    	double[] total = new double[4];
    	String fileName = "logs/Payments.txt";
    	double flightpay = 0.0;
    	double hotelpay = 0.0;
    	double taxipay = 0.0;
    	double travelpay = 0.0;
    	
    	
    	try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
            	String[] parts = line.split(";");
            	if(parts.length ==1) {
            		break;
            	}
            	//checking for the type of the reservation
            	if(parts[3].split(":")[1].equals("TravelPackage booking")) {
            		
            		travelpay += Double.parseDouble(parts[2].split(":")[1]);
            	}
                if(parts[3].split(":")[1].equals("Flight Booking")) {
            		
            		flightpay += Double.parseDouble(parts[2].split(":")[1]);
            	}
                if(parts[3].split(":")[1].equals("Hotel Reservation")) {
            		
                	hotelpay += Double.parseDouble(parts[2].split(":")[1]);
            	}
                if(parts[3].split(":")[1].equals("Taxi Booking")) {
            		
                	taxipay += Double.parseDouble(parts[2].split(":")[1]);
            	}       	
            }
    }
    	catch (IOException e) {
		    e.printStackTrace();
		}
    	total[0] = flightpay;
    	total[1] = hotelpay;
    	total[2] = taxipay;
    	total[3] = travelpay;	
    	return total;
    }

    
 
}
