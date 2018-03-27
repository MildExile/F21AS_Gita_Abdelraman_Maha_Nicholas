package F21AS_Gita_Abdelraman_Maha_Nicholas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimulationController {
	//private CheckInModelForPassengerQueue theModel;
    private CheckInModel theModel;
    private SimulationGUI theView;
    private static int PositiveTimerAdjust = 500;
    private static int NegativeTimerAdjust = -500;

    private Thread[] cidThreads;
    private Thread[] paThreads;
    private NextPassenger nextPass = new NextPassenger();
    private CheckInDesk cid;
    private CheckInDesk cid2;
    private PassengerArrival pa;
    private PassengerArrival pa2;
    private CheckInDesk cid3;
    private CheckInDesk cid4;

    private Log logObj;

    public SimulationController(CheckInModel theModel, SimulationGUI theView) {
        this.theModel = theModel;

        this.theView = theView;

        theView.startSimulationListener(new StartSimulationController());
        theView.addCheckInDeskListener(new AddCheckInDeskController());
        theView.removeCheckInDeskListener(new RemoveCheckInDeskController());
        theView.addPassengerQueueListener(new AddPassengerQueueController());
        theView.removePassengerQueueListener(new RemovePassengerQueueController());
        theView.fastCheckInListener(new FastCheckInController());
        theView.slowCheckInListener(new SlowCheckInController());
        theView.fastPassengerArrivalListener(new FastPassengerArrivalController());
        theView.slowPassengerArrivalListener(new SlowPassengerArrivalController());
        theView.genLogReportListener(new GenLogReportController());

        /*Thread t1 = new Thread(theModel);
        t1.start();*/

        //theView.SetQueueInformation();

    }

    class StartSimulationController implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            theView.disableStartSimulationButton();

            theView.enableAddCheckInDeskButton();
            theView.enableRemoveCheckInDeskButton();
            theView.enableAddPassengerQueueButton();
            theView.enableRemovePassengerQueueButton();
            theView.enableFastCheckInButton();
            theView.enableSlowCheckInButton();
            theView.enableFastPassengerArrivalButton();
            theView.enableSlowPassengerArrivalButton();
            theView.enableGenLogReportButton();


            //the sharedObject
            NextPassenger np = new NextPassenger();

            pa = new PassengerArrival(np, theModel);
            PassengerQueueGUI pqGUI = new PassengerQueueGUI(theView, pa.getPQ());

            Thread arrive = new Thread(pa);
            arrive.start();

            //NextPassenger np2 = new NextPassenger();

            //pa2 = new PassengerArrival(np2, theModel);
            //PassengerQueueGUI pqGUI2 = new PassengerQueueGUI(theView, pa2.getPQ());

            cid = new CheckInDesk(theModel, np);
            CheckInDeskGUI cidGUI = new CheckInDeskGUI(theView, cid);
            FlightGUI flGUI = new FlightGUI(theView,cid);

            theView.setPassArrivalSpeed(pa.getPassArriveTimer());
            theView.setCheckInSpeed(cid.getCidTimer());

            Thread cidThread = new Thread(cid);
            cidThread.start();

            cid2 = new CheckInDesk(theModel, np);
            CheckInDeskGUI cidGUI2 = new CheckInDeskGUI(theView, cid2);
            FlightGUI flGUI2 = new FlightGUI(theView,cid2);
            Thread cid2Thread = new Thread(cid2);
            cid2Thread.start();

            cid3 = new CheckInDesk(theModel, np);
            CheckInDeskGUI cidGUI3 = new CheckInDeskGUI(theView, cid3);
            FlightGUI flGUI3 = new FlightGUI(theView,cid3);
            Thread cid3Thread = new Thread(cid3);
            cid3Thread.start();

            cid4 = new CheckInDesk(theModel, np);
            CheckInDeskGUI cidGUI4 = new CheckInDeskGUI(theView, cid4);
            FlightGUI flGUI4 = new FlightGUI(theView,cid4);
            Thread cid4Thread = new Thread(cid4);
            cid4Thread.start();

            theView.setVisible(true);
        }
    }


    class AddCheckInDeskController implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {


            /*CheckInDesk tempCid = new CheckInDesk(theModel, nextPass);
            CheckInDeskGUI tempGUI = new CheckInDeskGUI(theView, tempCid);
            Thread cidTempThread = new Thread();
            cidTempThread.start();*/

        }
    }

    class RemoveCheckInDeskController implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {

        }
    }

    class AddPassengerQueueController implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {

        }
    }

    class GenLogReportController implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            logObj = Log.getInstance();
            logObj.writeLogIntoFile();
            JOptionPane.showMessageDialog(null, "Please open output.txt in the resource folder to view the log");
        }
    }

    class RemovePassengerQueueController implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {

        }
    }

    class FastCheckInController implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (cid.getCidTimer() <= 0) {
                theView.disableFastCheckInButton();
            } else {
                theView.enableFastCheckInButton();
                theView.enableSlowCheckInButton();
                cid.adjustCheckInDeskTimer(NegativeTimerAdjust);
                theView.setCheckInSpeed(cid.getCidTimer());
            }
        }
    }

    class SlowCheckInController implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (cid.getCidTimer() >= 30000) {
                theView.disableSlowCheckInButton();
            } else {
                theView.enableSlowCheckInButton();
                theView.enableFastCheckInButton();
                cid.adjustCheckInDeskTimer(PositiveTimerAdjust);
                theView.setCheckInSpeed(cid.getCidTimer());
            }
        }
    }

    class FastPassengerArrivalController implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (pa.getPassArriveTimer() <= 0) {
                theView.disableFastPassengerArrivalButton();
            } else {
                theView.enableFastPassengerArrivalButton();
                theView.enableSlowPassengerArrivalButton();
                pa.adjustPassengerArrivalTimer(NegativeTimerAdjust);
                theView.setPassArrivalSpeed(pa.getPassArriveTimer());
            }
        }
    }

    class SlowPassengerArrivalController implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (pa.getPassArriveTimer() >= 30000) {
                theView.disableSlowPassengerArrivalButton();
            } else {
                theView.enableSlowPassengerArrivalButton();
                theView.enableFastPassengerArrivalButton();
                pa.adjustPassengerArrivalTimer(PositiveTimerAdjust);
                theView.setPassArrivalSpeed(pa.getPassArriveTimer());
            }
        }
    }
}
