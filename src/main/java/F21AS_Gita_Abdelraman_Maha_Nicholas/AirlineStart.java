package F21AS_Gita_Abdelraman_Maha_Nicholas;

public class AirlineStart {

    public static void main(String[] args) {


        
        CheckInModel theCheckedModel= new CheckInModel();

        SimulationGUI theView = new SimulationGUI(theCheckedModel);

        SimulationController theController = new SimulationController(theCheckedModel,theView);

    }

}
