package edu.ncsu.csc216.train_travel.transportation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Testing BicycleTransportCar
 * @author kavitpatel
 */
public class BicycleTransportCarTest {
   
	/**
    * Testing capacity of the Bicycle Transport Car compartment. 
    */
	@Test
    public void testGetCapacity() {
        assertEquals(40, BicycleTransportCar.getCapacity());
    }

	/**
	 * Testing for exception for index.
	 */
    @Test(expected = IllegalArgumentException.class)
    public void testSeatForIndex() {
        BicycleTransportCar car = new BicycleTransportCar(1);
        car.seatFor(1, 1);
    }

    /**
     * Testinf for exception for seat label.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSeatForLabel() {
        BicycleTransportCar car = new BicycleTransportCar(1);
        car.seatFor("123");
    }

    /**
     * Testing open seats left. 
     */
    @Test(expected = IllegalArgumentException.class)
    public void testOpenSeatsLeft() {
        new BicycleTransportCar(1).openSeatsLeft();
    }

    /**
     * Testing getting error message. 
     */
    @Test
    public void testGetSeatErrorMessage() {
        assertEquals("Seats cannot be reserved", BicycleTransportCar.getSeatErrorMessage());
    }

    /**
     * Testing getting set car. 
     */
    @Test
    public void testGetSetCar() {
        BicycleTransportCar car = new BicycleTransportCar(1);
        assertEquals(1, car.getCarNumber());
        car.setCarNumber(2);
        assertEquals(2, car.getCarNumber());
    }

}
