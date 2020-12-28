Robot robot = new Robot(0, 0, RIGHT, 99999);

int counter = 0;
while (robot.getX() < World.getWidth() - 1) {
	robot.move();
	counter = counter + 1;
}

robot.turnLeft();

for (int i = 0; i < counter; i++) {
	if (i % 2 == 0 && robot.hasAnyCoins()) {
		robot.putCoin();
	}
	robot.move();
}

robot.turnLeft();
while (robot.isFrontClear()) {
	robot.move();
}

robot.turnLeft();
while (robot.getX() != 0 || robot.getY() != 0) {
	robot.move();
}

robot.turnOff();