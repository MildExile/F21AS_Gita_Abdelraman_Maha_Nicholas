package F21AS_Gita_Abdelraman_Maha_Nicholas;

import javax.swing.*;
import java.awt.*;

public class FlightGUI extends JPanel implements FObserver {

    private SimulationGUI theView;
    private CheckInDesk cid;
    private JTextArea flightTextArea = new JTextArea();
    private Log logObj;

    public FlightGUI(SimulationGUI theView, CheckInDesk cid) {
        this.theView = theView;
        this.cid = cid;
        this.cid.registerFObserver(this);

        flightTextArea.setPreferredSize(new Dimension(180,80));
        flightTextArea.setLineWrap(true);
        flightTextArea.setWrapStyleWord(true);
        flightTextArea.setEditable(false);
        this.add(flightTextArea);
        theView.addFlightPanel(this);

    }

    public void update() {

        //get information from the model to update gui
        String flightInfo = cid.generateFlightDetails();
        flightTextArea.setText(flightInfo);
        System.out.println(cid.generateFlightDetails());

        logObj = Log.getInstance();
        logObj.insertLogsIntoArray(flightInfo);

        setVisible(true);

    }
}
