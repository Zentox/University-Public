int robotEqual(Robot a, Robot b) {
	if (a.getX() == b.getX() && a.getY() == b.getY()) {
		if (a.getDirection() == b.getDirection() && a.getNumberOfCoins() == b.getNumberOfCoins()) {
			return 2;
		} else {
			return 1;
		}
	}
	return 0;
}