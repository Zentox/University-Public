Robot bot1 = new Robot(3, 1, UP, 1);
bot1.move();
if (bot1.isNextToACoin()) {
	bot1.pickCoin();
} else {
	bot1.putCoin();
}