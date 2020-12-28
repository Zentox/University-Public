public class SymmTurner extends Robot {

	public CoinMover(int x, int y) {
		super(x, y);
	}

	public CoinMover(int x, int y, Direction direction, int numberOfCoins) {
		super(x, y, direction, numberOfCoins);
	}

	public void coinMove(int numberOfSteps) {
		while (hasAnyCoins() && numberOfSteps > 0) {
			move();
			putCoin();
			numberOfSteps--;
		}
		if (numberOfSteps > 0) {
			turnOff();
		}
		putALlCoins();
	}

	public void putALlCoins() {
		while (hasAnyCoins()) {
			putCoin();
		}
	}
	
}