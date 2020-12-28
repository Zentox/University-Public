import fopbot.*;

public class FirstStepsBot {

	public static void main(String[] args) {
		World.setSize(10, 10);
		World.setDelay(200);
		World.setVisible(true);
		World.putCoins(4, 7, 1);

		// 1.
		Robot alice = new Robot(4, 4, Direction.RIGHT, 3);
		// 2.
		alice.move();
		alice.move();
		// 3.
		alice.turnLeft();
		// 4.
		alice.move();
		// 5.
		alice.putCoin();
		// 6.
		alice.move();
		alice.move();
		// 7.
		alice.putCoin();
		alice.putCoin();
		// 8.
		alice.turnLeft();
		// 9.
		alice.move();
		alice.move();
		// 10.
		alice.pickCoin();
		// 11.
		alice.move();
	}

}