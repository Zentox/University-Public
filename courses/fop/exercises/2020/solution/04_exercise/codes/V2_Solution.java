public class Car {
	private String name;
	private double mileage;

	public Car(String name) {
		this.name = name;
		mileage = 0;
	}
	/**
	 * Drives the car by the given distance in kilometer.
	 * 
	 * @param distance distance that the car should drive
	 */
	public void drive(double distance) {
		mileage += distance;
	}
	/**
	 * Returns the mileage of this car.
	 * 
	 * @return the mileage of this car
	 */
	public double getMileage() {
		return mileage;
	}
	/**
	 * Returns the name of this car.
	 * 
	 * @return the name of this car
	 */
	public String getName() {
		return name;
	}
}