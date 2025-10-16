package reservationentities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/** The Flight class is in given data and bookable by user
 * 
 */
public class Flight extends Entities {
	private String flightId;
	private String airline;
	private String departureCity;
	private String arrivalCity;
	private String departureTime;
	private String arrivalTime;
	private double ticketPrice;
	private String ticketClass;
	private int availableSeats;
	private String stopoverCity;
	private String finalArrivalCity;
	private String leg1departuretime;
	private String leg1ArrivalTime;
	private String leg2DepartureTime;
	private String leg2ArrivalTime;
	private boolean isavailable;
	
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getDepartureCity() {
		return departureCity;
	}
	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}
	public String getArrivalCity() {
		return arrivalCity;
	}
	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public String getTheClass() {
		return ticketClass;
	}
	public void setTheClass(String theClass) {
		this.ticketClass = theClass;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public String getStopoverCity() {
		return stopoverCity;
	}
	public void setStopoverCity(String stopoverCity) {
		this.stopoverCity = stopoverCity;
	}
	public String getFinalArrivalCity() {
		return finalArrivalCity;
	}
	public void setFinalArrivalCity(String finalArrivalCity) {
		this.finalArrivalCity = finalArrivalCity;
	}
	public String getLeg1departuretime() {
		return leg1departuretime;
	}
	public void setLeg1departuretime(String leg1departuretime) {
		this.leg1departuretime = leg1departuretime;
	}
	public String getLeg1ArrivalTime() {
		return leg1ArrivalTime;
	}
	public void setLeg1ArrivalTime(String leg1ArrivalTime) {
		this.leg1ArrivalTime = leg1ArrivalTime;
	}
	public String getLeg2DepartureTime() {
		return leg2DepartureTime;
	}
	public void setLeg2DepartureTime(String leg2DepartureTime) {
		this.leg2DepartureTime = leg2DepartureTime;
	}
	public String getLeg2ArrivalTime() {
		return leg2ArrivalTime;
	}
	public void setLeg2ArrivalTime(String leg2ArrivalTime) {
		this.leg2ArrivalTime = leg2ArrivalTime;
	}
	
	// direct flight constructor
	public Flight(String flightId, String airline,String departureCity,String arrivalCity,String departureTime,String arrivalTime,String ticketClass,double price,int availableSeats) {
		this.flightId = flightId;
		this.airline = airline;
		this.departureCity = departureCity;
		this.arrivalCity = arrivalCity;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.ticketClass = ticketClass;
		this.ticketPrice = price;
		this.availableSeats = availableSeats;
		this.isavailable = isavailable();
		
		
	}
	
	// flight constructor with stopover city
	public Flight(String flightId, String airline,String departureCity,String ticketClass,double price,int availableSeats,String stopoverCity, String Finalarrival,String leg1dep,String leg1arr,String leg2dep,String leg2arr ) {
		this.flightId = flightId;
		this.airline = airline;
		this.departureCity = departureCity;
		this.ticketClass = ticketClass;
		this.ticketPrice = price;
		this.availableSeats = availableSeats;
		this.stopoverCity = stopoverCity;
		this.finalArrivalCity = Finalarrival;
		this.leg1departuretime = leg1dep;
		this.leg1ArrivalTime = leg1arr;
		this.leg2DepartureTime = leg2dep;
		this.leg2ArrivalTime = leg2arr;
		this.isavailable = isavailable();
	}
	/** The isavailable method check availabilty for flight
	 * 
	 * @return flight availability 
	 */
	public boolean isavailable() {
		if(getAvailableSeats()>0) {
			return true;
		}
		else {
			return false;
		}
	}
	/** The getFlightyindex method reads data file and return
	 * the flight object according to the index
	 * 
	 * @param index of the flight that in data file
	 * @return flight object 
	 */
	public static Flight getFlightyindex(int index) {
    	String filepath = "data/FinalKU_Travel_Agency_Dataset_Flights.csv";
		

		
		 try {
			 BufferedReader reader = new BufferedReader(new FileReader(filepath));
	            String line;
	            
	           
	            int id = 1;
	            while ((line = reader.readLine()) != null) {
	            	if (id == index+1) {
	            		
	            	

	                String[] parts = line.split(",");
	                
	                
	                String FlightId = parts[0];
	                String Airline = parts[1];
	                String DeparatureCity = parts[2];
	                String ArrivalCity = parts[3];
	                String DepartureTime = parts[4];
	                String ArrivalTime = parts[5];
	                String TicketClass = parts[6];
	                double Price = Double.parseDouble(parts[7]);
	                int availableseats = Integer.parseInt(parts[8]);
                
	                
	            
	                
	                
	                if (parts.length ==9) {
	                	Flight f = new Flight(FlightId,Airline,DeparatureCity,ArrivalCity,DepartureTime,ArrivalTime,TicketClass,Price,availableseats);
	                	return f;
	                }

	                else {
	                	String StopoverCity = parts[9];
    	                String FinalArrivalCity = parts[10];
    	                String leg1dep = parts[11];
    	                String leg1arr = parts[12];
    	                String leg2dep = parts[13];
    	                String leg2arr = parts[14];
	                	Flight f = new Flight(FlightId,Airline,DeparatureCity,TicketClass,Price,availableseats,StopoverCity,FinalArrivalCity,leg1dep,leg1arr,leg2dep,leg2arr);
	                	return f;
	                }

	                
	                
	                
	                
	                
	            	}
	            	id++;
	            }
	            
	        reader.close();
	        } 
		 catch (IOException e) {
	            e.printStackTrace();
	        }
		 
		return null;
	}

}
