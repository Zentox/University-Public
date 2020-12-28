public class TeamRobot extends Robot {
	private Robot[] partners;
	
	public TeamRobot(int x, int y, Direction direction, int numberOfCoins, int left, int right) {
		super(x, y, direction, numberOfCoins);
		partners = new Robot[left + right];
		for (int i = 0; i < left; i++) {
			partners[i] = new Robot(x - i - 1, y, direction, numberOfCoins);
		}
		for (int i = 0; i < right; i++) {
			partners[i + left] = new Robot(x + i + 1, y, direction, numberOfCoins);
		}
	}

	@Override
	public void move() {
		super.move();
		for (Robot r : partners) {
			r.move();
		}
	}

	@Override
	public void turnLeft() {
		super.turnLeft();
		for (Robot r : partners) {
			r.turnLeft();
		}
	}

	@Override
	public void putCoin() {
		super.putCoin();
		for (Robot r : partners) {
			r.putCoin();
		}
	}

	@Override
	public void pickCoin() {
		super.pickCoin();
		for (Robot r : partners) {
			r.pickCoin();
		}
	}
}