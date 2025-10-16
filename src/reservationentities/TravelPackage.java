package reservationentities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/** The TravelPackage class is travelpackage is created by admin
 * or booked by user
 * 
 */
public class TravelPackage extends Entities {
	private String name;
	private String generalInformation;
	private Hotels hotels;
	private Flight flight;
	private Taxi taxi;
	private double price;
	private double commisionRate;
	private int stayDay;
	private double totalCost;

	
	
	
	public int getStayDay() {
		return stayDay;
	}
	public void setStayDay(int stayDay) {
		this.stayDay = stayDay;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGeneralInformation() {
		return generalInformation;
	}
	public void setGeneralInformation(String generalInformation) {
		this.generalInformation = generalInformation;
	}
	public Hotels getHotels() {
		return hotels;
	}
	public void setHotels(Hotels hotels) {
		this.hotels = hotels;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public Taxi getTaxi() {
		return taxi;
	}
	public void setTaxi(Taxi taxi) {
		this.taxi = taxi;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getCommisionRate() {
		return commisionRate;
	}
	public void setCommisionRate(double commisionRate) {
		this.commisionRate = commisionRate;
	}
	
	public TravelPackage(String name,String generalInofrmation, Hotels hotels,Flight flight,Taxi taxi, double commisionRate , int stayDay ) {
		this.name = name;
		this.generalInformation = generalInofrmation;
		this.hotels = hotels;
		this.flight = flight;
		this.taxi = taxi;
		this.commisionRate = commisionRate;
		this.stayDay = stayDay;
		this.price = TotalCost();
		
	}
	/** The TotalCost method calculate the total cost of travelpackage with commision rate
	 * 
	 */
	public double TotalCost(){
		double total;
		
		total = ((getStayDay() * getHotels().getPricePerNight())
				+ getFlight().getTicketPrice() 
				+ getTaxi().getBasefare() 
				+ (getHotels().getDistanceToAirport()*getTaxi().getFarePerKm())) * ((100.0 + commisionRate)/100.0) ;
		
		
		
		return total;
		
	}
	/** The TotalCost method calculate the total cost of travelpackage without commision rate
	 * 
	 */
	public double TotalCostnocom(){
		double total;
		
		total = ((getStayDay() * getHotels().getPricePerNight())
				+ getFlight().getTicketPrice() 
				+ getTaxi().getBasefare() 
				+ (getHotels().getDistanceToAirport()*getTaxi().getFarePerKm()));
		
		
		
		return total;
		
	}
	/** The CanItBeCreated method check travelpackage can it be created
	 * 
	 * @return travelpackage creatibility
	 */
	public static boolean CanItBeCreated(TravelPackage travelpackage) {
		if(travelpackage.getFlight().getArrivalCity() == null) {
			if(travelpackage.getFlight().getFinalArrivalCity().equals(travelpackage.getHotels().getLocation()) && travelpackage.getTaxi().getCity().equals(travelpackage.getHotels().getLocation())){
				return true;
			}
			return false;
		}
		else {
			if(travelpackage.getFlight().getArrivalCity().equals(travelpackage.getHotels().getLocation()) && travelpackage.getTaxi().getCity().equals(travelpackage.getHotels().getLocation())){
				return true;
			}
			return false;
		
			
		}
		
		
		
	}
	/** The getTravelpackagebyindex method reads data file and return
	 * the travelpackage object according to the index
	 * 
	 * @param index of the travelpackage that in data file
	 * @return travelpackage object 
	 */
	public static TravelPackage getTravelpackagebyindex(int index) {
    	String filepath = "data/FinalKU_Travel_Agency_TravelPackages.txt";
		

		
		 try {
			 BufferedReader reader = new BufferedReader(new FileReader(filepath));
	            String line;
	            
	           
	            int id = 1;
	            while ((line = reader.readLine()) != null) {
	            	if (id == index) {
	            		
	            	

	                String[] parts = line.split(" - ");
	                String name = parts[0].split(";")[1];
	                String generalinfo = parts[1].split(";")[1];
	                String hotel = parts[2].split(";")[1];
	                int durationofstay = Integer.parseInt(parts[3].split(";")[1]);
	                Double TotalFare = Double.parseDouble(parts[20].split(";")[1]);
	                int hindex = Integer.parseInt(parts[21].split(";")[1]);
	                int findex = Integer.parseInt(parts[22].split(";")[1]);
	                int tindex = Integer.parseInt(parts[23].split(";")[1]);
	                TravelPackage co = new TravelPackage(name,generalinfo,Hotels.getHotelbyindex(hindex),Flight.getFlightyindex(findex),Taxi.getTaxibyindex(tindex), 0, durationofstay);
	                double comissionrate = ((TotalFare-co.getPrice())/TotalFare) * 100;
	            
	                TravelPackage travelpackage = new TravelPackage(name,generalinfo,Hotels.getHotelbyindex(hindex),Flight.getFlightyindex(findex),Taxi.getTaxibyindex(tindex), comissionrate, durationofstay);
	                
	                return travelpackage;
	                
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
	/** The isavailable method check availabilty for travelpackage
	 * 
	 * @return travelpackage availability 
	 */
	public boolean isavailable() {
		if(flight.isavailable()&&taxi.isavailable()&&hotels.isavailable()) {
			return true;
		}
		return false;
	}
	

}
