package edu.ncsu.csc216.train_travel.transportation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Testing FirstClassCar.
 * @author kavitpatel
 */
public class FirstClassCarTest {

	/**
	 * Testing car capacity. 
	 */
	@Test
	public void testGetCapacity() {
		assertEquals(FirstClassCar.getCapacity(), FirstClassCar.getNumSeatsPerRow() * FirstClassCar.getNumRows());
	}

	/**
	 * Testing getSeats.
	 */
	@Test
	public void testCarSeats() {
		FirstClassCar car = new FirstClassCar(1);
		Seat[][] seats = car.getSeats();

		int rowNumber = 0;
		for (Seat[] row : seats) {
			rowNumber++;
			char seatNumber = 'A';
			for (int i = 0; i < row.length; i++) {
				assertEquals(new Seat("" + rowNumber + seatNumber++, 1), row[i]);
			}
		}
	}

	/**
	 * Testing set seats and certain index. 
	 */
	@Test
	public void testSetSeats() {
		FirstClassCar car = new FirstClassCar(1);
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
	public void testSetGetCarNumber() {
		FirstClassCar car = new FirstClassCar(1);
		assertEquals(1, car.getCarNumber());
		car.setCarNumber(2);
		assertEquals(2, car.getCarNumber());
	}

	/**
	 * Testing seat for first class and asserting.  
	 */
	@Test
	public void testSeatFor() {
		FirstClassCar car = new FirstClassCar(1);
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
	 * Testing for exception label.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSeatForLabelThrow() {
		FirstClassCar car = new FirstClassCar(1);
		car.seatFor("234234");
	}

	/**
	 * Testing for exception, testing the seat. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSeatForThrow() {
		FirstClassCar car = new FirstClassCar(1);
		car.seatFor(1231231, 123123123);
	}

	/**
	 * Testing seat chart.
	 */
	@Test
	public void testSeatChart() {
		FirstClassCar car = new FirstClassCar(1);
		Seat[][] seats = car.getSeats();
		StringBuilder stringChart = new StringBuilder();
		for (Seat[] row : seats) {
			for (Seat seat : row) {
				stringChart.append(seat.toString());
			}
			stringChart.append(System.lineSeparator());
		}
		assertEquals(stringChart.toString(), car.getSeatMap());
	}

	/**
	 * Testing for open seats. 
	 */
	@Test
	public void testOpenSeats() {
		FirstClassCar car = new FirstClassCar(1);
		assertEquals(34, car.openSeatsLeft());
	}
}
