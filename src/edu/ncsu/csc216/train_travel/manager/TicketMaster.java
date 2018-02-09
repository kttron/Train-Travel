/**
 *
 */
package edu.ncsu.csc216.train_travel.manager;

import edu.ncsu.csc216.train_travel.tickets.Reservation;

/**
 * Created TicketMaster Interface.
 * @author kavitpatel
 */
public interface TicketMaster {

	/**
	 * makeNewReservation method.
	 * @param x x
	 * @param y y
	 * @return newReservation
	 */
	public Reservation makeNewReservation(int x, String y);

	/**
	 * cancelReservation method.
	 * @param x x
	 */
	public void cancelReservation(String x);

	/**
	 * changeSeats method.
	 * @param x x 
	 * @param y y
	 */
	public void changeSeats(String x, String y);

	/**
	 * Print the ReservationList.
	 * @return ReservationList
	 */
	public String printReservationList();

	/**
	 * Method to show the map of the Train.
	 * @param x x
	 * @return Map
	 */
	public String showMap(int x);

	/**
	 * Number of seats.
	 * @return number of seats
	 */
	public int numberOfSeatMaps();

}
