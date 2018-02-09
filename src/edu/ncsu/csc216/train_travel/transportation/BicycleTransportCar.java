/**
 *
 */
package edu.ncsu.csc216.train_travel.transportation;

/**
 * @author kavitpatel
 */
public class BicycleTransportCar extends TrainCar {

    private static final int CAPACITY = 40;
    private static final String SEAT_ERROR_MESSAGE = "Seats cannot be reserved";
    private int carNumber;

    public BicycleTransportCar(int carNumber) {
        super(carNumber);
        this.carNumber = carNumber;
    }

    public static int getCapacity() {
        return CAPACITY;
    }

    public static String getSeatErrorMessage() {
        return SEAT_ERROR_MESSAGE;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public int openSeatsLeft() {
        throw new IllegalArgumentException(SEAT_ERROR_MESSAGE);
    }

    @Override
    public Seat seatFor(int rowIndex, int columnIndex) {
        throw new IllegalArgumentException(SEAT_ERROR_MESSAGE);
    }

    @Override
    public Seat seatFor(String label) {
        // TODO Auto-generated method stub
        throw new IllegalArgumentException(SEAT_ERROR_MESSAGE);
    }

    @Override
    public String getSeatMap() {
        // TODO Auto-generated method stub
        return null;
    }
}
