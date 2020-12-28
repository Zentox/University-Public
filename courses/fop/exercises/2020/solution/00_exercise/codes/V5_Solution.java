import fopbot.*;

public class Square {

	public static void main(String[] args) {
		World.setSize(10, 10);
		World.setDelay(100);
		World.setVisible(true);

		Robot alice = new Robot(0, 0, Direction.RIGHT, 20);
		Robot bob = new Robot(9, 9, Direction.LEFT, 20);

		while ((alice.getX() != 9 || alice.getY() != 9) && (bob.getX() != 0 || bob.getY() != 0)) {
			alice.putCoin();
			bob.putCoin();
			if (!alice.isFrontClear()) {
				alice.turnLeft();
			}
			if (!bob.isFrontClear()) {
				bob.turnLeft();
			}
			alice.move();
			bob.move();
		}
	}

}
