package F21AS_Gita_Abdelraman_Maha_Nicholas;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class SimulationGUI extends JFrame /*implements Observer*/ {

	private CheckInModel theModel;

	/*private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JButton btnNewButton;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private List list;
	private List list_1;
	private List list_2;*/
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
	private JTextField checkInDeskSpeed;
	private JTextField passArrivalSpeed;
	private JTextField flightSpeed;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimulationGUI window = new SimulationGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public SimulationGUI(CheckInModel theModel) {

		this.theModel = theModel;
		/*theModel.getCid().registerObserver(this);*/

		initialise();
		//this.theModel.getCids().
		//theModel.getPsl().registerObserver(this);

		/*for (int i = 0; i < theModel.getCids().size(); i++) {
			theModel.getCids().get(i).registerObserver(this);
			System.out.println(theModel.getCids().get(i).getName());
		}*/

		//theModel.getCids().get(0).registerObserver(this);
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
		//pScroll.setBorder(new LineBorder(new Color(0, 0, 0), 1));

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
		//cScroll.setBorder(new LineBorder(new Color(0, 0, 0), 1));

		checkInDeskSpeed = new JTextField();
		checkInDeskSpeed.setEditable(false);
		//checkInDeskSpeed.setText("Check in desk speed now : " +String.valueOf(theModel.getCid().getCidTimer()));
		JPanel cidArea = new JPanel();
		cidArea.add(checkInDeskSpeed, BorderLayout.NORTH);
		cidArea.add(cScroll, BorderLayout.CENTER);
		cidArea.setBorder(new LineBorder(new Color(0, 0, 0), 1));

		flightPanel = new JPanel();
		flightPanel.setLayout(new GridLayout(0,3));
		JScrollPane fScroll = new JScrollPane(flightPanel);
		//fScroll.setBorder(new LineBorder(new Color(0, 0, 0), 1));

		flightSpeed = new JTextField();
		flightSpeed.setEditable(false);
		JPanel flightArea = new JPanel();
		flightArea.add(flightSpeed, BorderLayout.NORTH);
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

		addCheckInDesk.setEnabled(false);
		removeCheckInDesk.setEnabled(false);
		addPassengerQueue.setEnabled(false);
		removePassengerQueue.setEnabled(false);
		slowCheckIn.setEnabled(false);
		fastCheckIn.setEnabled(false);
		slowPassengerArrival.setEnabled(false);
		fastPassengerArrival.setEnabled(false);

		addCheckInDesk.setPreferredSize(new Dimension(150,40));
		removeCheckInDesk.setPreferredSize(new Dimension(150,40));
		addPassengerQueue.setPreferredSize(new Dimension(150,40));
		removePassengerQueue.setPreferredSize(new Dimension(150,40));
		slowCheckIn.setPreferredSize(new Dimension(150,40));
		fastCheckIn.setPreferredSize(new Dimension(150,40));
		slowPassengerArrival.setPreferredSize(new Dimension(150,40));
		fastPassengerArrival.setPreferredSize(new Dimension(150,40));

		interactionPanel.add(addCheckInDesk);
		interactionPanel.add(removeCheckInDesk);
		interactionPanel.add(addPassengerQueue);
		interactionPanel.add(removePassengerQueue);
		interactionPanel.add(slowCheckIn);
		interactionPanel.add(fastCheckIn);
		interactionPanel.add(slowPassengerArrival);
		interactionPanel.add(fastPassengerArrival);

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

	/*public void update() {
		CheckInDeskGUI cidGUI = new CheckInDeskGUI(theModel.getCid());
		checkInDeskPanel.add(cidGUI);
		cidGUI.setCurrentlyDoingText();
	}*/

	/*private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1800, 1200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel.setBounds(12, 12, 800, 500);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		list = new List();
		list.setBounds(22, 43, 746, 127);
		panel.add(list);

		list_1 = new List();
		list_1.setBounds(22, 208, 746, 127);
		panel.add(list_1);

		list_2 = new List();
		list_2.setBounds(22, 363, 746, 127);
		panel.add(list_2);

		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_1.setBounds(12, 524, 800, 500);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(51, 12, 248, 203);
		panel_1.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(475, 12, 248, 203);
		panel_1.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(475, 269, 248, 203);
		panel_1.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(51, 269, 248, 203);
		panel_1.add(textField_7);

		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_2.setBounds(938, 12, 800, 500);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		textField = new JTextField();
		textField.setBounds(69, 28, 248, 203);
		panel_2.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(493, 28, 248, 203);
		panel_2.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(69, 285, 248, 203);
		panel_2.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(493, 285, 248, 203);
		panel_2.add(textField_3);

		panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_3.setBounds(938, 524, 800, 500);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);

		btnNewButton = new JButton("New button");
		btnNewButton.setBounds(106, 77, 117, 25);
		panel_3.add(btnNewButton);

		button = new JButton("New button");
		button.setBounds(106, 294, 117, 25);
		panel_3.add(button);

		button_1 = new JButton("New button");
		button_1.setBounds(542, 77, 117, 25);
		panel_3.add(button_1);

		button_2 = new JButton("New button");
		button_2.setBounds(542, 294, 117, 25);
		panel_3.add(button_2);

		frame.setVisible(true);
	}*/

	/*public synchronized void update() {
		//updateQueuePanel();
		//updateCheckInDeskPanel();
		//updateFlightPanel();

	}

	public void updateQueuePanel() {
		String report = theModel.getPsl().GenerateQueueDetails();
		list.add(report);

	}

	public  void updateCheckInDeskPanel() {
		String report = theModel.getCids().get(0).DisplayPassengerDeskInfo();
		textField.setText(report);
		*//*for (int i = 0; i < theModel.getCids().size(); i++) {
			System.out.println(theModel.getCids().size());
			String report = theModel.getCids().get(i).DisplayPassengerDeskInfo();
			switch (i) {
				case 0 : textField.setText(report);
				case 1 : textField_1.setText(report);
			}

		}*//*
	}

	public void updateFlightPanel() {

	}*/
}

