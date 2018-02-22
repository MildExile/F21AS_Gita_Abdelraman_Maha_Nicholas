package F21AS_Gita_Abdelraman_Maha_Nicholas;

public class Flight {

    private String destinationAirport;
    private String carrier;
    private int maxPassengers;
    private float maxBagWeight;
    private int maxBagVolume;
    private String flightCode;  //example "AA2453

    //declare constructors
    public Flight(String destinationAirport, String flightCode, String carrier, int maxPassengers, float maxBagWeight, int maxBagVolume) {

        this.destinationAirport = destinationAirport;
        this.flightCode = flightCode;
        this.carrier = carrier;
        this.maxPassengers = maxPassengers;
        this.maxBagWeight = maxBagWeight;
        this.maxBagVolume = maxBagVolume;
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
}