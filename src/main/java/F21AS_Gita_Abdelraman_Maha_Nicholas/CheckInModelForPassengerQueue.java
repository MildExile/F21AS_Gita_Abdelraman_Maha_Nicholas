package F21AS_Gita_Abdelraman_Maha_Nicholas;


import java.util.*;

public class CheckInModelForPassengerQueue extends Thread {

	private PassengerQueue so;

	private PassengerSimulationList psl;
	private ArrayList<CheckInDesk> cids = new ArrayList<CheckInDesk>();
	private CheckInDesk cid;
	private Thread[] cidThreads;
	private CheckInModel model;




	
	public CheckInModelForPassengerQueue(CheckInModel modelObj) {
		//super(bookingFile, flightFile);

		this.model = modelObj;
		this.so = new PassengerQueue();
		this.psl = new PassengerSimulationList(so,model);

		for (int i = 0; i < 2; i++) {
			cids.add(new CheckInDesk(so));
		}

		//this.cid = new CheckInDesk(so);

		for (Passenger p : model.listOfPassengers)
		{
			if (p.getCheckedIn() == true) {
				model.listOfPassengers.remove(p);
			}
		}

		runProducer();

		runConsumer();


	}

	public void runProducer()
	{
		Thread prodThread = new Thread(psl);

		prodThread.start();
	}

	public void runConsumer()
	{
		//Thread cidThread = new Thread(cid);

		//cidThread.start();

		cidThreads = new Thread[cids.size()];

		for (int i = 0; i < cids.size(); i++) {
			cidThreads[i] = new Thread(cids.get(i));

			cidThreads[i].start();
		}
	}

	public synchronized PassengerSimulationList getPsl() {
		return psl;
	}

	public synchronized ArrayList<CheckInDesk> getCids() {
		return cids;
	}

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
