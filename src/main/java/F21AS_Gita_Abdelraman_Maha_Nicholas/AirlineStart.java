package F21AS_Gita_Abdelraman_Maha_Nicholas;

public class AirlineStart {

    public static void main(String[] args) {

        SimulationGUI2 theView = new SimulationGUI2();
        
        CheckInModel theCheckedModel= new CheckInModel("src/main/resources/PassengerData.csv", "src/main/resources/FlightData.csv");

        CheckInModelForPassengerQueue theModel = new CheckInModelForPassengerQueue(theCheckedModel);
        
        SimulationController theController = new SimulationController(theModel, theView);

       
    }

}
