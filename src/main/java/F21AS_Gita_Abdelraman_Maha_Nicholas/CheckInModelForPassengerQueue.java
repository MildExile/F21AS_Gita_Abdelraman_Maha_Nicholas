package F21AS_Gita_Abdelraman_Maha_Nicholas;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class CheckInModelForPassengerQueue  implements Runnable {

	   private Queue<Passenger> PassengerQueue;
	   private CheckInModel model;
	    Random r = new Random();
	    int BagMinRandomWeight = 5;
	    int BagMaxRandomWeight = 50;
	    int DimensionMinRandom = 10;
	    int DimensionMaxRandom = 200;

	
	public CheckInModelForPassengerQueue(CheckInModel modelObj) {
		//super(bookingFile, flightFile);
		
		PassengerQueue = new LinkedList<Passenger>();
		model = modelObj;
		
		for (Passenger p : model.listOfPassengers)
		{
			if (p.getCheckedIn() == true)
				model.listOfPassengers.remove(p);
		};
	}
	
	public void run()
	{
		
		for (int i=0 ; i < model.listOfPassengers.size();i++)
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
    	passengerIndex = r.nextInt(model.listOfPassengers.size());
    	model.currentPassenger = model.listOfPassengers.get(passengerIndex);
    		if(model.currentPassenger.getCheckedIn() == false )
    		{
    			float bagWeight =(float) r.nextInt(this.BagMaxRandomWeight - this.BagMinRandomWeight)+ this.BagMinRandomWeight;
    			model.currentPassenger.setBagWeight(bagWeight);
    			
    			float x = (float) r.nextInt(this.DimensionMaxRandom - this.DimensionMinRandom) + this.DimensionMinRandom;
    			float y = (float) r.nextInt(this.DimensionMaxRandom - this.DimensionMinRandom) + this.DimensionMinRandom;
    			float z = (float) r.nextInt(this.DimensionMaxRandom - this.DimensionMinRandom) + this.DimensionMinRandom;
        	
    			model.currentPassenger.setBagDimension(x, y, z);
    			
    			PassengerQueue.add(model.currentPassenger);
    		}// end of if
    		model.listOfPassengers.remove(passengerIndex);
    	
    }
    
    public String GenerateQueueDetails()
    {
    	String report =" ";
    	try
    	{
    	model.currentPassenger = PassengerQueue.peek();
    		
    		report+= String.format("%15s", model.currentPassenger.getFlightCode());
    		report+= String.format("%15s", model.currentPassenger.getFullName());
    		report+= String.format("%10.2f kg", model.currentPassenger.getBagWeight());
    		report+= String.format("%10s",model.currentPassenger.getBagDimension());
    	}
    	
    	catch(NullPointerException e)
    	{
    		System.err.println(e.getMessage());
    		System.out.println("The queue is empty");
    	}
    	catch(Exception e)
    	{
    		System.err.println(e.getMessage());
    	}
    		
    	return report;
    }
    
    
    public String DisplayPassengerDeskInfo()
    {
    	String report="";
    	
    	try
    	{
    	model.currentPassenger = PassengerQueue.remove();	
    	report+= String.format("%s is dropping off %n ", model.currentPassenger.getFirstName());
    	report+= String.format("1 bag of %f kg.%n ", model.currentPassenger.getBagWeight());
    	report+= String.format("A baggage fee of %n £%f is due. ", model.currentPassenger.getBagWeight());
    	}
    	catch(NullPointerException e)
    	{
    		System.err.println(e.getMessage());
    		System.err.println("The queue is empty");
    	}
    	
    	catch(Exception e)
    	{
    		System.err.println(e.getMessage());
    	}
    	
    	return report;
    }
	
	
	

}
