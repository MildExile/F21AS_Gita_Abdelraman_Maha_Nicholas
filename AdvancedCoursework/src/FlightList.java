import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FlightList {
	
	private ArrayList<Flight>	listOfFlights;
	private PassengerList listOfPassengers;
	
	public FlightList()
	{
		listOfFlights = new ArrayList<Flight>();
		listOfPassengers = new PassengerList();
	}
	
	/**
	 * Add a Passenger object to the list Passengers
	 * Use bookingRefCode to judge the availability 
	 * @param p which is an object from Passenger class to be added
	 * @return boolean value; true if Passenger was added to the list
	 * false if it is not available
	 */
	public boolean addOneFlight(Flight f1)
	{
		//get bookingRefCode to be reserved (unique)
		String carrier = f1.getCarrier();
		
		//check if the flight with this carrier is already in the list and preserved
		
		Flight inList = this.findByCarrierCode(carrier);
		
		//Check if it is available 
		// add it to list and return true
		if (inList == null) {
			listOfFlights.add(f1);
			return true;
		}
		
		//return false if the carrier is not available i.e. already in the list
		return false;
		
	}
	
	/**
 	 * This method checks whether or not the Carrier is available or not
 	 * Also it is used to return Flight object based on carrier
 	 * @param carrier to be checked 
 	 * @return null if the carrier is still available i.e not in list
 	 * @return f1 which indicates for the Flight Object who has the Carrier
 	 */
	public Flight findByCarrierCode(String carrier) {
		
		for(Flight f1 : listOfFlights)
		{
			if (f1.getCarrier().equals(carrier))
				return f1;
		}
		
		return null;
	}
	
	/**
	 * Method used to Write a string(output) to .txt file
	 * @param fileName to specifies the name of file to write on
	 * @param report which contains the data to be written to the file
	 */
	public void WriteToFile(String fileName , String report)
	{
		
		FileWriter fw;
		try
		{
			fw = new FileWriter(fileName);
			fw.write("The Report \n");
			fw.write(report);
			fw.close();
		}
		
		 //message and stop if file not found
		 catch (FileNotFoundException e){
			 System.out.println(fileName + " not found ");
			 System.exit(0);
		 }
		
		 
		 catch (IOException e){
		   System.err.println("ERROR "+ e.getMessage());
		   System.exit(1);
		 }
		
	}
	

	/** reads file with given name, extracting Passengers  data, creating Passenger objects
	 * and adding them to the list of Passengers
	 * Empty lines are skipped
	 * @param filename the name of the input file
	 */
	
	public void readFileForFlight(String fileName)
	{
		try
		{	
			
			File f = new File(fileName);
			
			//To enable input
			Scanner input = new Scanner(f);
			
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
		
	}// end of readFile method


	public void executeLineForFlight(String line)
	{
		String parts[] = line.split(",");
		
		String destination = parts[0].trim();
		String flightCode = parts[1].trim();
		String carrier = parts[2].trim();
		int maxPassengers = Integer.parseInt(parts[3].trim());
		int maxBagWeight = Integer.parseInt(parts[4].trim());
		int maxBagVolume = Integer.parseInt(parts[5].trim());
		
		
		Flight f1 = new Flight(destination,flightCode,carrier,maxPassengers,maxBagWeight,maxBagVolume);
		this.addOneFlight(f1);
		
	}
	
	public void printAllFlights()
	{
		for(Flight f : listOfFlights)
		{
			System.out.println(f.getDestinationAirport());
		}
	}
	
	public String generateFlighInfo()
	{
		String report = " Destination Airport       Carrier      Maximum number of Passenger      Maximum Baggage weight     Maximum Baggage volume \n";
		for (Flight f: listOfFlights)
		{
			report += String.format("%20s", f.getDestinationAirport());
			report += String.format("%20s", f.getCarrier());
			report += String.format("%20d", f.getMaxPassengers());
			report += String.format("%20d", f.getMaxBagWeight());
			report += String.format("20d", f.getMaxBagVolume());
			
			report +="\n";
		}
		
		return report;
	}
	
	public String GenerateReport()
	{
		String report = "#Passengers       Addtional Bag Cost Fees     TotalWeight      Total Voulme  ";
		report += "\n";
		
		for(Flight f : listOfFlights )
		{
			int countPassengers = 0 ;
			double additionalCostBags =0.0;
			double totalWeight = 0.0;
			double totalVolume = 0.0;
		 	report += String.format("%10d",listOfPassengers.countPassengers(f.getFlightCode()) );
			report += String.format("%10.2f", listOfPassengers.additionalCostBags(f.getFlightCode()));
			report += String.format("%10.2f", listOfPassengers.totalBaggageWeight(f.getFlightCode()));
			report += String.format("%10.2f", listOfPassengers.totalVolume(f.getFlightCode()));
			report += "\n";
			
			//report += String.valueOf(f.getFlightCode().equals(listOfPassengers.getInfo().getFlightCode()));
			}
		return report;
	}
	
	


}
