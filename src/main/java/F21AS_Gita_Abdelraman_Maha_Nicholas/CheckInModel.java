package F21AS_Gita_Abdelraman_Maha_Nicholas;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
/**
 * This class is the model which reads csv file for both flight and passengers data
 * Creates two ArrayList one for Passengers and the other for Flight
 * Each ArrayList consists of either Passenger Object or Flight Object and contains all the information
 * Has all the methods needed to process objects, display output
 * We use it to pull all the information from the files
 * @authors Abdelrahman,Gita, Maha and Nicholas 
 *
 */
public class CheckInModel  {

    protected ArrayList<Passenger> listOfPassengers;
    protected ArrayList<Flight> listOfFlights;
    protected Passenger currentPassenger;
    private String bookingFile = "src/main/resources/PassengersData.csv";
    private String flightFile = "src/main/resources/FlightData.csv";
 

    /**constructor to create CheckInModel, flight data and passenger data are read here
     */
    public CheckInModel()
    {
        listOfPassengers = new ArrayList<Passenger>();
        listOfFlights = new ArrayList<Flight>();
        
        
        readFileForFlight(flightFile);
        readFileForPassenger(bookingFile);
    }

    /**reads file with given name, extracting destinationAirport, flightCode, carrier, maxPassengers, maxBagWeight, maxBagVolume
     * and adding them to the list of Flights
     * Empty lines are skipped
     * @param fileName the name of the input file
     */
    public void readFileForFlight(String fileName)
    {
    	File f ;
    	Scanner input = null;
        try
        {

             f = new File(fileName);

            //To enable input
             input = new Scanner(f);
           
            while(input.hasNextLine())
            {
                String line = input.nextLine();

                //Ignore any blank entry/line in the file
                if(line.length() !=0 )
                    executeLineForFlight(line);

            }// end of while

        }// end of try

        catch(FileNotFoundException e)
        {
            System.out.printf("FILE NAME %s  NOT FOUND %n",fileName );
            System.err.println("ERROR "+ e.getMessage());
            System.exit(1);
        }// end of catch
        
        finally
        {
        	
        	input.close();
        	
        }
        
        

    }// end of readFile method

    /**takes current line and places into correct variables for flight object
     * Empty lines are skipped
     * @param line the line to currently be placed in flight object
     */
    public void executeLineForFlight(String line)
    {
        String parts[] = line.split(",");

        String destinationAirport = parts[0].trim();
        String flightCode = parts[1].trim();
        String carrier = parts[2].trim();
        int maxPassengers = Integer.parseInt(parts[3].trim());
        int maxBagWeight = Integer.parseInt(parts[4].trim());
        int maxBagVolume = Integer.parseInt(parts[5].trim());

        Flight fl = new Flight(destinationAirport, flightCode, carrier, maxPassengers, maxBagWeight, maxBagVolume);

        listOfFlights.add(fl);
    }


    /** reads file with given name, extracting Passengers data, creating Passenger objects
     * and adding them to the list of Passengers
     * Empty lines are skipped
     * @param fileName the name of the input file
     */
    public void readFileForPassenger(String fileName)
    {
    	File f;
    	Scanner input=null;
        try
        {

             f = new File(fileName);

            //To enable input
             input = new Scanner(f);

            while(input.hasNextLine())
            {
                String line = input.nextLine();

                //Ignore any blank entry/line in the file
                if(line.length() !=0 )
                    executeLineForPassengers(line);

            }// end of while

        }// end of try

        catch(FileNotFoundException e)
        {
            System.out.printf("FILE NAME %s  NOT FOUND %n",fileName );
            System.err.println("ERROR "+ e.getMessage());
            System.exit(1);
        }// end of catch
        
        finally
        {
        	
        	input.close();
        	
        }
    }// end of readFile method

    /**takes current line and places into correct variables for passenger object
     * Empty lines are skipped
     * @param line the line to currently be placed in flight object
     */
    public void executeLineForPassengers(String line)
    {
        String parts[] = line.split(",");

        String bookingRefCode = parts[0].trim();
        String flightCode = parts[1].trim();
        String firstName = parts[2].trim();
        String lastName = parts[3].trim();
        boolean checkedIn = Boolean.parseBoolean(parts[4].trim());

        Passenger p = new Passenger(bookingRefCode,flightCode,firstName,lastName,checkedIn);

        listOfPassengers.add(p);

    }
    /**
     * A method used to set passengers information
     * it traverse the listOfPassengers to match a passenger
     * it compares the provided BookingRef and lastname if there were the same as the passenger
     * @param bookingRefCode
     * @param lastName
     */
    public void setCurrentPassengerWithBooking(String bookingRefCode, String lastName)
    {
        for(Passenger p: listOfPassengers)
            if(p.getBookingRefCode().equals(bookingRefCode)&& p.getLastName().equals(lastName))
                currentPassenger = p;
    }

    /**
     * a Method for returning the current Passenger to be processed
     * @return Passenger Object
     */
    public Passenger getCurrentPassenger() {
        return currentPassenger;
    }

    /**
     * Method used to CheckInPassenger based on his bookingRefCode and lastname 
     * it checks whether or not a passenger exists using the condition currentPassenger !=null
     * currentPassenger will contains the passenger object that has the bookingref and lastname to be checked
     * @param bookingRef
     * @param lastName
     */
    public void checkInPassenger(String bookingRef , String lastName){
        setCurrentPassengerWithBooking(bookingRef, lastName);

        if(currentPassenger != null)
        {
            currentPassenger.setCheckedIn(true);
        }
    }
    /**
     * a method used to set the Bag information for a passenger
     * @param bagVolume
     * @param bagWeight
     */
    public void checkInBag(int bagVolume, float bagWeight ){
        currentPassenger.setBagVolume(bagVolume);
        currentPassenger.setBagWeight(bagWeight);
    }
    
