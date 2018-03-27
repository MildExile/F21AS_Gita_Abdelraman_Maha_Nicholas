package F21AS_Gita_Abdelraman_Maha_Nicholas;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PassengerTest {

    private Passenger p;

    @Before
    public void setUp() throws Exception {
        // String bookingRefCode, String flightCode, String firstName, String lastName, boolean checkedIn
        p = new Passenger("AA12345678", "AA1234", "George", "Stumble",false);
    }

    @Test
    public void testGetSet_Dimension() throws Exception {
        assertEquals("When object created dimensions should be 0", 0, p.getBagVolume());

        p.setBagVolume(230);
        assertEquals("Dimensions should be 230", 230 , p.getBagVolume());
    }	

    @Test
    public void testGetSet_BagWeight() throws Exception {
        assertEquals("When object created bagWeight should be 0.0F", 0.0f, p.getBagWeight(), 0.0f);

        p.setBagWeight(1.0f);
        assertEquals("bagWeight should be 1.0F", 1.0f, p.getBagWeight(), 0.0f);
    }

    @Test 
    public void testGetSet_CheckedIn() throws Exception {
        assertEquals("When object created checkedIn should be false", false, p.getCheckedIn());

        p.setCheckedIn(true);
        assertEquals("checkedIn should be true", true, p.getCheckedIn());
    }

    @Test
    public void testGetSet_ExcessBagCost() throws Exception {
        assertEquals("When object created excess bag cost should be 0", 0.0f, p.getBagVolume(),0.0f);

        p.setexcessBagCost(60);
        assertEquals("Dimensions should be 60", 60.0 , p.getExcessBagCost(), 0.0f);
    }

    @Test 
    public void testGet_BookingRefCode() throws Exception{
        assertEquals("When object created in Before bookingRefCode should be AA12345678", "AA12345678", p.getBookingRefCode());
    }

    @Test
    public void testGet_FlightCode() throws Exception{
        assertEquals("When object created in Before flightCode should be AA1234", "AA1234", p.getFlightCode());
    }

    @Test 
    public void testGet_FirstName() throws Exception{
        assertEquals("When object created in Before firstName should be George", "George", p.getFirstName());
    }

    @Test 
    public void testGet_LastName() throws Exception{
        assertEquals("When object created in Before lastName should be Stumble", "Stumble", p.getLastName());

    }

    @Test 
    public void testGet_FullName() throws Exception{
        assertEquals("When object created in Before fullName should be George Stumble", "George Stumble", p.getFullName());
    }
}