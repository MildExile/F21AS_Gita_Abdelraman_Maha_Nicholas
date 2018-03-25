package F21AS_Gita_Abdelraman_Maha_Nicholas;

public class AirlineStart {

    public static void main(String[] args) {


        
        CheckInModel theCheckedModel= new CheckInModel();

        //CheckInModelForPassengerQueue theModel = new CheckInModelForPassengerQueue(theCheckedModel);

        SimulationGUI theView = new SimulationGUI(theCheckedModel);

        SimulationController theController = new SimulationController(theCheckedModel,theView);

       /*GUI theView = new GUI();
       CheckInModel theModel = new CheckInModel("src/main/resources/PassengerData.csv", "src/main/resources/FlightData.csv");
       CheckInController theController = new CheckInController(theModel,theView);
       theView.setVisible(true);*/
    }

}
