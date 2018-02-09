/**
 *
 */
package edu.ncsu.csc216.train_travel.tickets;

import edu.ncsu.csc216.train_travel.transportation.Seat;
import edu.ncsu.csc216.train_travel.transportation.Train;

/**
 * @author kavitpatel
 */
public abstract class Reservation {

    private static final int MAX_PASSENGERS = 0;
    private static int number = 1000;
    protected Train myTrain;
    private int reservationID;
    private int numPassengers;
    private int trainCarId;

    public Reservation(int noOfPassengers, Train train) {
        this.reservationID = number++;
        this.myTrain = train;
        this.trainCarId = trainCarId;
    }

    public static boolean numPassengersinRange(int numPassengers) {
        return false;
    }

    public static int getNumber() {
        return number;
    }

    public static void setNumber(int number) {
        Reservation.number = number;
    }

    public int getTrainCarId() {
        return trainCarId;
    }

    public abstract void chooseSeats() throws IllegalArgumentException;

    public abstract void changeSeats(String newSeat) throws IllegalArgumentException;

    public abstract void cancel();

    public abstract String toPrint();

    public int getNumPassengers() {
        return numPassengers;

    }

    public void setNumPassengers(int numPassengers) {
        this.numPassengers = numPassengers;
    }

    public int getID() {
        return reservationID;
    }

    protected Seat[] parseSeats(String seatEntry) throws IllegalArgumentException {
        // 3-4A,3-4B,3-5A
        String[] seatsStr = seatEntry.split(",");
        for (int i = 0; i < seatsStr.length; ++i) {
            String[] seatStr = seatEntry.split("-");
            if (seatStr.length != 2) {
                throw new IllegalArgumentException();
            }
        }
        Seat[] seats = new Seat[seatsStr.length];

        int i = 0;
        for (String seatStr : seatsStr) {
            seats[i++] = parseSeat(seatStr);
        }

        return seats;
    }

    private Seat parseSeat(String seatStr) {
        String[] seatsParts = seatStr.split("-");
        int trainCarId = Integer.parseInt(seatsParts[0]);
        int rowNumber = Integer.parseInt(String.valueOf(seatsParts[1].charAt(0)));

        Seat seat = new Seat("" + rowNumber + seatsParts[1].charAt(1), trainCarId);
        return seat;
    }

    protected Seat[] reassignSeats(Seat[] to, Seat[] current) throws IllegalArgumentException {
        for (Seat seat : current) {
            seat.setReserved(false);
        }

        for (Seat seat : to) {
            if (seat == null) throw new IllegalArgumentException();
            seat.setReserved(true);
        }
        return to;
    }

    public String seatsToString(Seat[] seats) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (Seat seat : seats) {
            if (!sb.toString().equals("[")) {
                sb.append(",");
            }
            sb.append(seat.toString());
        }
        sb.append("]");
        return sb.toString();
    }

    public Train getMyTrain() {
        return myTrain;
    }

    public void setMyTrain(Train myTrain) {
        this.myTrain = myTrain;
    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }
}
