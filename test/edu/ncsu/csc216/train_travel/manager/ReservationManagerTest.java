package edu.ncsu.csc216.train_travel.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import edu.ncsu.csc216.train_travel.tickets.Reservation;

/**
 * Creating and Testing ReservationManager class
 * 
 * @author kavitpatel
 */
public class ReservationManagerTest {

	/**
	 * Testing new ReservationManager index.
	 */
	@Test
	public void testReservationManager() {
		ReservationManager r = new ReservationManager(10);
		assertNotNull(r);
	}

	/**
	 * Testing ReservationManager failure, throw exception.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testReservationManagerFailure() {
		new ReservationManager(100);
	}

	/**
	 * Testing ReservationManager different seats.
	 */
	@Test
	public void testMakeNewReservation() {
		ReservationManager r = new ReservationManager(10);
		r.makeNewReservation(1, "C");
		r.makeNewReservation(1, "F");
		r.makeNewReservation(1, "E");
		r.makeNewReservation(1, "S");
		r.makeNewReservation(1, "B");
	}

	/**
	 * Testing to see if it throws illegalArguementException as it suppose to when
	 * given incorrect index seat input.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionMakeNewReservation() {
		ReservationManager r = new ReservationManager(10);
		r.makeNewReservation(10, "D");
	}

	/**
	 * Testing canceling a certain reservation.
	 */
	@Test
	public void testCancelReservation() {
		ReservationManager r = new ReservationManager(10);
		Reservation res = r.makeNewReservation(10, "B");
		r.cancelReservation("" + res.getID());
	}

	/**
	 * Testing canceling Reservation exception.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCancelReservationException() {
		ReservationManager r = new ReservationManager(10);
		Reservation res = r.makeNewReservation(10, "B");
		r.cancelReservation("12314" + res.getID());
	}

	/**
	 * Test to see if the ReservationList prints.
	 */
	@Test
	public void testPrintReservationList() {
		ReservationManager reservationManager = new ReservationManager(10);
		reservationManager.makeNewReservation(1, "C");
		reservationManager.makeNewReservation(1, "F");
		reservationManager.makeNewReservation(1, "E");
		reservationManager.makeNewReservation(1, "S");
		reservationManager.makeNewReservation(1, "B");
		List<Reservation> theReservations = reservationManager.getTheReservations();
		StringBuilder sb = new StringBuilder();
		for (Reservation r : theReservations) {
			sb.append(r.toString()).append("\n");
		}
		assertEquals(sb.toString(), reservationManager.printReservationList());
	}

}
