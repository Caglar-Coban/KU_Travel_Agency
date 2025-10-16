package reservationentities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/** The Hotels class is in given data and bookable by user
 * 
 */
public class Hotels extends Entities {
	private String name;
	private String location;
	private double pricePerNight;
	private String roomTypes;
	private int availableRooms;
	private double distanceToAirport;
	private boolean isavailable;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	public String getRoomTypes() {
		return roomTypes;
	}

	public void setRoomTypes(String roomTypes) {
		this.roomTypes = roomTypes;
	}

	public int isRoomAvailability() {
		return availableRooms;
	}

	public void setRoomAvailability(int roomAvailability) {
		this.availableRooms = roomAvailability;
	}

	public double getDistanceToAirport() {
		return distanceToAirport;
	}

	public void setDistanceToAirport(double distanceToAirport) {
		this.distanceToAirport = distanceToAirport;
	}

	public Hotels(String name, String location,String roomTypes,double pricePernight,int availableRooms, double distanceToAirport) {
		this.name = name;
		this.location = location;
		this.pricePerNight = pricePernight;
		this.availableRooms = availableRooms;
		this.roomTypes = roomTypes;
		this.distanceToAirport = distanceToAirport;
		this.isavailable = isavailable();
	}
	/** The isavailable method check availabilty for hotel
	 * 
	 * @return Hotels availability 
	 */
	public boolean isavailable() {
		if(isRoomAvailability()>0) {
			return true;
		}
		else {
			return false;
		}
	}
	/** The getHotelbyindex method reads data file and return
	 * the taxi object according to the index
	 * 
	 * @param index of the hotel that in data file
	 * @return hotel object 
	 */
	public static Hotels getHotelbyindex(int index) {
		String filepath = "data/FinalKU_Travel_Agency_Dataset_Hotels.csv";
		

		
		 try {
			 BufferedReader reader = new BufferedReader(new FileReader(filepath));
	            String line;
	            
	           
	            int id = 1;
	            while ((line = reader.readLine()) != null) {
	            	if (id == index+1) {
	            		
	            	

	                String[] parts = line.split(",");
	                String hotelname = parts[0];
	                String city = parts[1];
	                String roomtype = parts[2];
	                int availablerooms = Integer.parseInt(parts[3]);
	                double price = Double.parseDouble(parts[4]);
	                double distance = Double.parseDouble(parts[5]);
	            
	                Hotels hotel = new Hotels(hotelname,city,roomtype,price,availablerooms,distance);
	                
	                return hotel;
	                
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
