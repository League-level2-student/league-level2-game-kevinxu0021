
package default_package;

import java.awt.Graphics;
import java.util.Random;

public class Obstacles extends GameObject {
	Obstacles(int x, int y, int width, int height) {
		super(x, y, width, height);

	}

	void update() {
		super.update();

		y--;
	}

	void draw(Graphics g) {
		g.drawImage(Panel.trashImg, x, y, width, height, null);

	}
	void draw1(Graphics g) {
		g.drawImage(Panel.trashImg1, x, y, width, height, null);
	}
}