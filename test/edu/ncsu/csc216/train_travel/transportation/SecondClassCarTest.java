package edu.ncsu.csc216.train_travel.transportation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Testing SecondClassCar
 * @author kavitpatel
 */
public class SecondClassCarTest {

	/**
	 * Testing capacity.
	 */
	@Test
	public void testGetCapacity() {
		assertEquals(19 * 4, SecondClassCar.getCapacity());
	}

	/**
	 * Testing Reservation Limit. 
	 */
	@Test
	public void testGetReserveLimit() {
		assertEquals((int) Math.floor(19 * 4 * 1.1d), SecondClassCar.getReserveLimit());
	}

	/**
	 * Testing number of rows in the train class. 
	 */
	@Test
	public void testGetNumRows() {
		assertEquals(19, SecondClassCar.getNumRows());
	}

	/**
	 * Testing number of seats per row. 
	 */
	@Test
	public void testGetNumSeatsPerRow() {
		assertEquals(4, SecondClassCar.getNumSeatsPerRow());
	}

	/**
	 * Testing set seats. 
	 */
	@Test
	public void testSetSeats() {
		SecondClassCar car = new SecondClassCar(1);
		Seat[][] seats = car.getSeats();
		seats[1][1].reserve();
		car.setSeats(seats);
		seats = car.getSeats();
		assertTrue(seats[1][1].isReserved());
	}

	/**
	 * Testing getting car number.
	 */
	@Test
	public void testGetCarNumber() {
		SecondClassCar car = new SecondClassCar(1);
		assertEquals(1, car.getCarNumber());
		car.setCarNumber(2);
		assertEquals(2, car.getCarNumber());
	}


	/**
	 * Testing seat for. 
	 */
	@Test
	public void testSeatFor() {
		SecondClassCar car = new SecondClassCar(1);
		Seat[][] seats = car.getSeats();
		for (Seat[] row : seats) {
			for (Seat seat : row) {
				assertEquals(seat, car.seatFor(seat.getLabel()));
			}
		}
		for (int i = 0; i < seats.length; ++i) {
			for (int j = 0; j < seats[i].length; ++j) {
				assertEquals(seats[i][j], car.seatFor(i, j));
			}
		}
	}

	/**
	 * Testing for exception for label. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSeatForLabelThrow() {
		SecondClassCar car = new SecondClassCar(1);
		car.seatFor("234234");
	}

	/**
	 * Testing for exception for seat. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSeatForThrow() {
		SecondClassCar car = new SecondClassCar(1);
		car.seatFor(1231231, 123123123);
	}
}
