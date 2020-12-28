// Creating a robot at position (0,0), direction to the right and with 99999
// coins
Robot robot = new Robot(0, 0, RIGHT, 99999);
// Moving the robot to the width of the world and stores it in a variable
int counter = 0;
while (robot.getX() < World.getWidth() - 1) {
	robot.move();
	counter = counter + 1;
}

// Turning the robot to the left (Direction.UP)
robot.turnLeft();

// The robot moves in the y-direction and places a coin at every straight
// position. The robot does this until the y-coordinate is greater than or equal
// to the size that the variable saved (width of the world)
for (int i = 0; i < counter; i++) {
	if (i % 2 == 0 && robot.hasAnyCoins()) {
		robot.putCoin();
	}
	robot.move();
}

// Turning the robot to the left (Direction.LEFT)
robot.turnLeft();
// Moving the robot until it hits a wall
while (robot.isFrontClear()) {
	robot.move();
}

// Turning the robot to the left (Direction.DOWN)
robot.turnLeft();
// Moving back to the starting position
while (robot.getX() != 0 || robot.getY() != 0) {
	robot.move();
}

// Turning the robot off
robot.turnOff();