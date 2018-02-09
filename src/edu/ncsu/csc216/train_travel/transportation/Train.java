package edu.ncsu.csc216.train_travel.transportation;

public class Train {

	public static final String OUT_OF_RANGE_ERROR_MSG = "Train must have at least 4 but no more than 12 cars.";
	private static final int MIN_CARS = 4;
	private static final int MAX_CARS = 12;
	
	private int numFirstClassCars;
	private int comfortClassPassengers;
	private int economyClassPassengers;
	private int bicyclePassengers;
	private int numberOfCars;
	
	private TrainCar[] cars;
	
	public Train(int numberOfCars) {
		if(isOutOfRange(numberOfCars)) {
			throw new IllegalArgumentException(OUT_OF_RANGE_ERROR_MSG);
		}
		
		this.numFirstClassCars = (int) Math.floor((numberOfCars - 1) / 3);
		cars = new TrainCar[numberOfCars];
		int i =0;
		for(i = 0; i < numFirstClassCars; i++) {
			cars[i] = new FirstClassCar(i+1);
		}
		
		for(; i < numberOfCars - 1; i++) {
			cars[i] = new SecondClassCar(i+1);
		}
		
		cars[numberOfCars-1] = new BicycleTransportCar(numberOfCars);
	}
	
	private boolean isOutOfRange(int numberOfCars) {
		return numberOfCars < MIN_CARS || numberOfCars > MAX_CARS;
	}

	public int numCars() {
		return numberOfCars;
	}
	
	public int incComfortClassPassengers(int incBy) {
		return comfortClassPassengers += incBy;
	}
	
	public int incEconomyClassPassengers(int incBy) {
		return economyClassPassengers += incBy;
	}
	
	public int incBicycleClassPassengers(int incBy) {
		return bicyclePassengers += incBy;
	}
	
	public Seat getSeatFor(int x, int y, int z) {
		return null;
	}
	
	public Seat getSeatFor(int x, String y) {
		return null;
	}
	
	public boolean hasComfortClassRoomFor(int newBooking) {
		return comfortClassPassengers - newBooking > 0;
	}
	
	public boolean hasEconomyClassRoomFor(int newBooking) {
		return economyClassPassengers - newBooking > 0;
	}
	
	public boolean hasBicycleClassRoomFor(int newBooking) {
		return bicyclePassengers - newBooking > 0;
	}
	
	public int openSecondClassSeats() {
		int openSeats = 0;
		for(TrainCar car: cars) {
			if(car instanceof SecondClassCar) {
				openSeats += car.openSeatsLeft();
			}
		}
		return openSeats;
	}
	
	public int openFirstClassSeats() {
		int openSeats = 0;
		for(TrainCar car: cars) {
			if(car instanceof FirstClassCar) {
				openSeats += car.openSeatsLeft();
			}
		}
		return openSeats;
	}
	
	public boolean isBicycleCar(int idNumber) {
		return cars[idNumber - 1] instanceof BicycleTransportCar;
	}
	
	public boolean isSecondClassCar(int idNumber) {
		return cars[idNumber - 1] instanceof SecondClassCar;
	}
	
	public boolean isFirstClassCar(int idNumber) {
		return cars[idNumber - 1] instanceof FirstClassCar;
	}
	
	public String getCarSeatMap(int carIndex) {
		return cars[carIndex].getSeatMap();
	}
	
	public TrainCar getCar(int carIndex) {
		return cars[carIndex];
	}

}
