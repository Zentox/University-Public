// Robot bot
int startX = bot.getX();
int startY = bot.getY();

// x coordinate
if (startX != destinationX) {
	if (startX - destinationX > 0) {
		while (!bot.isFacingLeft()) {
			bot.turnLeft();
		}
	} else {
		while (!bot.isFacingRight()) {
			bot.turnLeft();
		}
	}
	while (bot.getX() != destinationX)
		bot.move();
}
// y coordinate
if (startY != destinationY) {
	if (startY - destinationY > 0) {
		while (!bot.isFacingDown()) {
			bot.turnLeft();
		}
	} else {
		while (!bot.isFacingUp()) {
			bot.turnLeft();
		}
	}
	while (bot.getY() != destinationY) {
		bot.move();
	}
}