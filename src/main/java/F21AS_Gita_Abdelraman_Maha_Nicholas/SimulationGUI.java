package F21AS_Gita_Abdelraman_Maha_Nicholas;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 * A Class that display the GUI 
 * it Includes all the buttons, JPanels and other information related to the passenger to be processed 
 * @authors
 *
 */
public class SimulationGUI extends JFrame  {

	private CheckInModel theModel;

	private JPanel passengerQueuePanel;
	private JPanel checkInDeskPanel;
	private JPanel flightPanel;
	private JPanel interactionPanel;
	private JButton startSimulation;

	private JButton addCheckInDesk;
	private JButton removeCheckInDesk;
	private JButton addPassengerQueue;
	private JButton removePassengerQueue;
	private JButton slowCheckIn;
	private JButton fastCheckIn;
	private JButton slowPassengerArrival;
	private JButton fastPassengerArrival;
	private JButton genLogReport;
	private JTextField checkInDeskSpeed;
	private JTextField passArrivalSpeed;
	private JTextField flightSpeed;


	/**
	 * Create the application.
	 */
	public SimulationGUI(CheckInModel theModel) {

		this.theModel = theModel;
		initialise();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialise() {
		//set up window title
		setTitle("Airline Check In Simulation");
		//ensure program ends when window closes
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(800,600));


		add(createStartPanel(),BorderLayout.NORTH);
		add(createSimulationPanel(),BorderLayout.CENTER);
		setVisible(true);
	}

	private JPanel createStartPanel() {
		startSimulation = new JButton("Start Simulation");
		JPanel northPanel = new JPanel();
		northPanel.add(startSimulation);
		return northPanel;
	}

	private JPanel createSimulationPanel() {


		passengerQueuePanel = new JPanel();
		passengerQueuePanel.setLayout(new GridLayout(0,1));
		JScrollPane pScroll = new JScrollPane(passengerQueuePanel);
		

		passArrivalSpeed = new JTextField();
		passArrivalSpeed.setEditable(false);
		//passArrivalSpeed.setText(String.valueOf("Passenger arrival speed now : " + theModel.getPA().getPassArriveTimer()));
		JPanel passArea = new JPanel();
		passArea.add(passArrivalSpeed, BorderLayout.NORTH);
		passArea.add(pScroll, BorderLayout.CENTER);
		passArea.setBorder(new LineBorder(new Color(0, 0, 0), 1));


		checkInDeskPanel = new JPanel();
		checkInDeskPanel.setLayout(new GridLayout(0,2));
		JScrollPane cScroll = new JScrollPane(checkInDeskPanel);
		

		checkInDeskSpeed = new JTextField();
		checkInDeskSpeed.setEditable(false);
		JPanel cidArea = new JPanel();
		cidArea.add(checkInDeskSpeed, BorderLayout.NORTH);
		cidArea.add(cScroll, BorderLayout.CENTER);
		cidArea.setBorder(new LineBorder(new Color(0, 0, 0), 1));

		flightPanel = new JPanel();
		flightPanel.setLayout(new GridLayout(0,2));
		JScrollPane fScroll = new JScrollPane(flightPanel);


		JPanel flightArea = new JPanel();
		flightArea.add(fScroll, BorderLayout.CENTER);
		flightArea.setBorder(new LineBorder(new Color(0, 0, 0), 1));

		interactionPanel = new JPanel();
		interactionPanel.setLayout(new GridLayout(0,2));

		addCheckInDesk = new JButton("Open a Check In Desk");
		removeCheckInDesk = new JButton("Close a Check In Desk");
		addPassengerQueue = new JButton("Open a Passenger Queue");
		removePassengerQueue = new JButton("Close a Passenger Queue");
		slowCheckIn = new JButton("Slow down Check In");
		fastCheckIn = new JButton("Speed up Check In");
		slowPassengerArrival = new JButton("Slow down Arrivals");
		fastPassengerArrival = new JButton("Speed up Arrivals");
		genLogReport = new JButton("Generate log report");

		
		addCheckInDesk.setEnabled(false);
		removeCheckInDesk.setEnabled(false);
		addPassengerQueue.setEnabled(false);
		removePassengerQueue.setEnabled(false);
		slowCheckIn.setEnabled(false);
		fastCheckIn.setEnabled(false);
		slowPassengerArrival.setEnabled(false);
		fastPassengerArrival.setEnabled(false);
		genLogReport.setEnabled(false);

		addCheckInDesk.setPreferredSize(new Dimension(150,40));
		removeCheckInDesk.setPreferredSize(new Dimension(150,40));
		addPassengerQueue.setPreferredSize(new Dimension(150,40));
		removePassengerQueue.setPreferredSize(new Dimension(150,40));
		slowCheckIn.setPreferredSize(new Dimension(150,40));
		fastCheckIn.setPreferredSize(new Dimension(150,40));
		slowPassengerArrival.setPreferredSize(new Dimension(150,40));
		fastPassengerArrival.setPreferredSize(new Dimension(150,40));
		genLogReport.setPreferredSize(new Dimension(150,40));

		//interactionPanel.add(addCheckInDesk);
		//interactionPanel.add(removeCheckInDesk);
		//interactionPanel.add(addPassengerQueue);
		//interactionPanel.add(removePassengerQueue);
		interactionPanel.add(slowCheckIn);
		interactionPanel.add(fastCheckIn);
		interactionPanel.add(slowPassengerArrival);
		interactionPanel.add(fastPassengerArrival);
		interactionPanel.add(genLogReport);

		JScrollPane iScroll = new JScrollPane(interactionPanel);
		iScroll.setBorder(new LineBorder(new Color(0, 0, 0), 1));

		JPanel simPanel = new JPanel(new GridLayout(2,2));
		simPanel.add(passArea);
		simPanel.add(cidArea);
		simPanel.add(flightArea);
		simPanel.add(iScroll);

		return simPanel;
	}

