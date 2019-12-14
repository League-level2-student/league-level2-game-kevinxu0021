package default_package;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Obstacles extends GameObject {

	Obstacles(int x, int y, int width, int height) {
		super(x, y, width, height);
		
	}

	void update() {
		super.update();
		// Random random = new Random();
		// x += random.nextInt(21)-10;
		
		y++;
	}

	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
	}

}