package edu.ncsu.csc216.train_travel.tickets;

import edu.ncsu.csc216.train_travel.transportation.Train;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created and Testing BicycleClass.
 * @author kavitpatel
 */
public class BicycleClassTest {

	/**
	 * Testing for illegalArguementException at a certain index. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testChangeSeats() {
		BicycleClass b = BicycleClass.newReservation(1, new Train(4));
		b.changeSeats("123");
	}

	/**
	 * Testing BicycleClass constructor. 
	 */
	@Test
	public void testBicycleClassConstructor() {
		BicycleClass a = BicycleClass.newReservation(1, new Train(6));
		BicycleClass b = BicycleClass.newReservation(25, new Train(12));
		BicycleClass c = BicycleClass.newReservation(60, new Train(12));
		assertEquals(a.getClass(), BicycleClass.class);
		assertEquals(b.getClass(), BicycleClass.class);
		assertNull(c);
	}

	/**
	 * Testing printList when entered information about certain Reservation. 
	 */
	@Test
	public void testBicycleToPrint() {
		BicycleClass b = BicycleClass.newReservation(25, new Train(12));
		assertEquals("" + b.getReservationID() + " Bicycle Class " + b.getNumPassengers(), b.toPrint());

	}

	/**
	 * Testing to cancel a new Reservation.
	 */
	@Test
	public void testBicycleCancel() {
		BicycleClass b = BicycleClass.newReservation(25, new Train(12));
		b.cancel();

	}

	/**
	 * Testing choosing seats. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testChooseSeats() {
		BicycleClass.newReservation(1, new Train(1)).chooseSeats();
	}
}
