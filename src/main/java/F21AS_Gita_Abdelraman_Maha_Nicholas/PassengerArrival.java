package F21AS_Gita_Abdelraman_Maha_Nicholas;

import java.util.Random;

public class PassengerArrival implements Runnable {

    private CheckInModel theModel;
    //private CheckInModelForPassengerQueue theModel;
    private PassengerQueue pq;
    private NextPassenger np;
    private Passenger p;
    private int passArriveTimer = 1000;

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

    public void AppendIntoQueue()
    {
        Random r = new Random();
        int passengerIndex;
        passengerIndex = r.nextInt(theModel.listOfPassengers.size());
        p = theModel.listOfPassengers.get(passengerIndex);


        if(p.getCheckedIn() == false )
        {

            float bagWeight =(float) r.nextInt(this.BagMaxRandomWeight - this.BagMinRandomWeight)+ this.BagMinRandomWeight;
            p.setBagWeight(bagWeight);

            float x = (float) r.nextInt(this.DimensionMaxRandom - this.DimensionMinRandom) + this.DimensionMinRandom;
            float y = (float) r.nextInt(this.DimensionMaxRandom - this.DimensionMinRandom) + this.DimensionMinRandom;
            float z = (float) r.nextInt(this.DimensionMaxRandom - this.DimensionMinRandom) + this.DimensionMinRandom;


            p.setBagDimension(x, y, z);

            //np.put(model.currentPassenger);
            pq.addToQueue(p);
        }// end of if

        //System.out.println(generateQueueDetails());


        //notifyObservers();

        theModel.listOfPassengers.remove(passengerIndex);
    }

    public void adjustPassengerArrivalTimer(int adjustedTime) {
        passArriveTimer = passArriveTimer + adjustedTime;
    }

    public int getPassArriveTimer() {
        return passArriveTimer;
    }
}
