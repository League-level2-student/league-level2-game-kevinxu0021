
package button;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Button {

	int x;
	int y;
	int width;
	int height;

	public Button(int x, int y, int width, int height) {
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

	public boolean checkPressed(int mouseX, int mouseY) {
		if (mouseX < x + width && mouseX > x && mouseY < y + height + height && mouseY > y + height) {
			return true;
		} else {
			return false;
		}

	}

}