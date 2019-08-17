package default_package;

import java.awt.Color;

import java.awt.Graphics;

public class Button {

	int x;
	int y;
	int width;
	int height;

	Button(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

	}

	public void rectangles(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, width, height);
	}

}
