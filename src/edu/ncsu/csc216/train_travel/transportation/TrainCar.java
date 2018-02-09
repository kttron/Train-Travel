/**
 *
 */
package edu.ncsu.csc216.train_travel.transportation;

/**
 * @author kavitpatel
 */
public abstract class TrainCar {

    @SuppressWarnings("unused")
	private static final int ASCII_A = 0;
    private int carNumber;

    public TrainCar(int carNumber) {
        this.carNumber = carNumber;
    }

    public int getCarIDNumber() {
        return carNumber;
    }

    public abstract int openSeatsLeft();

    public abstract Seat seatFor(int rowIndex, int columnIndex) throws IllegalArgumentException;

    public abstract Seat seatFor(String label) throws IllegalArgumentException;

    public abstract String getSeatMap();

    protected void initSeats(Seat[][] seats) {
        if (seats == null) {
            return;
        }

        int rowNumber = 0;

        for (Seat[] row : seats) {
            rowNumber++;
            char seatNumber = 'A';
            for (int i = 0; i < row.length; i++) {
                row[i] = new Seat("" + rowNumber + seatNumber++, carNumber);
            }
        }
    }

    protected String drawSeatChart(Seat[][] seats, int aisleLocation) {
        StringBuilder stringChart = new StringBuilder();
        for (Seat[] row : seats) {
            for (Seat seat : row) {
                stringChart.append(seat.toString());
            }
            stringChart.append(System.lineSeparator());
        }
        return stringChart.toString();
    }

    protected Seat seatFor(String label, Seat[][] seats) throws IllegalArgumentException {
        for (Seat[] row : seats) {
            for (Seat seat : row) {
                if (seat.getLabel().equals(label)) {
                    return seat;
                }
            }
        }
        throw new IllegalArgumentException("The label is improper for this car");
    }

    protected int openSeatsLeft(Seat[][] seats) {
        int openSeats = 0;
        for (Seat[] row : seats) {
            for (Seat seat : row) {
                if (!seat.isReserved()) {
                    openSeats++;
                }
            }
        }
        return openSeats;
    }

}
