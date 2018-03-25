package F21AS_Gita_Abdelraman_Maha_Nicholas;

import java.util.Random;
/**
 * This class is used to simulate a passenger arriving at the airport and joining a queue, 
 * Passengers would come with luggage so this is where we give them luggage information
 *  before sending putting them in the queue, those information will be randomized 
 *  it implements thread to control how fast passengers arrive
 * @authors Nicholas, Gita, Maha & Abdelrahman
 *
 */
public class PassengerArrival implements Runnable {

    private CheckInModel theModel;
    private PassengerQueue pq;
    private NextPassenger np;// the sharedObject
    private Passenger p;
    private int passArriveTimer = 500;

    //Variables used for generating random BagWeight and Dimension for each passenger 
    int BagMinRandomWeight = 5;
    int BagMaxRandomWeight = 50;
    int DimensionMinRandom = 10;
    int DimensionMaxRandom = 200;

    public PassengerArrival(NextPassenger np, CheckInModel theModel) {
        this.np = np;
        this.theModel = theModel;
        this.np = new NextPassenger();
        this.pq = new PassengerQueue(np);
    }
    
    public PassengerQueue getPQ() {
        return pq;
    }

    public void run() {
    	//Assign a Thread to the queueOfPassengers 
        Thread passQueue = new Thread(pq);
        passQueue.start();

        for (int i = theModel.listOfPassengers.size(); i > 0; i--) {
            try {
                Thread.sleep(passArriveTimer);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
            AppendIntoQueue();
        }

        System.out.println("Entire Passenger list queued");
    }

    /**
     * Method used to assign passengers with random Bag Wieght and Dimension 
     * Then Appending them into the Queue 
     * However Passengers are appended randomly from ListOfPassengers Into the Queue
     */
    public void AppendIntoQueue()
    {
        Random r = new Random();
        int passengerIndex;
        // The next 2 following line code is used to get a random Passenger for ListOfPassenger
        //In order to be inserted into the queue 
        passengerIndex = r.nextInt(theModel.listOfPassengers.size());
        //Get that Passenger at specific index generated randomly within the listOfPassenger range i.e .size()
        p = theModel.listOfPassengers.get(passengerIndex);

        // Method to ensure that the passenger to be appended into the queue did not checkIn
        if(p.getCheckedIn() == false )
        {
        	
        	// The following method are used to generate random BagWeight and Dimension
            float bagWeight =(float) r.nextInt(this.BagMaxRandomWeight - this.BagMinRandomWeight)+ this.BagMinRandomWeight;
            p.setBagWeight(bagWeight);

            float x = (float) r.nextInt(this.DimensionMaxRandom - this.DimensionMinRandom) + this.DimensionMinRandom;
            float y = (float) r.nextInt(this.DimensionMaxRandom - this.DimensionMinRandom) + this.DimensionMinRandom;
            float z = (float) r.nextInt(this.DimensionMaxRandom - this.DimensionMinRandom) + this.DimensionMinRandom;


            p.setBagDimension(x, y, z);
            
            pq.addToQueue(p);
        }// end of if
        //Remove the passenger that has been inserted into the queue from the lisOfPassengers 
        theModel.listOfPassengers.remove(passengerIndex);
    }
    /**
     * Method used to control the run time of the queue which will be accessed through GUI 
     * @param adjustedTime
     */
    public void adjustPassengerArrivalTimer(int adjustedTime) {
        passArriveTimer = passArriveTimer + adjustedTime;
    }
    /**
     * a method which return the ArrivalTime for passenger to be used in Thread.wait()
     * @return
     */
    public int getPassArriveTimer() {
        return passArriveTimer;
    }
}
