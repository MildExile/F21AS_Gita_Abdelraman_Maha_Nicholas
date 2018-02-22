
//Flight class

public class Flight {

private String destinationAirport;
private String carrier;
private int maxPassengers;
private int maxBagWeight;
private int maxBagVolume;
private String flightCode;  //example "AA2453


//declare constructors 
public Flight(String destinationAirport, String flightcode,String carrier, int maxPassengers, int maxBagWeight, int maxBagVolume){
	
this.setDestinationAirport(destinationAirport);
this.setFlightCode(flightcode);
this.setCarrier(carrier);
this.setMaxPassengers(maxPassengers);
this.setMaxBagWeight(maxBagWeight);
this.setMaxbagVolume(maxBagVolume);
}


//set destination airport
public void setDestinationAirport(String destinationAirport) {
	this.destinationAirport = destinationAirport;
	
}
//set carrier
public void setCarrier(String carrier) {
	this.carrier = carrier;
	
}
//set max number of passengers
public void setMaxPassengers(int maxPassengers) {
	this.maxPassengers = maxPassengers;
	
}

//set max bag weight 
public void setMaxBagWeight(int maxBagWeight) {
	this.maxBagWeight = maxBagWeight;
	
}

//set max bag volume
public void setMaxbagVolume(int maxBagVolume) {
	this.maxBagVolume = maxBagVolume;
	
}
//set flight code
public void setFlightCode(String flightCode ){
this.flightCode = flightCode;
}

//create all getter methods 
public String getDestinationAirport(){
return destinationAirport;
}
public String getCarrier(){
return carrier;
}
public int getMaxPassengers(){
return maxPassengers;
}
public int getMaxBagWeight(){
return maxBagWeight;
}
public int getMaxBagVolume(){
return maxBagVolume;
}

public String getFlightCode(){
return flightCode;
}
//organize output for a test class  
public String toString(){
return "Flight Code: " + getFlightCode() + "\nDestination Airport: " + getDestinationAirport() + "\nCarrier :" + getCarrier() + "\nMax Passengers:" + getMaxPassengers() + "\nMax Bag Weight: " + getMaxBagWeight() + "\nMax Bag Volume: " + getMaxBagVolume();
}



}