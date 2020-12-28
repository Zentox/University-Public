int width = 3;
int height = 5;

// - 4 for edges (put coins only once)
int coins = 2 * width + 2 * height - 4;
Robot putbot = new Robot(0, 0, Direction.RIGHT, coins);
Robot pickbot = new Robot(0, 0, Direction.RIGHT, 0);

boolean swap = false;
int i = 1;
while (putbot.hasAnyCoins()) {
	putbot.putCoin();
	if (!swap && i == width || swap && i == height) {
		swap = !swap;
		i = 1;
		putbot.turnLeft();
	}
	putbot.move();
	i++;
}

swap = false;
i = 1;
int counter = 0;
while (counter < coins) {
	pickbot.pickCoin();
	counter++;
	if (!swap && i == width || swap && i == height) {
		swap = !swap;
		i = 1;
		pickbot.turnLeft();
	}
	pickbot.move();
	i++;
}