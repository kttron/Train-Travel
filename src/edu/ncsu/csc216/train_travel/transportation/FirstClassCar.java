/**
 *
 */
package edu.ncsu.csc216.train_travel.transportation;

/**
 * @author kavitpatel
 */
public class FirstClassCar extends TrainCar {

    private static final int NUM_ROWS = 17;
    private static final int NUM_SEATS_PER_ROW = 2;
    private static final int CAPACITY = NUM_ROWS * NUM_SEATS_PER_ROW;
    private Seat[][] seats;
    private int carNumber;

    public FirstClassCar(int carNumber) {
        super(carNumber);
        this.seats = new Seat[NUM_ROWS][NUM_SEATS_PER_ROW];
        this.carNumber = carNumber;
        initSeats(seats);
    }

    public static int getCapacity() {
        return CAPACITY;
    }

    public static int getNumRows() {
        return NUM_ROWS;
    }

    public static int getNumSeatsPerRow() {
        return NUM_SEATS_PER_ROW;
    }

    public Seat[][] getSeats() {
        return seats;
    }

    public void setSeats(Seat[][] seats) {
        this.seats = seats;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public int openSeatsLeft() {
        return super.openSeatsLeft(seats);
    }

    @Override
    public Seat seatFor(int rowIndex, int columnIndex) throws IllegalArgumentException {
        try {
            return seats[rowIndex][columnIndex];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("The row, column are out of range");
        }
    }

    @Override
    public Seat seatFor(String label) {
        return super.seatFor(label, seats);
    }

    @Override
    public String getSeatMap() {
        return super.drawSeatChart(seats, 1);
    }

}
