
public class Passenger {
	
	private String bookingRefCode;
	private String flightCode;
	private Name PassengerName;
	private boolean checkedIn;
	private int[] dimension = {0,0,0};
	private double bagWeight = 0.0;

	
	
	
	public Passenger(String bookingRef, String flightCode, Name name)
	{

		this.setBookingRefCode(bookingRef);
		this.setFlightCode(flightCode);
		this.setOwnerName(name);
				
	}

	
	public String getInitials()
	{
		return this.getPassengerName().getInitials();
	}
	
	public String getFullname() {
        return this.getPassengerName().getFullName();
        
    }

    public Name getPassengerName() {
        return PassengerName;
    }
    
 
    
    public void setOwnerName(Name name) {
		
		this.PassengerName = name;	
	}


	public String getBookingRefCode() {
		return bookingRefCode;
	}



	public void setBookingRefCode(String bookingRefCode) {
		this.bookingRefCode = bookingRefCode;
	}



	public String getFlightCode() {
		return flightCode;
	}



	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}



	public boolean isCheckedIn() {
		return checkedIn;
	}



	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}



	public double getBagWeight() {
		return bagWeight;
	}



	public void setBagWeight(double bagWeight) {
		this.bagWeight = bagWeight;
	}



	public int[] getDimension() {
		
		return this.dimension;
			
			
	}


	public void setDimension(int[] dimension) {
		this.dimension = dimension;
	}
	
	
	
	

}
