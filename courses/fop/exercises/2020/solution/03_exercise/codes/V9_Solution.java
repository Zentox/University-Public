public class DirectionTurner extends Robot {
	
	public DirectionTurner(int x, int y, Direction direction, int numberOfCoins) {
		super(x, y, direction, numberOfCoins);
	}

	public void turnUp() {
		while (!isFacingUp())
			turnLeft();
	}

	public void turnDown() {
		while (!isFacingDown())
			turnLeft();
	}

	public void turnLeft() {
		while (!isFacingLeft())
			turnLeft();
	}

	public void turnRight() {
		while (!isFacingRight())
			turnLeft();
	}
}