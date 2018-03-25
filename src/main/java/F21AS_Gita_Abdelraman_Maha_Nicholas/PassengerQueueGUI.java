package F21AS_Gita_Abdelraman_Maha_Nicholas;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Class to process one passenger from the front of the passenger queue 
 * pass it to the NextPassenger which is the shared object to be passed next to the CheckInDesk in order to process the passenegr
 * @authors
 *
 */
public class PassengerQueueGUI extends JPanel implements QObserver {

    private SimulationGUI theView;
    private PassengerQueue pq;
    private NextPassenger np;
    private JTextArea pqList = new JTextArea();



    //setup GUI for a check in desk
    public PassengerQueueGUI(SimulationGUI theView, PassengerQueue pq) {
        this.theView = theView;
        this.pq = pq;
        pq.registerQObserver(this);

        pqList.setEditable(false);
        JScrollPane pqScroll = new JScrollPane(pqList);
        pqScroll.setPreferredSize(new Dimension(360,80));
        pqScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(pqScroll);
        theView.addPassengerQueuePanel(this);
    }

    public void update() {
  
       // theView.addPassengerQueuePanel(this);

        String info = pq.getQueueSize() + " Passengers still waiting to check in:\n";
        info += pq.generateQueueDetails();

        pqList.setText(info);


        theView.setVisible(true);

    }
}
