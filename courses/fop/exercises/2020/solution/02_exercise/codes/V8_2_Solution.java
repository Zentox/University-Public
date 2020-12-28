/**
 * Lets a given {@link Robot} move to a given {@link Point}.
 * 
 * @param robot the {@link Robot} to move
 * @param point the targeted {@link Point}
 */
public static void moveToPoint(Robot robot, Point point) {
	// TODO Exercise V8.2
	// Moves the robot to the given coordinate
	while (robot.getX() != point.getX() || robot.getY() != point.getY()) {
		// Moving right
		if (robot.getX() < point.getX()) {
			setDirection(robot, RIGHT);
			robot.move();
		}
		// Moving left
		else if (robot.getX() > point.getX()) {
			setDirection(robot, LEFT);
			robot.move();
		}
		// Moving up
		else if (robot.getY() < point.getY()) {
			setDirection(robot, UP);
			robot.move();
		}
		// Moving down
		else {
			setDirection(robot, DOWN);
			robot.move();
		}
	}
}