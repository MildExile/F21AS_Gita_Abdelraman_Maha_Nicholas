package F21AS_Gita_Abdelraman_Maha_Nicholas;

public class Passenger {
    private String bookingRefCode; //example "AA12345678"
    private String flightCode;
    private String firstName;
    private String lastName;
    private boolean checkedIn;
    private int bagVolume = 0;
    private float bagWeight = 0.0f;
    private float excessBagCost = 0.0f;

    private static final float excessBagLimit = 24;
    private static final float excessBagCostPerUnit =  10;

    public Passenger(String bookingRefCode, String flightCode, String firstName, String lastName, boolean checkedIn) {
        this.bookingRefCode = bookingRefCode;
        this.flightCode = flightCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.checkedIn = checkedIn;
    }


    public void setBagVolume(int bagVolume) {
        this.bagVolume = bagVolume;
    }

    public void setBagWeight(float bagWeight) {
        this.bagWeight = bagWeight;
    }

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    public void setexcessBagCost(float excessBagCost) {
        this.excessBagCost = excessBagCost;
    }

    public float getExcessBagCost() {
        return excessBagCost;
    }

    public String getBookingRefCode() {
        return this.bookingRefCode;
    }

    public String getFlightCode() {
        return this.flightCode;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }


    public boolean getCheckedIn() {
        return this.checkedIn;
    }

    public int getBagVolume() {
        return this.bagVolume;
    }

    public float getBagWeight() {
        return this.bagWeight;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    /**checks if there is excess baggage for the current passenger
     * @return true if passenger has excess baggage
     * @return false if passenger does not have excess baggage
     */
    public boolean isThereExcessBag(){
        if(this.bagWeight > excessBagLimit)
            return true;
        return false;
    }

    public void excessBagCalculation() {
        if (isThereExcessBag()) {
            this.excessBagCost = (this.getBagWeight() - excessBagLimit) * excessBagCostPerUnit;
        }
    }

}