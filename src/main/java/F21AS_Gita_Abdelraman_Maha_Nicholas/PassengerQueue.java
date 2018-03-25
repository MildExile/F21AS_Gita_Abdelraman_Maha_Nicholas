package F21AS_Gita_Abdelraman_Maha_Nicholas;

import java.util.*;
/**
 * This class has the actual Queue which uses a linkedList to store each passenger as they arrive
 * when passenger are at the top of the queue, 
 * It passes that passenger to NextPassenger which is our shared object in our producer consumer design pattern
 * This class implements threads  to allow time to be given to the shared object 
 * This class is our producer 
 * @authors 
 */
public class PassengerQueue extends Thread implements QSubject{

    private NextPassenger np;
    private LinkedList<Passenger> pq = new LinkedList<Passenger>();
  
    private Passenger p;


    public PassengerQueue(NextPassenger np)
    {
        this.np = np;
        //this.firstRun = true;
    }
    /**
     * A method which is used to append a passenger into a queue 
     * @param p
     */
    public void addToQueue(Passenger p) {
        pq.add(p);
    }
    /**
     * a method which return the size of the queue 
     * And it decrement it by 1 because a passenger is processed by CheckInDesk we remove it 
     * @return
     */
    public int getQueueSize() {
        return pq.size()-1;
    }
    public NextPassenger getNextPassenger() {
        return np;
    }

    
    /**
     * a run method to create a producer to enter values into the shared object passenger class
     */
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

        }

        System.out.println("End of Producer Thread");
        np.setDone();
    }

    
    /**
     * a method which is used to format the passenger details into a string to be printed
     * @return a string to be displayed on the CheckInDesk (GUI)
     */
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
