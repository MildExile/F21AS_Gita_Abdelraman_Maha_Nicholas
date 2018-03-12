package F21AS_Gita_Abdelraman_Maha_Nicholas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SimulationGUI extends JFrame{
	
	private JPanel passengerQueuePanel, checkInCounterPanel, flightStatusPanel, buttonPanel;
	private JTextArea queueInformation;
	private JScrollPane scrollListForPassengerQueue;
	
	
	public SimulationGUI()
    {


        setTitle("Airport Information");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1300,800);
        setResizable(false);
        setLayout(new BorderLayout());
        
        
        
		SetupPassengerPanel();
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		SetupButtonPanel();
		
		flightStatusPanel = new JPanel();
		flightStatusPanel.setLayout(new FlowLayout());
		SetupFlightStatusPanel();
        // setup navigation panel
        
		checkInCounterPanel = new JPanel();
		checkInCounterPanel.setLayout(new FlowLayout());
        SetupCheckInCounterPanel();
        
        





    }



	private void SetupButtonPanel() {
		buttonPanel = new JPanel();
		
		
	}



	private void SetupFlightStatusPanel() {
		flightStatusPanel = new JPanel();
		
	}



	private void SetupCheckInCounterPanel() {
		checkInCounterPanel = new JPanel();
		
	}



	private void SetupPassengerPanel() {
		
		passengerQueuePanel = new JPanel();
		passengerQueuePanel.setLayout(new FlowLayout());
		this.add(passengerQueuePanel,BorderLayout.WEST);
		
		queueInformation = new JTextArea(80,80);
		queueInformation.setFont(new Font (Font.MONOSPACED, Font.PLAIN,12));
		queueInformation.setEditable(false);
        scrollListForPassengerQueue = new JScrollPane(queueInformation);
        passengerQueuePanel.add(scrollListForPassengerQueue,BorderLayout.CENTER);
        
		
	}
	
	public void SetQueueInformation(String passengerText) {
		queueInformation.setText(passengerText);
	}

	
}