    /**
     * a method which traverse the PassengerList to check weather or not they have checkedIn or not
     * @return a boolean passengerCheck to indicate the CheckIn situation 
     */
    public boolean haveAllPassengersCheckedin(){
        boolean passengerCheck = true;
        for (Passenger p : listOfPassengers)
        {
            if(!p.getCheckedIn())
                passengerCheck = false;
        }
        return passengerCheck;
    }
    
    /**
     * A method which traverse the PassengerList to check weather or not all passengers
     * have checkedIn for a specific flight 
     * @param flightCode
     * @return boolean passengerCheck to indicate the CheckedIn 
     */
    public boolean haveAllPassengersCheckedin (String flightCode){
        boolean passengerCheck = true;
        for (Passenger p : listOfPassengers)
        {
            if(p.getFlightCode().equals(flightCode))
                passengerCheck = false;
        }
        return passengerCheck;
    }

    /**
     * a method which generate Passenger Information 
     * It traverse the whole list and print information for each object 
     * @return a String which contains the information needed to display 
     */
    public String generatePassengerInfo()
    {
        String report= "Booking Code         Passenger name      Flight Code    CheckedIN \n";
        System.out.println();
        for(Passenger p : listOfPassengers)
        {
            report += String.format("%20s", p.getBookingRefCode());
            report += String.format("%20s", p.getFullName());
            report += String.format("%20s", p.getFlightCode());
            report += String.format("%20b", p.getCheckedIn());
            report += "\n";
        }

        return report;
    }
    /**
     * a method which generate Flight Information 
     * It traverse the whole FlightList and print information for each object 
     * @return a String which contains the information needed to display 
     */
    public String generateFlightInfo()
    {
        String report = " Destination Airport     Flight Code  Carrier      Maximum number of Passenger      Maximum Baggage weight     Maximum Baggage volume \n";
        for (Flight f: listOfFlights)
        {

            report += String.format("%20s", f.getDestinationAirport());
            report += String.format("%20s", f.getFlightCode());
            report += String.format("%20s", f.getCarrier());
            report += String.format("%20d", f.getMaxPassengers());
            report += String.format("%20f", f.getMaxBagWeight());
            report += String.format("20d", f.getMaxBagVolume());

            report +="\n";
        }

        return report;
    }

    /**
     * a method which generates information for both list PassengerList and FlightList
     * @return a string containg all the requried information 
     */
    public String generateReport()
    {
        String report = "";
        int overMaxInt = 0;
        float overMaxFloat = 0.0f;

        for(Flight f : listOfFlights )
        {
            report += "============================================================================";
            report += "\n";
            report += "Flight Code             Destination             Carrier";
            report += "\n";
            report += String.format("%10s", f.getFlightCode());
            report += String.format("%10s", f.getDestinationAirport());
            report += String.format("%10s", f.getCarrier());
            report += "\n";
            report += "------------------------------------------------------------------------------------------------------------------------------------";
            report += "\n";
            report += "#Passengers       Addtional Bag Cost Fees     TotalWeight      Total Volume  ";
            report += "\n";

            int countPassengers = 0 ;
            float additionalCostBags = 0.0f;
            float totalWeight = 0.0f;
            int totalVolume = 0;
            for(Passenger p : listOfPassengers)
            {
                if(f.getFlightCode().equals(p.getFlightCode()) && p.getCheckedIn())
                {
                    countPassengers++;
                    additionalCostBags += p.getExcessBagCost();
                    totalWeight += p.getBagWeight();
                    totalVolume += p.getBagVolume();
                }
            }
            if (countPassengers > 0){
                report += String.format("%10d", countPassengers);
                report += String.format("%10.2f", additionalCostBags);
                report += String.format("%10.2f", totalWeight);
                report += String.format("%10d", totalVolume);
                report += "\n";


                if (countPassengers > f.getMaxPassengers()) {
                    overMaxInt = countPassengers - f.getMaxPassengers();
                    report += "WARNING: Passenger Count for this flight exceeded by " + overMaxInt;
                    report += "\n";
                    report += "============================================================================";
                    report += "\n";
                }
                if (totalWeight > f.getMaxBagWeight()) {
                    overMaxFloat = totalWeight - f.getMaxBagWeight();
                    report += "WARNING: Maximum weight for this flight exceeded by " + overMaxFloat;
                    report += "\n";
                    report += "============================================================================";
                    report += "\n";
                }
                if (totalVolume > f.getMaxBagVolume()) {
                    overMaxInt = totalVolume - f.getMaxBagVolume();
                    report += "WARNING: Maximum bag volume for this flight exceeded by " + overMaxInt;
                    report += "\n";
                    report += "============================================================================";
                    report += "\n";
                }
            }
            report += "============================================================================";
            report += "\n";
        }
        return report;
    }
    /**
     * a method which display information for passengers who have already CheckedIn
     * it traverse the whole PassengerList, check weather if they have already been CheckedIn
     * Process information 
     * @return report which is a string contains all the requried information 
     */
    public String generateListOfCheckedInPassenger()
    {
        String report = "FirstName   LastName  BookingRef \n";
        for(Passenger p: listOfPassengers)
        {
            if(p.getCheckedIn() == true)
            {
                report += String.format("%10s", p.getFirstName() );
                report += String.format("%15s", p.getLastName());
                report += String.format("%10s", p.getBookingRefCode());
                report +="\n";
            }
        }
        return report;

    }
     
    

    

}
