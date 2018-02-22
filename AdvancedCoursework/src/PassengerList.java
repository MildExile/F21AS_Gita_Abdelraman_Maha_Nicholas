import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PassengerList {
	
	private ArrayList<Passenger> listOfPassengers;
	private Passenger passenger;
	
	private static final double excessBagLimit = 24;
	private static final double excessBagCost =  10;
	
	
	
	public PassengerList()
	{
		this.listOfPassengers = new ArrayList<Passenger>();
	}

	/**
	 * Add a Passenger object to the list Passengers
	 * Use bookingRefCode to judge the availability 
	 * @param p which is an object from Passenger class to be added
	 * @return boolean value; true if Passenger was added to the list
	 * false if it is not available
	 */
	public boolean addOnePassenger(Passenger p)
	{
		//get bookingRefCode to be reserved (unique)
		String bookingRef = p.getBookingRefCode();
		
		//check if the passenger with this bookingRef is already in the list and preserved
		
		Passenger inList = this.findByBookingRefCode(bookingRef);
		
		//Check if it is available 
		// add it to list and return true
		if (inList == null) {
			listOfPassengers.add(p);
			return true;
		}
		
		//return false if the bookingRef is not available i.e. already in the list
		return false;
		
	}
	
	
 	/**
 	 * This method checks whether or not the BookingRefCode is available or not
 	 * Also it is used to return Passenger object based on BookingRefCode
 	 * @param bookingRef to be checked 
 	 * @return null if the bookingRefCode is still available i.e not in list
 	 * @return p which indicates for the Passenger Object who has the BookingRefCode
 	 */
	public Passenger findByBookingRefCode(String bookingRef) {
		
		for(Passenger p : listOfPassengers)
		{
			if (p.getBookingRefCode().equals(bookingRef))
				return p;
		}
		
		return null;
	}
	
	public Passenger findByLastName(String lastName)
	{
		for(Passenger p : listOfPassengers)
		{
			if (p.getPassengerName().getLastName().equals(lastName))
				return p;
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
	
	public void readFileForPassenger(String fileName)
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
					executeLineForPassenger(line);
				
			}// end of while
			
		}// end of try
		
		catch(FileNotFoundException e)
		{
			System.out.printf("FILE NAME %s  NOT FOUND %n",fileName );
			System.err.println("ERROR "+ e.getMessage());
			System.exit(1);
		}// end of catch
		
	}// end of readFile method


	public void executeLineForPassenger(String line)
	{
		String parts[] = line.split(",");
		
		String bookingRefCode = parts[0].trim();
		String FlightCode = parts[1].trim();
		Name name = new Name(parts[2],parts[3]);
		//boolean checked = Boolean.parseBoolean(parts[4].trim());
		
		Passenger p1 = new Passenger(bookingRefCode,FlightCode,name);
		
		this.addOnePassenger(p1);
		
	}
	
	
	
	
	/**
	 * a method to calculate the number of passengers that have checked In
	 * @return count indicating the number of passengers
	 */
	public int numberofCheckedInPassengers()
	{
		int count = 0;
		for(Passenger p : listOfPassengers)
		{
			if(p.isCheckedIn() == true)
				count++;
		}
		return count;
	}
	
	/**
	 * a method which will result in checking in all passengers based on a flightcode
	 * the method traverse the list of passengers 
	 * compare their flightcode with the actual flightcode 
	 * if they match 
	 * call setCheckedIn method with true as param that means the passenger is checked in now
	 * @param flightcode 
	 */
	public void CheckInBasedOnFlightCode(String flightcode)
	{
		for(Passenger p: listOfPassengers)
		{
			if(p.getFlightCode()
					.equals(flightcode))
			{
				p.setCheckedIn(true);
			}
		}
		
	}
	
	public void CheckInBasedOnLastName(String flightcode, String lastName)
	{
		for(Passenger p: listOfPassengers)
		{
			if(p.getFlightCode().equals(flightcode))
			{
				if(p.getPassengerName().getLastName().equals(lastName))
					p.setCheckedIn(true);
			}
		}
	}
	
	public void CheckInBasedOnLastNameAndBookingRef(String BookingRef, String lastName)
	{
		for(Passenger p: listOfPassengers)
		{
			if(p.getBookingRefCode().equals(BookingRef))
			{
				if(p.getPassengerName().getLastName().equals(lastName))
					p.setCheckedIn(true);
			}
			
			
		}
		//JOptionPane.showMessageDialog(null,
			//	"NO Booking Ref EXISTS ",
			//    "ERROR",
			//    JOptionPane.ERROR_MESSAGE);
	}
	
	

	
	/**
	 * method which will set the dimensions and the baggage weight f
	 * @param lastname
	 * @param bookingRef
	 * in order to identify which passenger based on lastname and bookingRef
	 * the method traverse a list of passengers and match based on lastname and bookingRef
	 * @param x represents the height 
	 * @param y represents the width 
	 * @param z represents the length
	 * @param weight represents the baggage weight 
	 */
	public void getBagInformation(String lastname, String bookingRef,int x , int y , int z , double weight )
	{
		int[] dimensions  = {x,y,z};
		for(Passenger p: listOfPassengers)
		{
			if(p.getPassengerName().getLastName().equals(lastname) && p.getBookingRefCode().equals(bookingRef))
			{
				p.setBagWeight(weight);
				p.setDimension(dimensions);
			}
		}
		
	}
	
	/**
	 * Method which will calculate the fees that need to be paid
	 * if the passenger BagWeight exceeds the limit
	 * @param p to indicate which passenger 
	 * @return double fee to indicate the fee 
	 */
	public double calculateExcessFees(String lastName , String BookingRef)
	{
		
		double fee = 0.0;
		double BagWeight;
		double ExtraWeight;
		for(Passenger p: listOfPassengers)
		{
			
		if(p.getPassengerName().getLastName().equals(lastName)&& p.getBookingRefCode().equals(BookingRef))
		{	
		
		BagWeight = p.getBagWeight();
		ExtraWeight = BagWeight - excessBagLimit;
		if(ExtraWeight > 0 )
			fee = ExtraWeight * excessBagCost;
		}
		}
		return fee;
	}
	
	
	public void printAllPassengers()
	{
		for(Passenger p :listOfPassengers)
		{
			System.out.println(p.getFullname());
		}
	}
	
	public String generatePassengerInfo()
	{
		String report= "Booking Code         Passenger name      Flight Code    CheckedIN \n";
		System.out.println();
		for(Passenger p : listOfPassengers)
		{
			report += String.format("%20s", p.getBookingRefCode());
			report += String.format("%20s", p.getPassengerName().getFullName());
			report += String.format("%20s", p.getFlightCode());
			report += String.format("%20b", p.isCheckedIn());
			report += "\n";
		}
		
		return report;
	}
	
	public String generateListOfCheckedInPassenger()
	{
		String report = "FirstName   LastName  BookingRef \n";
		for(Passenger p: listOfPassengers)
		{
			if(p.isCheckedIn() == true)
			{
				report += String.format("%10s", p.getPassengerName().getFirstName() );
				report += String.format("%15s", p.getPassengerName().getLastName());
				report += String.format("10s", p.getBookingRefCode());
				report +="\n";
			}
		}
		return report;
		
	}
	

	
	public int countPassengers(String flightCode)
	{
		int count = 0;
		for(Passenger p : listOfPassengers)
		{
			if(p.getFlightCode().equals(flightCode))
				count++;
		}
		
		return count;	
	}
	
	public double additionalCostBags(String flightCode)
	{
		double count = 0.0;
		
		for(Passenger p: listOfPassengers)
		{
			if(p.getFlightCode().equals(flightCode))
			count+= this.calculateExcessFees(p.getPassengerName().getLastName(), p.getBookingRefCode());
		}
		
		return count;
	}
	
	public double totalBaggageWeight(String flightCode)
	{
		double count = 0.0;
		for(Passenger p : listOfPassengers)
		{
			if(p.getFlightCode().equals(flightCode))
				count+= p.getBagWeight();
		}
		return count;
	}
	
	public double totalVolume(String flightCode)
	{
		double count = 0 ;
		int[] diemension = new int[3];
		for(Passenger p : listOfPassengers)
		{
			if(p.getFlightCode().equals(flightCode))
		{
				diemension = p.getDimension();
				
			count +=diemension[0] *diemension[1]* diemension[2];
		}
		}
		return count;
	}
	
	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	

