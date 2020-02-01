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
		speed = 1;
	}

	void update() {
		super.update();

		if (up == true && y > 0) {

			y -= speed;

		}
		if (down == true && y < 850) {

			y += speed;

		}
		if (left == true && x > 0) {

			x -= speed;

		}
		if (right == true && x < 450) {

			x += speed;

		}

	}

	void draw(Graphics g) {
		g.drawImage(Panel.characterImg, x, y, width, height, null);
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
