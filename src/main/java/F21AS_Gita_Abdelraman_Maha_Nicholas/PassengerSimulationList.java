package F21AS_Gita_Abdelraman_Maha_Nicholas;

import java.util.*;

public class PassengerSimulationList extends Thread implements Subject{

    private PassengerQueue so;
    private CheckInModel model;


    int BagMinRandomWeight = 5;
    int BagMaxRandomWeight = 50;
    int DimensionMinRandom = 10;
    int DimensionMaxRandom = 200;

    public PassengerSimulationList(PassengerQueue so, CheckInModel model)
    {
        this.so = so;
        this.model = model;
    }

    //run to create a producer to enter values into the shared object passenger class
    public void run() {

        for (int i = model.listOfPassengers.size() ; i > 0; i--)
        {

            try
            {
                Thread.sleep(500);
            }
            catch(InterruptedException e)
            {
                System.err.println(e.getMessage());
            }
            AppendIntoQueue();
        }
        System.out.println("Entire Passenger list queued");

        //way to terminate the consumer thread
        while (!so.getDone()) {
            if (so.isQueueEmpty()) {
                so.setDone();
            }
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                System.err.println(e.getMessage());
            }
            System.out.println(so.getDone());
        }
        System.out.println("End of Producer Thread");
    }

    /**
     * A method which traverse the PassengerList search for passengers who didn't check in
     * And append them into the queue
     */
    public void AppendIntoQueue()
    {
        Random r = new Random();
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

            so.put(model.currentPassenger);
        }// end of if

        System.out.println(GenerateQueueDetails());


        notifyObservers();

        model.listOfPassengers.remove(passengerIndex);

    }

    //format the passenger details into a string to be printed
    public synchronized String GenerateQueueDetails()
    {
        String report = "";
        try
        {
            Passenger p1 = model.currentPassenger;
            report+= String.format("%15s", p1.getFlightCode());

            report+= String.format("%15s", p1.getFullName());

            report+= String.format("%10.2f kg", p1.getBagWeight());
            report+= String.format("%10s", p1.getBagDimension());
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

    private List<Observer> registeredObservers = new LinkedList<Observer>();

    public synchronized void registerObserver(Observer obs) {
        registeredObservers.add(obs);
    }

    public synchronized void removeObserver(Observer obs) {
        registeredObservers.remove(obs);
    }

    public  synchronized void notifyObservers() {
        for (Observer obs : registeredObservers) {
            obs.update();
        }
    }
}
