
public class Manager {
	
	private FlightList listOfFlights;
	private PassengerList listOfPassengers;
	private GUI airportGUI;
	
	
	public Manager()
	{
		listOfFlights = new FlightList();
		listOfPassengers = new PassengerList();
		airportGUI = new GUI(listOfPassengers, listOfFlights);
	}
	
	public void run()
	{
		listOfFlights.readFileForFlight("FlightData.csv");
		listOfPassengers.readFileForPassenger("PassengerData.csv");

		System.out.println("sussfully uploaded");
		listOfPassengers.printAllPassengers();
		listOfFlights.printAllFlights();
		
		String report = listOfPassengers.generatePassengerInfo();
		listOfPassengers.WriteToFile("PassengersInfo.txt", report);
		
		String report2 = listOfFlights.generateFlighInfo();
		listOfFlights.WriteToFile("FlightInfo.txt", report2);
		
		airportGUI.run();
		}

}
