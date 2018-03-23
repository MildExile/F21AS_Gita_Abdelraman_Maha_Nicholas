package F21AS_Gita_Abdelraman_Maha_Nicholas;

import java.util.LinkedList;
import java.util.Queue;

public class PassengerQueue {

    private boolean firstRun;
    private boolean done;
    private Queue<Passenger> pq;


    public PassengerQueue()
    {
        firstRun = true;
        done = false;
        pq = new LinkedList<Passenger>();

    }

    //get single passenger from queue and return string
    public synchronized Passenger get()
    {
        while (isQueueEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        //notifyAll();
        return pq.remove();
    }

    //put the passenger into the queue to be used
    public synchronized void put(Passenger p) {
        this.pq.add(p);
        notifyAll();

    }

    public synchronized boolean isQueueEmpty()
    {
        if (firstRun) {
            firstRun = false;
        }
        if (pq.peek() == null)
        {
            if (firstRun) {
                firstRun = false;
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    public void setDone()
    {
        done = true;
    }

    public boolean getDone()
    {
        return done;
    }


}
