package default_package;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Obstacles1 extends GameObject {
	public static BufferedImage trashImg1;

	public Obstacles1(int x, int y, int width, int height) {
		super(x, y, width, height);
		try {
			trashImg1 = ImageIO.read(this.getClass().getResourceAsStream("1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void update() {
		super.update();

		y--;
	}

	void draw(Graphics g) {
		g.drawImage(trashImg1, x, y, width, height, null);
	}

}
