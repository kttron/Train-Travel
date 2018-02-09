package edu.ncsu.csc216.train_travel.transportation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Testing Seat
 * @author kavitpatel
 */
public class SeatTest {

	/**
	 * Testing compare to different seats.
	 */
	@Test
	public void testCompareTo() {
		Seat seat1 = new Seat("17B", 1);
		Seat seat2 = new Seat("1A", 2);

		assertTrue(seat1.compareTo(seat2) < 0);
		assertTrue(seat2.compareTo(seat1) > 0);

		seat1 = new Seat("2C", 3);
		seat2 = new Seat("4A", 3);

		assertTrue(seat1.compareTo(seat2) < 0);
		assertTrue(seat2.compareTo(seat1) > 0);

		seat1 = new Seat("2B", 2);
		seat2 = new Seat("2C", 2);

		assertTrue(seat1.compareTo(seat2) < 0);
		assertTrue(seat2.compareTo(seat1) > 0);
	}

	/**
	 * Testing equals between given seats. 
	 */
	@Test
	public void testEquals() {
		Seat seat = new Seat("18b", 123);
		Seat seat2 = new Seat("18b", 123);
		assertTrue(seat.equals(seat2));
		seat2.setLabel("1");
		assertFalse(seat.equals(seat2));
	}

	/**
	 * Testing seat reserve. 
	 */
	@Test
	public void testReserve() {
		Seat seat = new Seat("18b", 123);
		assertFalse(seat.isReserved());
		seat.reserve();
		assertTrue(seat.isReserved());
	}

	/**
	 * Testing Release, if seat is reserved or not. 
	 */
	@Test
	public void testRelease() {
		Seat seat = new Seat("18b", 123);
		seat.reserve();
		assertTrue(seat.isReserved());
		seat.release();
		assertFalse(seat.isReserved());
	}

	/**
	 * Testing toString.
	 */
	@Test
	public void toStringTest() {
		Seat s1 = new Seat("12B", 2);
		assertEquals("2-12B", s1.toString());
	}

	/**
	 * Testing HashCode.
	 */
	@Test
	public void testHashCode() {
		Seat seat = new Seat("18b", 123);
		assertEquals(47083264, seat.hashCode());
	}

	/**
	 * Testing getting ID. 
	 */
	@Test
	public void testGetTrainCarID() {
		Seat seat = new Seat("18b", 123);
		assertEquals(123, seat.getTrainCarID());
	}
}
