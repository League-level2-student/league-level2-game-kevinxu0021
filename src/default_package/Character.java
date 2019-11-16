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

		if (up == true && y>0) {

			y -= speed;

		}
		if (down == true && y<800) {

			y += speed;

		}
		if (left == true && x>0) {

			x -= speed;

		}
		if (right == true && x<400) {

			x += speed;

		}

	}

	void draw(Graphics g) {
		g.fillRect(x, y, width, height);
	}

	int getX() {
		return x;
	}

	void setX(int x) {
		this.x = x;
	}

	int getY() {
		return y;
	}

	void setY(int y) {
		this.y = y;
	}

	int getSpeed() {
		return speed;
	}

	void setSpeed(int speed) {
		this.speed = speed;
	}
}
