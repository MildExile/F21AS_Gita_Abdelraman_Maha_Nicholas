package F21AS_Gita_Abdelraman_Maha_Nicholas;


import javax.swing.*;
import java.awt.*;

public class CheckInDeskGUI extends JPanel implements CObserver {

    SimulationGUI theView;
    private CheckInDesk cid;
    private NextPassenger np;
    private JTextArea cidTextArea = new JTextArea();

    //setup GUI for a check in desk
    public CheckInDeskGUI(SimulationGUI theView, CheckInDesk cid) {

        this.theView = theView;
        this.cid = cid;
        cid.registerCObserver(this);


        cidTextArea.setPreferredSize(new Dimension(180,80));
        cidTextArea.setLineWrap(true);
        cidTextArea.setWrapStyleWord(true);
        cidTextArea.setEditable(false);
        this.add(cidTextArea);
        theView.addCheckInDeskPanel(this);

    }

    /*public void setCurrentlyDoingText() {
        String info = cid.DisplayPassengerDeskInfo();
        this.cidTextArea.setText(info);
    }*/

    public void update() {
        //System.out.println(cid.DisplayPassengerDeskInfo());
        //System.out.println(cid.getCM());
        /*if (cid.getCM() != null) {
            System.out.println(cid.getCM());
        }*/
        theView.addCheckInDeskPanel(this);
        String info = cid.DisplayPassengerDeskInfo();

        cidTextArea.setText(info);
        theView.setVisible(true);
    }
}
