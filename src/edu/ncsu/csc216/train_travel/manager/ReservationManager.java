/**
 *
 */
package edu.ncsu.csc216.train_travel.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import edu.ncsu.csc216.train_travel.tickets.BicycleClass;
import edu.ncsu.csc216.train_travel.tickets.ComfortClass;
import edu.ncsu.csc216.train_travel.tickets.EconomyClass;
import edu.ncsu.csc216.train_travel.tickets.Reservation;
import edu.ncsu.csc216.train_travel.transportation.Train;

/**
 * Created ReservationManager class.
 * @author kavitpatel
 */
public class ReservationManager implements TicketMaster {

	private final static int MAX_PASSENGERS_PER_RESERVATION = 0;
	private List<Reservation> theReservations = new ArrayList<Reservation>();
	private Train theTrain;
	private int noOfCars;

	/**
	 *Declares noOfCars.
	 *@param noOfCars noOfCars
	 */
	public ReservationManager(int noOfCars) {
		theTrain = new Train(noOfCars);
		this.noOfCars = noOfCars;
	}

	@Override
	public Reservation makeNewReservation(int noOfPassengers, String reservationOrTrainCar) {
		// TODO Auto-generated method stub
		if (noOfPassengers < 1)
			throw new IllegalArgumentException();
		if (reservationOrTrainCar.startsWith("C") || reservationOrTrainCar.startsWith("F")) {
			ComfortClass reservation = ComfortClass.newReservation(noOfPassengers, theTrain);
			theReservations.add(reservation);
			return reservation;
		} else if (reservationOrTrainCar.startsWith("E") || reservationOrTrainCar.startsWith("S")) {
			EconomyClass reservation = EconomyClass.newReservation(noOfPassengers, theTrain);
			theReservations.add(reservation);
			return reservation;
		} else if (reservationOrTrainCar.startsWith("B")) {
			BicycleClass reservation = BicycleClass.newReservation(noOfPassengers, theTrain);
			theReservations.add(reservation);
			return reservation;
		}
		throw new IllegalArgumentException();
	}

	@Override
	public void cancelReservation(String x) {
		// TODO Auto-generated method stub
		if (theReservations.stream().noneMatch(r -> r.getID() == Integer.parseInt(x)))
			throw new IllegalArgumentException();
		theReservations.stream().filter(r -> r.getID() == Integer.parseInt(x)).findFirst()
		.ifPresent(Reservation::cancel);
		theReservations = theReservations.stream().filter(r -> r.getID() != Integer.parseInt(x))
				.collect(Collectors.toList());

	}

	@Override
	public void changeSeats(String x, String y) {
		// TODO Auto-generated method stub
		if (theReservations.stream().noneMatch(reservation -> reservation.getID() == Integer.parseInt(x)))
			throw new IllegalArgumentException();
		theReservations.stream().filter(reservation -> reservation.getID() == Integer.parseInt(x)).findFirst()
		.ifPresent(v -> v.changeSeats(y));
	}

	@Override
	public String printReservationList() {
		StringBuilder sb = new StringBuilder();
		for (Reservation r : theReservations) {
			sb.append(r.toString()).append("\n");
		}
		return sb.toString();
	}

	@Override
	public String showMap(int carIndex) {
		return theTrain.getCarSeatMap(carIndex);
	}

	/**
	 * List that gets the Reservations. 
	 * @return theReservations.
	 */
	public List<Reservation> getTheReservations() {
		return theReservations;
	}

	@Override
	public int numberOfSeatMaps() {
		return noOfCars;
	}
}
