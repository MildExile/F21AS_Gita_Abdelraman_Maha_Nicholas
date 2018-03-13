package F21AS_Gita_Abdelraman_Maha_Nicholas;

public class SimulationController {
	private CheckInModelForPassengerQueue theModel;
    private SimulationGUI2 theView;

    public SimulationController(CheckInModelForPassengerQueue theModel, SimulationGUI2 theView) {
        this.theModel = theModel;
        
        this.theView = theView;
        
        
        Thread t1 = new Thread(theModel);
        t1.start();
        
        //theView.SetQueueInformation();
    }
    
    
}
