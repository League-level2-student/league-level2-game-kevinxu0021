
package default_package;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Obstacles extends GameObject {
	public static BufferedImage trashImg;

	Obstacles(int x, int y, int width, int height) {
		super(x, y, width, height);
		try {
			trashImg = ImageIO.read(this.getClass().getResourceAsStream("trash.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void update() {
		super.update();

		y--;
	}

	void draw(Graphics g) {
		g.drawImage(trashImg, x, y, width, height, null);

	}

}