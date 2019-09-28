package default_package;

import java.awt.Graphics;

public class Character extends GameObject {
	int speed;
	boolean left = false;
	boolean right = false;

	Character(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 5;
	}

	void update() {
		super.update();
		if (left == true) {
			y -= speed;
		}
		if (right == true) {
			y += speed;
		}

	}

	void draw(Graphics g) {
		g.fillRect(x, y, width, height);
	}
}
