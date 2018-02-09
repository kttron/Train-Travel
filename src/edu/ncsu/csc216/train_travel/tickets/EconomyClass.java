/**
 *
 */
package edu.ncsu.csc216.train_travel.tickets;

import edu.ncsu.csc216.train_travel.transportation.Seat;
import edu.ncsu.csc216.train_travel.transportation.Train;

/**
 * @author kavitpatel
 */
public class EconomyClass extends Reservation {

    private boolean reservedSeats;
    private Seat[] theSeats;

    private EconomyClass(int noOfPassengers, Train train) {
        super(noOfPassengers, train);
        theSeats = new Seat[noOfPassengers];
        for (int i = 0; i < noOfPassengers; ++i) {
            theSeats[i] = new Seat("", getTrainCarId());
        }
        // TODO Auto-generated constructor stub
    }

    public static EconomyClass newReservation(int noOfPassengers, Train train) {
        if (train.hasEconomyClassRoomFor(noOfPassengers)) {
            return new EconomyClass(noOfPassengers, train);
        }
        return null;
    }

    public Seat[] getTheSeats() {
        return theSeats;
    }

    @Override
    public void chooseSeats() {
        for (Seat seat : theSeats) {
            seat.setReserved(true);
        }
    }

    @Override
    public void changeSeats(String newSeat) {
        cancel();
        Seat[] newSeats = parseSeats(newSeat);
        reassignSeats(newSeats, theSeats);
    }

    @Override
    public void cancel() {
        for (Seat seat : theSeats) {
            seat.setReserved(false);
        }
    }

    @Override
    public String toPrint() {
        int reservationId = getReservationID();

        return reservationId + " Economy Class " + seatsToString(theSeats);
    }

    public boolean isReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(boolean reservedSeats) {
        this.reservedSeats = reservedSeats;
    }
}
