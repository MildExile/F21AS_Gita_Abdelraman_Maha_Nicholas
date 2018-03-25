package F21AS_Gita_Abdelraman_Maha_Nicholas;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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
        pqScroll.setPreferredSize(new Dimension(380,80));
        pqScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(pqScroll);
        theView.addPassengerQueuePanel(this);
    }

    public void update() {
        //System.out.println(pq.generateQueueDetails());
        //System.out.println(pq.getQM());
        /*if (pq.getQM() != null) {
            System.out.println(pq.getQM());
        }*/
        theView.addPassengerQueuePanel(this);

        String info = pq.getQueueSize() + " Passengers still waiting to check in:\n";
        info += pq.generateQueueDetails();

        pqList.setText(info);
        pqList.setVisible(true);

        theView.setVisible(true);

    }
}
