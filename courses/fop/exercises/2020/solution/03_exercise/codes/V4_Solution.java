public interface ComputeArea {

	/**
	 * Computes the area.
	 * 
	 * @return the area
	 */
	double computeArea();
}
public class Circle implements ComputeArea {

	public double radius;

	@Override
	public double computeArea() {
		return 2 * Math.PI * radius * radius;
	}
}
public class Rectangle implements ComputeArea {

	public double length;
	public double width;

	@Override
	public double computeArea() {
		return length * width;
	}
}