	public void startSimulationListener(ActionListener al) {
		startSimulation.addActionListener(al);
	}

	public void addPassengerQueueListener(ActionListener al) {
		addPassengerQueue.addActionListener(al);
	}

	public void removePassengerQueueListener(ActionListener al) {
		removePassengerQueue.addActionListener(al);
	}

	public void addCheckInDeskListener(ActionListener al) {
		addCheckInDesk.addActionListener(al);
	}

	public void removeCheckInDeskListener(ActionListener al) {
		removeCheckInDesk.addActionListener(al);
	}

	public void fastCheckInListener(ActionListener al) {
		fastCheckIn.addActionListener(al);
	}

	public void slowCheckInListener(ActionListener al) {
		slowCheckIn.addActionListener(al);
	}

	public void fastPassengerArrivalListener(ActionListener al) {
		fastPassengerArrival.addActionListener(al);
	}

	public void slowPassengerArrivalListener(ActionListener al) {
		slowPassengerArrival.addActionListener(al);
	}

	public void genLogReportListener(ActionListener al) {
		genLogReport.addActionListener(al);
	}


	public void disableStartSimulationButton() {
		startSimulation.setEnabled(false);
	}

	public void enableAddCheckInDeskButton() {
		addCheckInDesk.setEnabled(true);

	}

	public void disableAddCheckInDeskButton() {
		addCheckInDesk.setEnabled(false);
	}
	public void enableRemoveCheckInDeskButton() {
		removeCheckInDesk.setEnabled(true);

	}
	public void disableRemoveCheckInDeskButton() {
		removeCheckInDesk.setEnabled(false);
	}


	public void enableAddPassengerQueueButton() {
		addPassengerQueue.setEnabled(true);
	}

	public void disableAddPassengerQueueButton() {
		addPassengerQueue.setEnabled(false);
	}

	public void enableRemovePassengerQueueButton() {
		removePassengerQueue.setEnabled(true);
	}

	public void disableRemovePassengerQueueButton() {
		removePassengerQueue.setEnabled(false);
	}

	public void enableGenLogReportButton() {
		genLogReport.setEnabled(true);
	}

	public void disablegenLogReportButton() {
		genLogReport.setEnabled(false);
	}

	public void enableSlowCheckInButton() {
		slowCheckIn.setEnabled(true);
	}

	public void disableSlowCheckInButton() {
		slowCheckIn.setEnabled(false);
	}

	public void enableFastCheckInButton() {
		fastCheckIn.setEnabled(true);
	}

	public void disableFastCheckInButton() {
		fastCheckIn.setEnabled(false);
	}

	public void enableSlowPassengerArrivalButton() {
		slowPassengerArrival.setEnabled(true);

	}
	public void disableSlowPassengerArrivalButton() {
		slowPassengerArrival.setEnabled(false);
	}

	public void enableFastPassengerArrivalButton() {
		fastPassengerArrival.setEnabled(true);
	}

	public void disableFastPassengerArrivalButton() {
		fastPassengerArrival.setEnabled(false);
	}

	public void addPassengerQueuePanel(JPanel panel) {
		passengerQueuePanel.add(panel);
	}

	public void addCheckInDeskPanel(JPanel panel) {
		checkInDeskPanel.add(panel);
	}

	public void addFlightPanel(JPanel panel) {
		flightPanel.add(panel);
	}

	public void addInteractionPanel(JPanel panel) {
		interactionPanel.add(panel);
	}

	public void setCheckInSpeed(int checkInSpeed) {
		this.checkInDeskSpeed.setText("Check in desk speed now: " + String.valueOf(checkInSpeed));
	}

	public void setPassArrivalSpeed(int passArrivalSpeed) {
		this.passArrivalSpeed.setText("Passenger arrival speed now: " + String.valueOf(passArrivalSpeed));
	}

}

