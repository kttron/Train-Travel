package edu.ncsu.csc216.train_travel.tickets;

import edu.ncsu.csc216.train_travel.transportation.Train;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Testing ComfortClass 
 * @author kavitpatel
 */
public class ComfortClassTest {
	/**
	 * Testing new Reservation at given index and checking capacity. 
	 */
	@Test
	public void newReservationTest() {
		Train t = new Train(4);
		t.incComfortClassPassengers(400);
		assertTrue(t.hasComfortClassRoomFor(1));
		assertNull(ComfortClass.newReservation(10000, new Train(4)));
		assertNotNull(ComfortClass.newReservation(1, t));
	}

	/**
	 * Testing changing seats updating particular reservation.
	 */
	@Test
	public void changeSeatsTest() {
		Train t = new Train(4);
		ComfortClass c = ComfortClass.newReservation(5, t);
		c.changeSeats(t.getCar(1).seatFor(0, 0).toString());
	}

	/**
	 * Testing choosing seats, based on availability.
	 */
	@Test
	public void chooseSeatsTest() {
		Train t = new Train(4);
		ComfortClass c = ComfortClass.newReservation(5, t);
		c.changeSeats(t.getCar(1).seatFor(0, 0).toString());
		c.chooseSeats();
	}

	/**
	 * Testing getting seats based on input. 
	 */
	@Test
	public void getSetTrainTest() {
		Train t = new Train(4);
		ComfortClass c = ComfortClass.newReservation(5, t);
		assertEquals(t, c.getMyTrain());
		t = new Train(5);
		c.setMyTrain(t);
		assertEquals(t, c.getMyTrain());
	}

}
