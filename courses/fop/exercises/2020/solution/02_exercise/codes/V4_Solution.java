Robot rabbit = new Robot(0, 0, RIGHT, 0);
Robot turtle = new Robot(0, 0, RIGHT, 0);

for (int i = 0; i < 10; i++) {

	if (i % 2 == 0) {
		rabbit.move();
	}

	rabbit.move();
	turtle.move();
}