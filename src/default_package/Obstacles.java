package default_package;

import java.awt.Graphics;
import java.util.Random;

public class Obstacles extends GameObject {
Random random;
int number;
	Obstacles(int x, int y, int width, int height) {
		super(x, y, width, height);

	}

	void update() {
		super.update();

		y--;
	}

	void draw(Graphics g) {
		 random = new Random();
		 random.nextInt(2);
		 
		if(number == 1) {
		g.drawImage(Panel.trashImg, x, y, width, height, null);
		}
	}

}