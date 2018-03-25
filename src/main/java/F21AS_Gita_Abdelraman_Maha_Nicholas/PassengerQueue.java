package F21AS_Gita_Abdelraman_Maha_Nicholas;

import java.util.*;

public class PassengerQueue extends Thread implements QSubject{

    private NextPassenger np;
    private LinkedList<Passenger> pq = new LinkedList<Passenger>();
    //private boolean firstRun;
    private Passenger p;
    //private String qm;

    public PassengerQueue(NextPassenger np)
    {
        this.np = np;
        //this.firstRun = true;
    }

    public void addToQueue(Passenger p) {
        pq.add(p);
    }

    public int getQueueSize() {
        return pq.size()-1;
    }
    public NextPassenger getNextPassenger() {
        return np;
    }
/*    public String getQM() {
        return qm;
    }*/
    //run to create a producer to enter values into the shared object passenger class
    public void run() {
        while (pq.isEmpty()) {
            try {
                System.out.println("passenger queue sleeping");
                Thread.sleep(1000);
            } catch (InterruptedException e)
            {
                System.out.println(e);
            }
        }

        //way to terminate the consumer thread
        while (!pq.isEmpty()) {
            try
            {
                System.out.println("passenger queue working");
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                System.err.println(e.getMessage());
            }
            //get the top entry of the LinkedList
            //and assign it to a passenger
            p = pq.get(0);
            
            //put it into the synchronized shared object 
            np.put(p);

            notifyQObservers();

            //np.put(p);
            //qm = np.put(pq.remove());

            //System.out.println(generateQueueDetails());

        }

        System.out.println("End of Producer Thread");
        np.setDone();
    }

    //format the passenger details into a string to be printed
    public String generateQueueDetails() {

        // to remove the top entry of the queue 
        pq.remove(0);
        
        String report = "";
        for (int i = 0; i < pq.size(); i++) {

            try {
                report += String.format("%10s", pq.get(i).getFlightCode());
                report += String.format("%20s", pq.get(i).getFullName());
                report += String.format("%20.2f kg", pq.get(i).getBagWeight());
                report += String.format("%20s\n", pq.get(i).getBagDimension());
            } catch (NullPointerException e) {
                System.err.println(e.getMessage());
                System.out.println("The queue is empty");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }


        return report;
    }
    /**
     * A method which traverse the PassengerList search for passengers who didn't check in
     * And append them into the queue
     */

    private List<QObserver> registeredQObservers = new LinkedList<QObserver>();

    public void registerQObserver(QObserver obs) {
        registeredQObservers.add(obs);
    }

    public void removeQObserver(QObserver obs) {
        registeredQObservers.remove(obs);
    }

    public void notifyQObservers() {
        for (QObserver obs : registeredQObservers)
            obs.update();
    }
}
