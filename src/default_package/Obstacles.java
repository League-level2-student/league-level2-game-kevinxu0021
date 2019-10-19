package default_package;

import java.awt.Graphics;
import java.util.Random;

public class Obstacles extends GameObject {

	Obstacles(int x, int y, int width, int height) {
		super(x, y, width, height);

	}

	void update() {
		super.update();
		Random random = new Random();
		x = random.nextInt();
		y++;
	}

	void draw(Graphics g) {
		g.fillRect(x, y, width, height);
	}

}
