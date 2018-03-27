package F21AS_Gita_Abdelraman_Maha_Nicholas;

/**
 * Flight class which creates Flight Objects, process them and assign information
 * it has methods to display and process the required functionality for the Flight 
 * @author abood
 *
 */
public class Flight {

    private String destinationAirport;
    private String carrier;
    private int maxPassengers;
    private float maxBagWeight;
    private int maxBagVolume;
    private String flightCode;  //example "AA2453
    private int checkedInCount;
    private float currentVolume;
    private float currentBagWeight;

    //declare constructors
    public Flight(String destinationAirport, String flightCode, String carrier, int maxPassengers, float maxBagWeight, int maxBagVolume) {

        this.destinationAirport = destinationAirport;
        this.flightCode = flightCode;
        this.carrier = carrier;
        this.maxPassengers = maxPassengers;
        this.maxBagWeight = maxBagWeight;
        this.maxBagVolume = maxBagVolume;
        this.checkedInCount = 0;
        this.currentVolume = 0;
        this.currentBagWeight = 0.0f;
    }

    //create all getter methods
    public String getDestinationAirport() {
        return destinationAirport;
    }

    public String getCarrier() {
        return carrier;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public float getMaxBagWeight() {
        return maxBagWeight;
    }

    public int getMaxBagVolume() {
        return maxBagVolume;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void checkInPassenger() {
        checkedInCount++;
    }

    public int getCheckedInCount() {
        return checkedInCount;
    }

    public void addtoCurrentVolume(float currentVolume) {
        this.currentVolume += currentVolume;
    }

    public float getCurrentVolume() {
        return currentVolume;
    }

    public void addtoCurrentBagWeight(float currentBagWeight) {
        this.currentBagWeight += currentBagWeight;
    }
    public float getCurrentBagWeight() {
        return currentBagWeight;
    }

    public float holdFullVolume() {
        return ((currentVolume / maxBagVolume) * 100);
    }

    public float holdFullWeight() {
        return ((currentBagWeight / maxBagWeight) * 100);
    }
}