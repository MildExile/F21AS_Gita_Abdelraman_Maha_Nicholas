package F21AS_Gita_Abdelraman_Maha_Nicholas;

import java.util.LinkedList;
import java.util.List;
/**
 * This is a model for processing next passenger from the passenger Queue 
 * it implements CSubject interface which has the methods for the observer 
 * including: remove, notify and register Observer
 * This class takes a passenger from the next in line of the passenger queue 
 * and processes it at the check in desk to update the flight information
 * it implements thread  to pull passengers from the shared object
 * This class is our consumer 
 * @author Nichloas Wiecek 
 *
 */
public class CheckInDesk extends Thread implements CSubject {
 
	//The shared object 
	private NextPassenger np;
	
    private Passenger p;
    //define CheckInDisk Timer in order to wait the thread 
    private int cidTimer = 1000;
    
    private Log logObj;

    public CheckInDesk(NextPassenger np)
    {
        this.np = np;
    }
    /**
     * a method which returns the nextPassenger to be processed by the CheckInDesk
     * @return NextPassenger Object which indicates the passenger to be processed 
     */
    public NextPassenger getNextPassenger() {
        return np;
    }

    public void run() {

        while (!np.getDone()) {
            try {
                System.out.println("check in desk sleeping");
                Thread.sleep(cidTimer);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
           
            //Get the nextPassenger from the shared Object to be processed 
            //And assign it to the Passenger Object to get information 
            //about that passenger 
            try
            {
            p = np.get();
            notifyCObservers();
            }
            catch(NullPointerException e)
            {
            	System.err.println(e.getMessage());
            }
            

        }
        System.out.println("CheckInDesk Thread Finished");
    }
    
    /**
     * A method which Display information for passengers 
     * While processing them in the CheckInDesk
     * @return report which a String that contains the required information to be displayed 
     */
    public String DisplayPassengerDeskInfo()
    {
        String report="";

        try
        {
            report+= String.format("%s is dropping off ", p.getFullName());
            report+= String.format("1 bag of %.2f kg.\n", p.getBagWeight());
            if (p.isThereExcessBag()) {
                report+= String.format("A baggage fee of £%.2f is due.", p.getBagWeight());
            }
            logObj = Log.getInstance();
            logObj.insertLogsIntoArray(report);
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
    /**
     * A method which allow the user to control the runTime of the CheckInDesk 
     * @param adjustedTime which is passed through the GUI
     */
    public void adjustCheckInDeskTimer(int adjustedTime) {
        cidTimer = cidTimer + adjustedTime;
    }
    
    /**
     * A method which returns the current time for CheckInDesk 
     * To be used in Thread.wait()
     * @return int cidTimer which indicates the time in milliseconds 
     */
    public int getCidTimer() {
        return cidTimer;
    }

    private List<CObserver> registeredCObservers = new LinkedList<CObserver>();

    public void registerCObserver(CObserver obs) {
        registeredCObservers.add(obs);
    }

    public void removeCObserver(CObserver obs) {
        registeredCObservers.remove(obs);
    }

    public void notifyCObservers() {
        for (CObserver obs : registeredCObservers)
            obs.update();
    }
}
