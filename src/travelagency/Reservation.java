package travelagency;

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

import helpers.FileHelpers;
import reservationentities.Flight;
import reservationentities.Hotels;
import reservationentities.Taxi;
import reservationentities.TravelPackage;
/** The Reservation class saves the reservation to the file or
 * delete it with cancelreservation and while doing that look time diffrence
 * to determine deduction rate
 * 
 */
public class Reservation {

	/**
	 * The saveReservation method takes parameter and according to their value
	 * it save it to the ReservationLogs.txt as appropriate string
	 * 
	 * @param Name   The username 
	 * @param stayday   users duration of stay
	 * @param taxidistance  the hotel distance to the airport
	 * @param flight  the flight object that user want to book
	 * @param taxi   the taxi object that user want to book
	 * @param hotel   the hotel object that user want to book
	 * @param travelpackage  the travelpackage object that user want to book
	 * @param year  the year of the reservation
	 * @param month  the month of the reservation
	 * @param day  the day of the reservation
	 * @param hour  the hour of the reservation
	 * @param minute  the minute of the reservation
	 * @param second  the second of the reservation
	 */
	public static void saveReservation(String Name,int stayday,double taxidistance,Flight flight,Taxi taxi,Hotels hotel,TravelPackage travelpackage,String year,String month,String day,String hour,String minute,String second) {
    	String fileName = "logs/ReservationLogs.txt";
        String dateTime = year+"-"+month+"-"+day+"_"+hour+":"+minute+":"+second; //formatting users date time
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            
            //Writing string in the reservation.txt for travelpackage object
            if(flight == null && taxi==null&& hotel==null) {
            	double commisionrate = ((travelpackage.getCommisionRate() +100.0)/100.0);
            	writer.println("Date-Time :"+ dateTime +"; User :"+ Name + "; Reservation Action :" + "TravelPackage booking" + "; Price :" + travelpackage.getPrice() + "; Stayday :" + travelpackage.getStayDay() +" "
            			+"; Details -" + "Flight Id :" + travelpackage.getFlight().getFlightId() + "_ City:" + travelpackage.getHotels().getLocation()  
            			+ "_ Hotel Name:" + travelpackage.getHotels().getName()+ "_ Airline:" + travelpackage.getFlight().getAirline()+ "_ Taxi Type:" + travelpackage.getTaxi().getType()+ "_ Taxi City:" + travelpackage.getTaxi().getCity()
            			+"_ Hotel Cost :" + ((travelpackage.getHotels().getPricePerNight()*travelpackage.getStayDay())*commisionrate) + "_ Flight Cost :" + (travelpackage.getFlight().getTicketPrice()*commisionrate) + "_ Taxi Cost :" + (travelpackage.getTaxi().getBasefare() + ((travelpackage.getTaxi().getFarePerKm()*travelpackage.getHotels().getDistanceToAirport())*commisionrate))
            			+ "; TotalCost :" + travelpackage.TotalCostnocom());
            	FileHelpers.savePaymentToFile(Name, travelpackage.getPrice(),travelpackage.TotalCostnocom(), "TravelPackage booking", "Make Reservation",0.0,0.0,travelpackage.getFlight().getAirline(),travelpackage.getHotels().getName(),travelpackage.getTaxi().getType(),travelpackage.getTaxi().getCity());
            }
          //Writing string in the reservation.txt for flight object
            if(travelpackage== null && taxi==null&& hotel==null) {
            	if(flight.getArrivalCity() == null) {
            		writer.println("Date-Time :"+ dateTime +"; User :"+ Name + "; Reservation Action :" + "Flight Booking" + "; Price :" + (flight.getTicketPrice()*1.2) + "; Stayday :" + " " 
            		+"; Details-"+"Airline:"+flight.getAirline() +"_ Departure City :" + flight.getDepartureCity()+ "_ Stopover City:" + flight.getStopoverCity() + "_ Final Arrival City:" + flight.getFinalArrivalCity() + "_ Leg 1 Departure time:" + flight.getLeg1departuretime() 
            		+ "_ Leg 1 Arrival Time:" + flight.getLeg1ArrivalTime() + "_ Leg 2 Departure time:" + flight.getLeg2DepartureTime() + "_ Leg 2 Arrival Time:" + flight.getLeg2ArrivalTime()+"_ Class:" + flight.getTheClass()+ "; TotalCost :" + flight.getTicketPrice());
            	}
            	else {
            		writer.println("Date-Time :"+ dateTime +"; User :"+ Name + "; Reservation Action :" + "Flight Booking" + "; Price :" + (flight.getTicketPrice()*1.2) + "; Stayday :" + " "
            	    +"; Details -"+"Airline:"+flight.getAirline() +"_ Departure City :" + flight.getDepartureCity()+ "_ Arrival City :" + flight.getArrivalCity() + "_ Departure Time :" + flight.getDepartureTime() + "_ Arrival Time:" + flight.getArrivalTime() +"_ Class:" + flight.getTheClass()+ "; TotalCost :" + flight.getTicketPrice());
            		
            	}
            	
            	FileHelpers.savePaymentToFile(Name,flight.getTicketPrice(),flight.getTicketPrice(), "Flight Booking", "Make Reservation",20.0,0.0,flight.getAirline(),"","","");
            }
          //Writing string in the reservation.txt for taxi object
            if(flight == null && travelpackage==null&& hotel==null) {
            	writer.println("Date-Time :"+ dateTime +"; User :"+ Name + "; Reservation Action :" + "Taxi Booking" + "; Price :" + ((taxi.getBasefare()+(taxi.getFarePerKm()*taxidistance))*1.2) + "; Stayday :" + " "
            	+"; Details -"+"City:" + taxi.getCity() + "_ Taxi Type :" + taxi.getType() + "; TotalCost :" + (taxi.getBasefare()+(taxi.getFarePerKm()*taxidistance)));
            	FileHelpers.savePaymentToFile(Name, (taxi.getBasefare()+(taxi.getFarePerKm()*taxidistance)),(taxi.getBasefare()+(taxi.getFarePerKm()*taxidistance)), "Taxi Booking", "Make Reservation",20.0,0.0,"","",taxi.getType(),taxi.getCity());
            }
          //Writing string in the reservation.txt for hotel object
            if(flight == null && taxi==null&& travelpackage==null) {
            	writer.println("Date-Time :"+ dateTime +"; User :"+ Name + "; Reservation Action :" + "Hotel Reservation" + "; Price :" + (hotel.getPricePerNight()*stayday*1.2) + "; Stayday :" + stayday + " "
            	+"; Details -"+"Hotel Name:"+hotel.getName() +"_ City:" + hotel.getLocation() + "_ Hotel Name:" + hotel.getName() + "_ Room Type:" + hotel.getRoomTypes()+ "; TotalCost :" + hotel.getPricePerNight()*stayday );
            	FileHelpers.savePaymentToFile(Name, (hotel.getPricePerNight()*stayday),(hotel.getPricePerNight()*stayday), "Hotel Reservation", "Make Reservation",20.0,0,"",hotel.getName(),"","");
            	
            }
            
            
           

        } catch (IOException e) {
            System.err.println("Error writing to log file: ");
        }
    }
	/**
	 * The CancelReservation will delete line of the reservation from the
	 * Reservationlogs.txt according to index that taken from user and username.
	 * 
	 * @param index the line of wants to cancelled
	 * @param name name of the user
	 * @param reason the users reason
	 * @param late  the rate of the deduction taken from user
	 */
    public static void CancelReservation(int index,String name,String reason,double late) {
    	String filePath = "logs/ReservationLogs.txt";
    	
    	
    	try {
    		List<String[]> a = TravelHistory.Reservationwitouthname(); // taking all reservations as list
            List<String> lines = new ArrayList<>(); //lines will writing again to file
            List<String> Canceledlines = new ArrayList<>(); // lines will writing to Cancellation.txt file
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                int id =0;
                int linenumber = 0;
                while ((line = reader.readLine()) != null) {
                    // if name not equal that line will be added to lines 
                    if (!a.get(linenumber)[1].equals(name)){ 
                        lines.add(line);
                        ++linenumber;
                    }
                    // if name and index equal to line that given parameters then it added to Canceledlines
                    else if((a.get(linenumber)[1].equals(name) )&& (id == index-1)){ 
                    	Canceledlines.add(line);
                    	id++;

                    }
                 // if name not equal but not equal to give index then line will be added to lines 
                    else if((a.get(linenumber)[1].equals(name) )&& (id != index-1)){ 
                    	lines.add(line);
                    	id++;
                    	++linenumber;

                    }


                    
                }

            }

            // adding lines to file in the List "lines"
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {;
            	
                for (String line : lines) {
                    writer.write(line);
                    writer.newLine();
                }
                
                
            }
            //writing canceled lines to the Cancellations.txt
            Writecanceled(Canceledlines.get(0),reason,late);

        } catch (IOException e) {
            System.err.println("An error ");
        }
    }
    /** The Writecanceled method write the given line to the Cancellations.txt folder
     * and update the payment folder with the deduction rate
     * 
     * @param line the line that going to added to the Cancellations.txt
     * @param reason the reason that taken from the user
     * @param late the rate of the deduction taken from user
     */
    public static void Writecanceled(String line,String reason,double late) {
    	String filename = "logs/Cancellations.txt";
    	try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
    		String[] parts = line.split(";");
    		String uname = parts[1].split(":")[1];
    		String raction = parts[2].split(":")[1];
    		double price = Double.parseDouble(parts[3].split(":")[1]);
    		double cost = Double.parseDouble(parts[6].split(":")[1]);
    		double payrate= (100.0-late)/100.0; //deduction rate
    		
    		//updating the payment file with adding payment
    		FileHelpers.savePaymentToFile(uname, -1*price*payrate,-1*cost, raction, "Cancellation",0.0,0.0,"","","","");
		    writer.println(line + "; Cancel Reason :" + reason);

		} catch (IOException e) {
		    e.printStackTrace();
		}
    }
    /**
     * The CancellationTimecalculate calculate 
     * and Returns the difference between two given times in hours.
     * 
     * @param time the time that user maked the reservation
     * @return difference between system local time and users given time
     */
    public static double CancellationTimecalculate(String time) {

    	String[] datess = time.split("_");
    	String[] dates = datess[0].split("-");
    	double year = Double.parseDouble(dates[0]); // The year taken by users
    	double month = Double.parseDouble(dates[1]); // The month taken by users
    	double day = Double.parseDouble(dates[2]); // The day taken by users
    	
    	String[] timess =  datess[1].split(":");
    	
    	double hour = Double.parseDouble(timess[0]); // The hour taken by users
    	double minutes = Double.parseDouble(timess[1]); // The minutes taken by users
    	double seconds = Double.parseDouble(timess[2]); // The seconds taken by users
    	
    	LocalDateTime now = LocalDateTime.now(); // taking local time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss"); // creating formatter as year-month-day_hour:minute:second
        String dateTime = now.format(formatter); // format the local time

    	String[] datessd = dateTime.split("_");
    	String[] datesd = datessd[0].split("-");
    	double yeard = Double.parseDouble(datesd[0]); // The year taken by System local times
    	double monthd = Double.parseDouble(datesd[1]); // The month taken by System local times
    	double dayd = Double.parseDouble(datesd[2]); // The day taken by System local times
    	
    	String[] timessd =  datessd[1].split(":");
    	
    	double hourd = Double.parseDouble(timessd[0]); // The hour taken by System local times
    	double minutesd = Double.parseDouble(timessd[1]); // The minute taken by System local times
    	double secondsd = Double.parseDouble(timessd[2]); // The second taken by System local times

    	double timedif = 0.0;
    	
    	// The diffrences of time
    	double yeardif = year-yeard;
    	double monthdif = month-monthd;
    	double daydif = day-dayd;
    	double hourdif = hour-hourd;
    	double minutedif = minutes-minutesd ;
    	double seconddif = seconds -secondsd;


    	//convert all time types to hours
    	timedif += (yeardif*8765.0);
    	timedif += (monthdif*730.0);
    	timedif += (daydif*24.0);
    	timedif += hourdif;
    	timedif += minutedif/60.0;
    	timedif += seconddif/3600.0;

    	return timedif;
    }
	
}
