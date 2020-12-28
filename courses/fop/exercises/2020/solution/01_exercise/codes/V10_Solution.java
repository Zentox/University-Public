Robot wally = new Robot(0, 0, RIGHT, 1);
while (wally.isFrontClear()) {
	wally.move();
}
wally.putCoin();
wally.turnLeft();
wally.turnLeft();
while (wally.getX() != 0 || wally.getY() != 0) {
	wally.move();
}