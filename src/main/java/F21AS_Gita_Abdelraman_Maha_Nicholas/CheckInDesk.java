package F21AS_Gita_Abdelraman_Maha_Nicholas;

import java.util.LinkedList;
import java.util.List;
/**
 * This is a model for processing next passenger from the passenger Queue 
 * @author Nichloas Wiecek 
 *
 */
public class CheckInDesk extends Thread implements CSubject {
    private NextPassenger np;
    private Passenger p;
    private int cidTimer = 1000;

    public CheckInDesk(NextPassenger np)
    {
        this.np = np;
    }

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
            p = np.get();

            notifyCObservers();
            //System.out.println("check in desk working");
            //cm = np.get();
            //System.out.println(DisplayPassengerDeskInfo());
        }
        System.out.println("CheckInDesk Thread Finished");
    }

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

    public void adjustCheckInDeskTimer(int adjustedTime) {
        cidTimer = cidTimer + adjustedTime;
    }

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
