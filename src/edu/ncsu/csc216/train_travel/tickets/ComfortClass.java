/**
 *
 */
package edu.ncsu.csc216.train_travel.tickets;

import edu.ncsu.csc216.train_travel.transportation.Seat;
import edu.ncsu.csc216.train_travel.transportation.Train;


/**
 * @author kavitpatel
 */
public class ComfortClass extends Reservation {

    private Seat[] theSeats;

    private ComfortClass(int noOfPassengers, Train train) {
        super(noOfPassengers, train);
        theSeats = new Seat[noOfPassengers];
        for (int i = 0; i < noOfPassengers; ++i) {
            theSeats[i] = new Seat("", getTrainCarId());
        }
        // TODO Auto-generated constructor stub
    }

    public static ComfortClass newReservation(int noOfPassengers, Train train) {
        if (train.hasComfortClassRoomFor(noOfPassengers)) {
            return new ComfortClass(noOfPassengers, train);
        }
        return null;
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

        return reservationId + " Comfort Class " + seatsToString(theSeats);
    }

}
