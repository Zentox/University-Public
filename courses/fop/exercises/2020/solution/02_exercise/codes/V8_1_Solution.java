/**
 * Lets the given {@link Robot} look in a desired {@link Direction}.
 * 
 * @param robot     the {@link Robot} to turn
 * @param direction the desired{@link Direction}
 */
public static void setDirection(Robot robot, Direction direction) {
	// TODO Exercise V8.1
	while (robot.getDirection() != direction) {
		robot.turnLeft();
	}
}