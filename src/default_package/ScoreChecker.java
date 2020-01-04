package default_package;

import java.awt.Color;
import java.awt.Graphics;

public class ScoreChecker extends GameObject {

	public ScoreChecker(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	void update() {
		super.update();
	}

	void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, width, height);
	}

}
