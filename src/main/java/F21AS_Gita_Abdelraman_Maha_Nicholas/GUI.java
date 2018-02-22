package F21AS_Gita_Abdelraman_Maha_Nicholas;

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

public class GUI extends JFrame{

    //private PassengerList passengerList;
    //private FlightList flightList;
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

    public GUI()
    {


        setTitle("Airport Information");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        setupNorthPanelForCheckInPassenger();
        setupSouthPanelForCheckInPassenger();

        GenerateReport = new JPanel();
        GenerateReport.setLayout(new FlowLayout());





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

    }

    public void addLoadTabButtonListener(ActionListener listen) {
        Load.addActionListener(listen);
    }

    public void addCheckInTabButtonListener(ActionListener listen) {
        CheckInPassenger.addActionListener(listen);
    }

    public void addCloseApplicationTabButtonListener(ActionListener listen) {
        Close.addActionListener(listen);
    }

    public void addReportTabButtonListener(ActionListener listen) {
        reportButton.addActionListener(listen);
    }

    public void addFlightDetailsButtonListener(ActionListener listen) {
        FlightDetails.addActionListener(listen);
    }

    public void addPassengerDetailsButtonListener(ActionListener listen) {
        PassengerDetails.addActionListener(listen);
    }

    public void addCheckPassengerInButtonListener(ActionListener listen) {
        CheckPassenger.addActionListener(listen);
    }

    public void addViewListOfCheckedInButtonListener(ActionListener listen) {
        ViewListOfCheckedIn.addActionListener(listen);
    }

    public void addUpdateBagInfoButtonListener(ActionListener listen) {
        SaveBagInfo.addActionListener(listen);
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

        FlightDetails = new JButton("Load Flight Details");

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

        ViewListOfCheckedIn = new JButton("List of Checked In ");

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

    //TODO check if we need this
    /**
     * Method to generate a report
     */
    public void setupNorthPanelForReport()
    {
        JPanel northPanelForReport = new JPanel();

        PassengerDetails= new JButton("Load Passenger Details");

        FlightDetails = new JButton("Load Flight Details");


        northPanelForReport.add(PassengerDetails);
        northPanelForReport.add(FlightDetails);
        GenerateReport.add(northPanelForReport, BorderLayout.NORTH);
    }




    public int getBagDimension1(){
        return Integer.parseInt(WidthField.getText().trim());
    }

    public int getBagDimension2(){
        return Integer.parseInt(HeightField.getText().trim());
    }

    public int getBagDimension3(){
        return Integer.parseInt(DepthField.getText().trim());
    }

    public float getBagWeight(){
        return Float.parseFloat(WeightField.getText().trim());
    }

    //TODO get rid of these methods since not used
    public void setBagDimension1(int x){
        WidthField.setText(String.valueOf(x));
    }

    public void setBagDimension2(int y){
        HeightField.setText(String.valueOf(y));
    }

    public void setBagDimension3(int z){
        DepthField.setText(String.valueOf(z));
    }

    public void setBagWeight(int bagWeight) {
        WeightField.setText(String.valueOf(bagWeight));
    }

    public void setExcessFees(float excessFee) {
        FeesField.setText(String.valueOf(excessFee));
    }

    public String getPassengerLastName(){
        return PassengerLastNameField.getText().trim();
    }

    public String getBookingRefCode(){
        return BookingRefCodeField.getText().trim();
    }

    //TODO get rid of these methods since not used
    public void setPassengerLastName(String passengerLastName) {
        PassengerLastNameField.setText(passengerLastName);
    }

    public void setBookingRefCode(String bookingRefCode) {
        BookingRefCodeField.setText(bookingRefCode);
    }

    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void setViewOnLoadButton() {
        this.remove(CheckInPanel);
        this.remove(GenerateReport);
        this.remove(Close);

        add(ListPanel,BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }

    public void setViewOnCheckInPassengerButton() {
        this.remove(ListPanel);
        this.remove(Close);
        this.remove(GenerateReport);

        add(CheckInPanel,BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }

    public void setDisplayDetails(String inform) {
        displayDetails.setText(inform);
    }

    public void setViewListofCheckedIn(String inform) {
        displayCheckInPassenger.setText(inform);
        System.out.println(inform);
    }

    public void setOnCloseButton() {
        JOptionPane.showMessageDialog(null, "Are you sure you want to close");
        System.exit(0);
    }

    public void setOnReportButton() {
        this.remove(CheckInPanel);
        this.remove(ListPanel);
        this.remove(Close);
    }

}

