package reservationentities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/** The Taxi class is in given data and bookable by user
 * 
 */
public class Taxi extends Entities {
	private String city; 
	private String type ;
	private double basefare;
	private int availability;
	private double farePerKm;
	private boolean isavailable;
	
	
	public double getFarePerKm() {
		return farePerKm;
	}
	public void setFarePerKm(double farePerKm) {
		this.farePerKm = farePerKm;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBasefare() {
		return basefare;
	}

	public void setBasefare(double basefare) {
		this.basefare = basefare;
	}


	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

	public Taxi(String city,String type ,int availability,double basefare,double farePerKm){
		this.city = city;
		this.type = type;
		this.basefare = basefare;
		this.availability = availability;
		this.farePerKm = farePerKm;
		this.isavailable = isavailable();
	}
	/** The isavailable method check availabilty for taxi
	 * 
	 * @return taxis availability 
	 */
	public boolean isavailable() {
		if(getAvailability()>0) {
			return true;
		}
		else {
			return false;
		}
	}
	/** The getTaxibyindex method reads data file and return
	 * the taxi object according to the index
	 * 
	 * @param index of the taxi that in data file
	 * @return taxi object 
	 */
	 public static Taxi getTaxibyindex(int index) {
	    	String filepath = "data/FinalKU_Travel_Agency_Dataset_Taxis.csv";
			

			
			 try {
				 BufferedReader reader = new BufferedReader(new FileReader(filepath));
		            String line;
		            
		           
		            int id = 1;
		            while ((line = reader.readLine()) != null) {
		            	if (id == index+1) {
		            		
		            	

		                String[] parts = line.split(",");
		                String city = parts[0];
		                String taxitype = parts[1];
		                int availabletaxis = Integer.parseInt(parts[2]);
		                double bfrre = Double.parseDouble(parts[3]);
		                double perkm= Double.parseDouble(parts[4]);
		            
		                Taxi taxi = new Taxi(city,taxitype,availabletaxis,bfrre,perkm);
		                
		                return taxi;
		                
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
