package default_package;

import java.awt.Color;
import java.awt.Graphics;

public class GamePanel {

	GamePanel() {

	}

	public void drawGameScreen(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, 500, 900);
	}

}
