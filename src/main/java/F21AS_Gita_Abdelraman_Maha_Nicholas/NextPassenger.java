package F21AS_Gita_Abdelraman_Maha_Nicholas;

import java.awt.peer.SystemTrayPeer;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NextPassenger implements Subject, QSubject, CSubject{

    private boolean empty;
    private boolean done;
    private Passenger p;


    public NextPassenger()
    {
        empty = true;
        done = false;

    }

    //get single passenger from queue and return string
    public synchronized Passenger get()
    {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        empty = true;
        notifyAll();


        return p;
    }

    //put the passenger into the queue to be used
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
        notifyAll();


    }

    public void setDone()
    {
        done = true;
    }

    public boolean getDone()
    {
        return done;
    }


    private List<QObserver> registeredQObservers = new LinkedList<QObserver>();

    public synchronized void registerQObserver(QObserver obs) {
        registeredQObservers.add(obs);
    }

    public synchronized void removeQObserver(QObserver obs) {
        registeredQObservers.remove(obs);
    }

    public synchronized void notifyQObservers() {
        for (QObserver obs : registeredQObservers)
            obs.update();
    }

    private List<CObserver> registeredCObservers = new LinkedList<CObserver>();

    public synchronized void registerCObserver(CObserver obs) {
        registeredCObservers.add(obs);
    }

    public synchronized void removeCObserver(CObserver obs) {
        registeredCObservers.remove(obs);
    }

    public synchronized void notifyCObservers() {
        for (CObserver obs : registeredCObservers)
            obs.update();
    }

    private List<Observer> registeredObservers = new LinkedList<Observer>();

    public synchronized void registerObserver(Observer obs) {
        registeredObservers.add(obs);
    }

    public synchronized void removeObserver(Observer obs) {
        registeredObservers.remove(obs);
    }

    public synchronized void notifyObservers() {
        for (Observer obs : registeredObservers) {
            obs.update();
        }
    }

}
