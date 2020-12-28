/**
 * Lays a {@link Coin} on every given {@link Point} and then goes to the center
 * of the {@link World}.
 * 
 * @param robot  the {@link Robot} protagonist
 * @param points an {@link Array} of {@link Point}s containing the Coordinates
 *               of the Pattern
 */
public static void putCoins(Robot robot, Point[] points) {
	// TODO Exercise V8.3
	for (Point point : points) {
		moveToPoint(robot, point);
		robot.putCoin();
	}
	goToPoint(r, new Point(5, 2));
	setDirection(r, UP);
}