import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI extends JFrame implements ActionListener {
	
	private PassengerList passengerList;
	private FlightList flightList;

	JPanel NavigationPane;
	private JButton Load;
	private JButton CheckInPassenger;
	private JButton Report;
	private JButton Close;
	private JPanel ListPanel,CheckInPanel;
	private JTextArea displayDetails;
	private JScrollPane scrollListForDetails;
	private JButton PassengerDetails;
	private JButton FlightDetails;
	private JLabel PassengerLastName;
	private JLabel PassengerBookingRef;
	private JTextField PassengerLastNameField;
	private JTextField BookingRefCodeField;
	private JButton CheckPassenger;
	private JTextArea displayCheckInPassenger;
	private JScrollPane scrollListForDetails2;
	private JButton ViewListOfCheckedIn;
	private JLabel Width;
	private JLabel Height;
	private JLabel Depth;
	private JTextField WidthField;
	private JTextField HeightField;
	private JTextField DepthField;
	private JButton SaveBagInfo;
	private JLabel Weight;
	private JTextField WeightField;
	private JLabel Fees;
	private JTextField FeesField;
	private JPanel GenerateReport;
	private JButton reportButton;

	
	public GUI(PassengerList list, FlightList list2)
	{
		
		passengerList = list;
		flightList = list2;
		
		setTitle("Airport Information");
		
		setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
		setSize(1300,800);
		setResizable(false);
		setLayout(new BorderLayout());
		
		// setup navigation panel
		SetupNavigation();
		
		
		// setup a panel to load passenger and flight detials
		ListPanel = new JPanel();
		ListPanel.setLayout(new FlowLayout());
		
		setupSouthPanelForLoadingDetails();
		setupNorthPanelForLoadingDetails();
		
		
		CheckInPanel = new JPanel();
		CheckInPanel.setLayout(new FlowLayout());
		
		//setupSouthPanelForCheckInPassenger();
		setupNorthPanelForCheckInPassenger();
		setupSouthPanelForCheckInPassenger();
		
		GenerateReport = new JPanel();
		GenerateReport.setLayout(new FlowLayout());
		
		
		//setupNorthPanelForReport();
		//setupSouthPanelForReport();
		
		
		
	}
	
	
	private void SetupNavigation() {
		// TODO Auto-generated method stub
		
		Load = new JButton("Load  Details");
		CheckInPassenger = new JButton("Check In");
		Close = new JButton("Close Application");
		reportButton = new JButton("Generate Report");
		
		
		NavigationPane = new JPanel();
		NavigationPane.setLayout(new GridLayout(4,1));
		this.add(NavigationPane,BorderLayout.EAST);
		NavigationPane.add(Load);
		NavigationPane.add(CheckInPassenger);
		NavigationPane.add(reportButton);
		NavigationPane.add(Close);
		
		
		
		Load.addActionListener(this);
		CheckInPassenger.addActionListener(this);
		Close.addActionListener(this);
		reportButton.addActionListener(this);

}

	/**
	 * Method used to create a Panel for setting up the passengers
	 * and the flight loading details 
	 */
	private void setupSouthPanelForLoadingDetails() {
		// TODO Auto-generated method stub
		
		displayDetails= new JTextArea(80,80);
		displayDetails.setFont(new Font (Font.MONOSPACED, Font.PLAIN,12));
		displayDetails.setEditable(false);
	    scrollListForDetails = new JScrollPane(displayDetails);
	    ListPanel.add(scrollListForDetails,BorderLayout.CENTER);
 	
		
	}
	
	

	private void setupNorthPanelForLoadingDetails() {
		// TODO Auto-generated method stub
		
		JPanel northPanelForPassengerAndFlightDetails = new JPanel();
		
		 PassengerDetails= new JButton("Load Passenger Details");
		 PassengerDetails.addActionListener(this);
	        
	     FlightDetails = new JButton("Load Flight Details");
	     FlightDetails.addActionListener(this);
	     
	     
	     northPanelForPassengerAndFlightDetails.add(PassengerDetails);
	     northPanelForPassengerAndFlightDetails.add(FlightDetails);
	     ListPanel.add(northPanelForPassengerAndFlightDetails, BorderLayout.NORTH);
		
	}
	
	
	
	public void setupSouthPanelForCheckInPassenger()
	{
		displayCheckInPassenger= new JTextArea(80,80);
		displayCheckInPassenger.setFont(new Font (Font.MONOSPACED, Font.PLAIN,12));
		displayCheckInPassenger.setEditable(false);
	    scrollListForDetails2 = new JScrollPane(displayCheckInPassenger);
	    CheckInPanel.add(scrollListForDetails2,BorderLayout.CENTER);

	}
	
	public void setupNorthPanelForCheckInPassenger()
	{	
		JPanel northPanelForPassengerCheckIn = new JPanel();
		JPanel northPanelForPassengerCheckIn2 = new JPanel();
		JPanel northPanelForPassengerCheckIn3 = new JPanel();
		JPanel northPanelForPassengerCheckIn4 = new JPanel();
		
		PassengerLastName = new JLabel("LastName");
		PassengerBookingRef = new JLabel("Booking Ref Code");
		
		PassengerLastNameField = new JTextField(20);
		BookingRefCodeField = new JTextField(20);
		
		PassengerLastName.setDisplayedMnemonic(KeyEvent.VK_P);
		PassengerLastName.setLabelFor(PassengerLastNameField);
		
		PassengerBookingRef.setDisplayedMnemonic(KeyEvent.VK_P);
		PassengerBookingRef.setLabelFor(BookingRefCodeField);
		
		CheckPassenger = new JButton("Check In");
		CheckPassenger.addActionListener(this);
		
		ViewListOfCheckedIn = new JButton("List of Checked In ");
		ViewListOfCheckedIn.addActionListener(this);
		
		Width = new JLabel("Width");
		Height = new JLabel("Height");
		Depth = new JLabel ("Depth");
		Weight = new JLabel("Weight");
		Fees = new JLabel("Addtional Fees");
		
		WidthField = new JTextField(20);
		HeightField = new JTextField(20);
		DepthField = new JTextField(20);
		WeightField = new JTextField(20);
		FeesField = new JTextField(20);
		
		Width.setDisplayedMnemonic(KeyEvent.VK_P);
		Width.setLabelFor(WidthField);
		
		Height.setDisplayedMnemonic(KeyEvent.VK_P);
		Height.setLabelFor(HeightField);
		
		Depth.setDisplayedMnemonic(KeyEvent.VK_P);
		Depth.setLabelFor(DepthField);
		
		Weight.setDisplayedMnemonic(KeyEvent.VK_P);
		Weight.setLabelFor(WeightField);
		
		Fees.setDisplayedMnemonic(KeyEvent.VK_P);
		Fees.setLabelFor(FeesField);
		
		SaveBagInfo = new JButton("Insert");
		SaveBagInfo.addActionListener(this);

		northPanelForPassengerCheckIn.add(PassengerLastName);
		northPanelForPassengerCheckIn.add(PassengerLastNameField);
		northPanelForPassengerCheckIn.add(PassengerBookingRef);
		northPanelForPassengerCheckIn.add(BookingRefCodeField);
		northPanelForPassengerCheckIn.add(CheckPassenger);
		northPanelForPassengerCheckIn3.add(Width);
		northPanelForPassengerCheckIn3.add(WidthField);
		northPanelForPassengerCheckIn3.add(Height);
		northPanelForPassengerCheckIn3.add(HeightField);
		northPanelForPassengerCheckIn3.add(Depth);
		northPanelForPassengerCheckIn3.add(DepthField);
		northPanelForPassengerCheckIn3.add(Weight);
		northPanelForPassengerCheckIn3.add(WeightField);
		northPanelForPassengerCheckIn3.add(SaveBagInfo);
		northPanelForPassengerCheckIn.add(Fees);
		northPanelForPassengerCheckIn.add(FeesField);
		
		
		
		northPanelForPassengerCheckIn.add(ViewListOfCheckedIn);
		CheckInPanel.add(northPanelForPassengerCheckIn,BorderLayout.NORTH);
		CheckInPanel.add(northPanelForPassengerCheckIn3,BorderLayout.NORTH);
		CheckInPanel.add(northPanelForPassengerCheckIn4,BorderLayout.NORTH);
		CheckInPanel.add(northPanelForPassengerCheckIn2,BorderLayout.NORTH);

		
		
		
	}
	
	
	/**
	 * Method to generate a report
	 */
	public void setupNorthPanelForReport()
	{
		JPanel northPanelForReport = new JPanel();
		
		 PassengerDetails= new JButton("Load Passenger Details");
		 PassengerDetails.addActionListener(this);
	        
	     FlightDetails = new JButton("Load Flight Details");
	     FlightDetails.addActionListener(this);
	     
	     
	     northPanelForReport.add(PassengerDetails);
	     northPanelForReport.add(FlightDetails);
	     GenerateReport.add(northPanelForReport, BorderLayout.NORTH);
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()== Load)
		{	//remove the rest of the panels
			this.remove(CheckInPanel);
			this.remove(GenerateReport);
			this.remove(Close);
			
			add(ListPanel,BorderLayout.CENTER);
			this.revalidate();
			this.repaint();
		}
		else if(e.getSource() == CheckInPassenger)
		{
			this.remove(ListPanel);
			this.remove(Close);
			this.remove(GenerateReport);
			
			add(CheckInPanel,BorderLayout.CENTER);
			this.revalidate();
			this.repaint();

		}
		
		else if(e.getSource()==PassengerDetails)
		{
			passengerList.readFileForPassenger("PassengerData.csv");
			String reslut = passengerList.generatePassengerInfo();
			displayDetails.setText(reslut);
		}
		
		else if(e.getSource() == FlightDetails)
		{
			flightList.readFileForFlight("FlightData.csv");
			String reslut = flightList.generateFlighInfo();
			displayDetails.setText(reslut);
		}
		
		else if(e.getSource() == CheckPassenger)
		{
			CheckInPassenger();
		}
		else if(e.getSource() == ViewListOfCheckedIn)
		{
			String reslut = passengerList.generateListOfCheckedInPassenger();
			displayCheckInPassenger.setText(reslut);
			
		}
		
		else if(e.getSource() == Close)
		{
			try
			{
			JOptionPane.showMessageDialog(null, "Are you sure you want to close");
			JOptionPane.showMessageDialog(null, "GOOD BYE");
			System.exit(0);
			}
			catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2.getMessage());
			}
		}
		
		else if(e.getSource() == SaveBagInfo)
		{
			if(WidthField.getText() == null) 
				JOptionPane.showMessageDialog(null,
						"MISSING WIDTH",
					    "ERROR",
					    JOptionPane.ERROR_MESSAGE);
			SavePassengerBagInfo();
			JOptionPane.showMessageDialog(null, "Inside the actionListener");
		}
		else if(e.getSource() == reportButton)
		{
			this.remove(CheckInPanel);
			this.remove(ListPanel);
			this.remove(Close);
			try {
			
				String report = flightList.GenerateReport();
				
				flightList.WriteToFile("report.txt", report);
				
				JOptionPane.showMessageDialog(null, 
	    				 report);
	    		
			}
			catch(Exception error)
			{
				JOptionPane.showMessageDialog(null, error.getMessage());
			}
		}
	}


	
	private void SavePassengerBagInfo() {
		// TODO Auto-generated method stub
		
		
		
		int  x = Integer.parseInt(WidthField.getText().trim());
		int  y = Integer.parseInt(HeightField.getText().trim());
		int  z = Integer.parseInt(DepthField.getText().trim());
		
		
		double weight  = Double.parseDouble(WeightField.getText().trim());
		String lastname = PassengerLastNameField.getText().trim();
		String BookingRef = BookingRefCodeField.getText().trim();
		try
		{
		passengerList.getBagInformation(lastname, BookingRef, x, y, z, weight);
		JOptionPane.showMessageDialog(null, "Inserted Successfully");
		}
		
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		FeesField.setText("got here before update");
		double reslut = passengerList.calculateExcessFees(lastname, BookingRef);
		String fees = String.valueOf(reslut);
		FeesField.setText(fees);
		
	}


	private void CheckInPassenger() {
		// TODO Auto-generated method stub
		
		String lastname = PassengerLastNameField.getText().trim();
		String BookingRef = BookingRefCodeField.getText().trim();
		
		// first we have to check if the passenger exists
		if (lastname == "" || BookingRef == "")
		{
			JOptionPane.showMessageDialog(null,
					"Passenger last name or booking reference is empty. Please enter the correct details",
				    "ERROR",
				    JOptionPane.ERROR_MESSAGE);
		}
		if((passengerList.findByBookingRefCode(BookingRef)!= null)&& (passengerList.findByLastName(lastname)!= null))
		{
			passengerList.CheckInBasedOnLastNameAndBookingRef(BookingRef, lastname);
			JOptionPane.showMessageDialog(null, "Successfuly CheckedIN");
		
		}
		
		else
		{
			JOptionPane.showMessageDialog(null, "Sorry no passenger exists with this bookingRefCode/ lastname");
		}
		
		
		
	}


	public void run()
	{
		
		setVisible(true);
	}
		
	}

