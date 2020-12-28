/**
 * Computes the total sum of the area of the given geometry shapes.
 * 
 * @param circles    array of circles
 * @param rectangles array of rectangles
 * @return the total sum of the area of the given geometry shapes
 */
double computeTotalArea(Circle[] circles, Rectangle[] rectangles) {
	double sum = 0;
	for (Circle circle : circles)
		sum += circle.computeArea();
	for (Rectangle rectangle : rectangles)
		sum += rectangle.computeArea();
	return sum;
}