package F21AS_Gita_Abdelraman_Maha_Nicholas;


import java.util.*;

public class CheckInModelForPassengerQueue extends Thread /*implements Subject*/ {

	private NextPassenger np;
    private PassengerArrival pa;
	//private PassengerQueue psl;
	//private ArrayList<CheckInDesk> cids = new ArrayList<CheckInDesk>();
	private CheckInDesk cid;
	private CheckInDesk cid2;
	//private Thread[] cidThreads;
	private CheckInModel model;




	
	public CheckInModelForPassengerQueue(CheckInModel modelObj) {
		//super(bookingFile, flightFile);


		this.model = modelObj;

		//this.np = new NextPassenger();
        //


		/*for (int i = 0; i < 2; i++) {
			cids.add(new CheckInDesk(np));
		}*/


		for (Passenger p : model.listOfPassengers)
		{
			if (p.getCheckedIn() == true) {
				model.listOfPassengers.remove(p);
			}
		}

		//passengerArrives();
		//checkInDeskOpen();
		//runProducer();

		//runConsumer();


	}

    public void passengerArrives() {
	    Thread arrive = new Thread(pa);
	    arrive.start();
    }

    public void checkInDeskOpen() {

		this.cid = new CheckInDesk(np);

		Thread cidThread = new Thread(cid);
		cidThread.start();

		this.cid2 = new CheckInDesk(np);
		Thread cid2Thread = new Thread(cid);
		cid2Thread.start();
	}

	public CheckInDesk getCid() {
		return cid;
	}

	public PassengerQueue getPQ() {

		return pa.getPQ();
	}

	public PassengerArrival getPA() {
		return pa;
	}

	public NextPassenger getNP() {
		return np;
	}

	/*public synchronized PassengerQueue getPsl() {
		return psl;
	}

	public synchronized ArrayList<CheckInDesk> getCids() {
		return cids;
	}*/



	/*public void run()
	{
		try
		{
			Thread.sleep(100);
		}
		catch(InterruptedException e)
		{
			System.err.println(e.getMessage());
		}
		runProducer();
		runConsumer();
		so.setDone();


	}*/
}
