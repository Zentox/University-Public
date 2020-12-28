Robot bot1 = new Robot(3, 1, UP, 1);
bot1.move();
if (bot1.isNextToACoin()) {
	bot1.pickCoin();
} else if (bot1.hasAnyCoins()) {
	bot1.putCoin();
}