package F21AS_Gita_Abdelraman_Maha_Nicholas;

public class AirlineStart {

    public static void main(String[] args) {

        SimulationGUI theView = new SimulationGUI();

        CheckInModelForPassengerQueue theModel = new CheckInModelForPassengerQueue("src/main/resources/PassengerData.csv", "src/main/resources/FlightData.csv");
        
        SimulationController theController = new SimulationController(theModel, theView);

        theView.setVisible(true);

    }

}
