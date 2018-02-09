/**
 *
 */
package edu.ncsu.csc216.train_travel.tickets;

import edu.ncsu.csc216.train_travel.transportation.Train;

/**
 * Created BicycleClass
 * @author kavitpatel
 */
public final class BicycleClass extends Reservation {

	private BicycleClass(final int noOfPassengers, final Train train) {
		super(noOfPassengers, train);

	}

	/**
	 * Creating a newReservation with number of passengers. 
	 * @param noOfPassengers noOfPassengers
	 * @param train train
	 * @return bicycle
	 */
	public static BicycleClass newReservation(final int noOfPassengers, final Train train) {
		BicycleClass bicycle = null;
		if (train.hasBicycleClassRoomFor(noOfPassengers)) {
			bicycle =  new BicycleClass(noOfPassengers, train);
		}
		return bicycle;
	}

	/**
	 * chooseSeats.
	 */
	public void chooseSeats() {
		throw new IllegalArgumentException("Operation not supported");

	}

	/**
	 * changeSeats. 
	 * @param newSeat newSeat
	 */
	public void changeSeats(final String newSeat) {
		throw new IllegalArgumentException("Operation not supported");
	}

	/**
	 * Cancel.
	 */
	public void cancel() {

	}

	/**
	 * Prints the reservation.
	 * @return the reservation
	 */
	public String toPrint() {
		return "" + getReservationID() + " Bicycle Class " + getNumPassengers();
	}

}
