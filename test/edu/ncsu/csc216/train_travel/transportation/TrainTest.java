package edu.ncsu.csc216.train_travel.transportation;

import org.junit.Test;

import static edu.ncsu.csc216.train_travel.transportation.Train.OUT_OF_RANGE_ERROR_MSG;
import static org.junit.Assert.*;

/**
 * Testing Train
 * @author kavitpatel
 */
public class TrainTest {

	/**
	 * Testing out of range car. 
	 */
	@Test
	public void outOfRangeTest() {
		try {
			new Train(1);
			fail("Train cannot have less than 4 cars");
		} catch (IllegalArgumentException ie) {
			assertEquals(ie.getMessage(), OUT_OF_RANGE_ERROR_MSG);
		}

		try {
			new Train(13);
			fail("Train cannot have more than 13 cars");
		} catch (IllegalArgumentException ie) {
			assertEquals(ie.getMessage(), OUT_OF_RANGE_ERROR_MSG);
		}
	}

	/**
	 * Testing for success. 
	 */
	@Test
	public void successCreateTest() {
		new Train(4);
		new Train(5);
		new Train(7);
		new Train(8);
		new Train(9);
		new Train(10);
		new Train(11);
		new Train(12);
	}

	/**
	 * Testing for BicycleCar. 
	 */
	@Test
	public void testIsBicycleCar() {
		Train t = new Train(11);
		assertTrue(t.isBicycleCar(10));
		assertFalse(t.isBicycleCar(9));
	}

	/**
	 * Testing for second car. 
	 */
	@Test
	public void testIsSecondCar() {
		Train t = new Train(11);
		assertTrue(t.isSecondClassCar(9));
		assertFalse(t.isSecondClassCar(10));
	}

	/**
	 * Testing for fist car. 
	 */
	@Test
	public void testIsFirstCar() {
		Train t = new Train(11);
		assertTrue(t.isFirstClassCar(0));
		assertFalse(t.isFirstClassCar(9));
	}

	/**
	 * Testing to get car. 
	 */
	@Test
	public void testGetCar() {
		Train t = new Train(11);
		assertNotNull(t.getCar(1));
	}

	/**
	 * Testing for open seats. 
	 */
	@Test
	public void testOpenSeats() {
		Train t = new Train(4);
		assertEquals(34, t.openFirstClassSeats());
		assertEquals(152, t.openSecondClassSeats());
	}

	/**
	 * Testing for car numbers.
	 */
	@Test
	public void testNumCars() {
		Train t = new Train(4);
		assertEquals(4, t.numCars());
	}

}
