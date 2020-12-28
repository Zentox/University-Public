Robot bob = new Robot(8, 2, LEFT, 0);
int numberOfTurns = 0;
while (bob.getX() != 0) {
	while (bob.isNextToACoin()) {
		bob.pickCoin();
		numberOfTurns++;
	}
	bob.move();
}

for (int i = 0; i < numberOfTurns; i++) {
	bob.turnLeft();
}