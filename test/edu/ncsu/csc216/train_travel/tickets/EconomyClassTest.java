package edu.ncsu.csc216.train_travel.tickets;

import edu.ncsu.csc216.train_travel.transportation.Train;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Testing EconomyClass
 * @author kavitpatel
 */
public class EconomyClassTest {
   
	/**
    * Testing new Reservation in EconomyClass.
    */
	@Test
    public void newReservationTest() {
        Train t = new Train(4);
        t.incEconomyClassPassengers(400);
        assertTrue(t.hasEconomyClassRoomFor(1));
        assertNull(EconomyClass.newReservation(10000, new Train(4)));
        assertNotNull(EconomyClass.newReservation(1, t));
    }

	/**
	 * Testing changing seats in EconomyClass.
	 */
    @Test
    public void changeSeatsTest() {
        Train t = new Train(4);
        EconomyClass c = EconomyClass.newReservation(5, t);
        c.changeSeats(t.getCar(1).seatFor(0, 0).toString());
    }

    /**
     * Testing choosing seats in EconomyClass.
     */
    @Test
    public void chooseSeatsTest() {
        Train t = new Train(4);
        EconomyClass c = EconomyClass.newReservation(5, t);
        c.changeSeats(t.getCar(1).seatFor(0, 0).toString());
        c.chooseSeats();
    }

    /**
     * Testing printList in EconomyClass. 
     */
    @Test
    public void toPrintTest() {
        Train t = new Train(4);
        EconomyClass c = EconomyClass.newReservation(5, t);
        c.changeSeats(t.getCar(1).seatFor(0, 0).toString());
        assertEquals(c.getReservationID() + " Economy Class " + c.seatsToString(c.getTheSeats()), c.toPrint());
    }


}
