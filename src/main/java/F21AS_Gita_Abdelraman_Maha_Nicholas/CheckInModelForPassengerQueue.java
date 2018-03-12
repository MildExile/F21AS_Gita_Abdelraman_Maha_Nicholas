package F21AS_Gita_Abdelraman_Maha_Nicholas;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class CheckInModelForPassengerQueue extends CheckInModel implements Runnable {

	   private Queue<Passenger> PassengerQueue;
	    Random r = new Random();
	    int BagMinRandomWeight = 5;
	    int BagMaxRandomWeight = 50;
	    int DimensionMinRandom = 10;
	    int DimensionMaxRandom = 200;

	
	public CheckInModelForPassengerQueue(String bookingFile, String flightFile) {
		super(bookingFile, flightFile);
		
		PassengerQueue = new LinkedList<Passenger>();
		
		for (Passenger p : listOfPassengers)
		{
			if (p.getCheckedIn() == true)
			listOfPassengers.remove(p);
		};
	}
	
	public void run()
	{
		
		for (int i=0 ; i < listOfPassengers.size();i++)
		{
			AppendIntoQueue();
		}
		try
		{
			Thread.sleep(5000);
		}
		catch(InterruptedException e)
		{
			System.err.println(e.getMessage());
		}
		
	
	}
	
    /**
     * A method which traverse the PassengerList search for passengers who didn't check in
     * And append them into the queue 
     */
    public synchronized void AppendIntoQueue()
    {
    	int passengerIndex;
    	passengerIndex = r.nextInt(listOfPassengers.size());
    	currentPassenger = listOfPassengers.get(passengerIndex);
    		if(currentPassenger.getCheckedIn() == false )
    		{
    			float bagWeight =(float) r.nextInt(this.BagMaxRandomWeight - this.BagMinRandomWeight)+ this.BagMinRandomWeight;
    			currentPassenger.setBagWeight(bagWeight);
    			
    			float x = (float) r.nextInt(this.DimensionMaxRandom - this.DimensionMinRandom) + this.DimensionMinRandom;
    			float y = (float) r.nextInt(this.DimensionMaxRandom - this.DimensionMinRandom) + this.DimensionMinRandom;
    			float z = (float) r.nextInt(this.DimensionMaxRandom - this.DimensionMinRandom) + this.DimensionMinRandom;
        	
    			currentPassenger.setBagDimension(x, y, z);
    			
    			PassengerQueue.add(currentPassenger);
    		}// end of if
    	listOfPassengers.remove(passengerIndex);
    	
    }
    
    public String GenerateQueueDetails()
    {
    	String report =" ";
    	for(Passenger p: PassengerQueue)
    	{
    		report+= String.format("%15s", p.getFlightCode());
    		report+= String.format("%15s", p.getFullName());
    		report+= String.format("%10.2f kg", p.getBagWeight());
    		report+= String.format("%10s",p.getBagDimension());
    		
    	}
    	return report;
    }
	
	
	

}
