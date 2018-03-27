package F21AS_Gita_Abdelraman_Maha_Nicholas;

import java.util.LinkedList;
import java.util.List;

/**
 * This class acts like a shared object between the Passenger Queue and Check In Desk
 * This is the next passenger to be checkedIn on the top of the Passenger Queuer 
 * @author Nicholas Wiecek
 */
public class NextPassenger {

    private boolean empty;
    private boolean done;
    private Passenger p;


    public NextPassenger()
    {
        empty = true;
        done = false;

    }

   /**
    * a method that return the passenger object 
    * synchronized is used to When one thread is getting a Passenger object to be processed by CheckInDesk 
    * all other threads that invoke synchronized methods for the same object will block (suspend execution)
    * until the first thread is done with the object
    * In order to emphasis that one Passenger is processed at a time   
    * @return p which indicates the next passenger to be processed by CheckIn Desk
    */
    public synchronized Passenger get()
    {
    	//while true 
    	// a method to makes the checkIn desk Waits if there is no passenger 
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        empty = true;
        try
        {
        notifyAll();
        }
        catch(IllegalMonitorStateException e)
        {
        	System.err.println(e.getMessage());
        }
        return p;
    }

   /**
    * Method which puts the passenger into the sharedObject  
    * Also its synchronized in order to emphasis that one Passenger is processed at a time
    * and to prevent threads to overlap 
    * @param p to indicate which passenger to be inserted next 
    */
    public synchronized void put(Passenger p) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        empty = false;
        this.p = p;
        try
        {
        notifyAll();
        }
        catch(IllegalMonitorStateException e)
        {
        	System.err.println(e.getMessage());
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
