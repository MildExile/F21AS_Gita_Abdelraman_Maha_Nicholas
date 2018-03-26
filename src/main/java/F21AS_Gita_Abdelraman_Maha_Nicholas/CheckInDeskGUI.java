package F21AS_Gita_Abdelraman_Maha_Nicholas;


import javax.swing.*;
import java.awt.*;
/**
 * Class to process one passenger from the front of the passenger queue 
 * to be processed by the available checkIn Desk 
 * @author Nicholas Wiecek
 *
 */
public class CheckInDeskGUI extends JPanel implements CObserver {

    private SimulationGUI theView;
    private CheckInDesk cid;
    private JTextArea cidTextArea = new JTextArea();

    private Log logObj;


    //setup GUI for a check in desk
    public CheckInDeskGUI(SimulationGUI theView, CheckInDesk cid) {

        this.theView = theView;
        this.cid = cid;
        this.cid.registerCObserver(this);


        cidTextArea.setPreferredSize(new Dimension(180,80));
        cidTextArea.setLineWrap(true);
        cidTextArea.setWrapStyleWord(true);
        cidTextArea.setEditable(false);
        this.add(cidTextArea);
        theView.addCheckInDeskPanel(this);

    }

   

    public void update() {

        String info = "";
        if (!cid.getDone()) {
            info = cid.displayPassengerDeskInfo();
            cidTextArea.setText(info);

            logObj = Log.getInstance();
            logObj.insertLogsIntoArray(info);

        } else {
            this.removeAll();
        }



        theView.setVisible(true);
    }
}
