package F21AS_Gita_Abdelraman_Maha_Nicholas;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class CheckInDesk extends Thread implements Subject{
    private PassengerQueue so;

    public CheckInDesk(PassengerQueue so)
    {
        this.so = so;
    }

    public void run() {

        while (!so.getDone()) {
            try {

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(DisplayPassengerDeskInfo());

            notifyObservers();
        }
        System.out.println("CheckInDesk Thread Finished");
    }

    public synchronized String DisplayPassengerDeskInfo()
    {
        String report="";
        try
        {
            Passenger p = so.get();
            report+= String.format("%s is dropping off %n ", p.getFirstName());
            report+= String.format("1 bag of %f kg.%n ", p.getBagWeight());
            report+= String.format("A baggage fee of %n £%f is due. ", p.getBagWeight());
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

    private List<Observer> registeredObservers = new LinkedList<Observer>();

    public synchronized void registerObserver(Observer obs) {
        registeredObservers.add(obs);
    }

    public synchronized void removeObserver(Observer obs) {
        registeredObservers.remove(obs);
    }

    public synchronized void notifyObservers() {
        for (Observer obs : registeredObservers)
            obs.update();
    }
}
