package default_package;

import java.awt.Graphics;

public class Character extends GameObject {
	int speed;
	boolean up = false;
	boolean down = false;
	boolean left = false;
	boolean right = false;

	Character(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 5;
	}

	void update() {
		super.update();

		if (up == true) {

			y -= speed;

		}
		if (down == true) {

			y += speed;

		}
		if (left == true) {

			x -= speed;

		}
		if (right == true) {

			x += speed;

		}

	}

	void draw(Graphics g) {
		g.fillRect(x, y, width, height);
	}
}
