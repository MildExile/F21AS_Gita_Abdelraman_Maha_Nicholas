package F21AS_Gita_Abdelraman_Maha_Nicholas;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlightTest {

    private Flight f;

    @Before
    public void setUp() throws Exception {
        //String destinationAirport, String carrier, int maxPassengers, float maxBagWeight, int maxBagVolume
        f = new Flight("Washington","AA1234", "American Airlines", 280, 2500.0f,700000);
    }


    @Test
    public void testGet_DestinationAirport() {
        assertEquals("When object created destinationAirport should be Washington", "Washington", f.getDestinationAirport());
    }

    @Test
    public void testGet_FlightCode() {
        assertEquals("When object created flightCode should be AA1234", "AA1234", f.getFlightCode());
    }


    @Test
    public void testGet_Carrier() {
        assertEquals("When object created flightCode should be American Airlines", "American Airlines", f.getCarrier());
    }

    @Test
    public void testGet_MaxPassengers() {
        assertEquals("When object created maxPassengers should be 280", 280, f.getMaxPassengers());
    }

    @Test
    public void testGet_MaxBagWeight() {
        assertEquals("When object created maxBagWeight should be 2500.0f", 2500.0f, f.getMaxBagWeight(), 0.0f);
    }

    @Test
    public void testGet_MaxBagVolume() {
        assertEquals("When object created maxBagVolume should be 700000", 700000, f.getMaxBagVolume());
    }
}