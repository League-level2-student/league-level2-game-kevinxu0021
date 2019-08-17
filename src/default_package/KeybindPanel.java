package default_package;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class KeybindPanel extends JPanel implements ActionListener, KeyListener {

	int x;
	int y;
	int width;
	int height;

	Timer timer;

	KeybindPanel() {
		timer = new Timer(1000 / 60, this);
	}

	void start() {
		timer.start();
	}

	void draw() {
		x = 0;
		y = 0;
		width = 75;
		height = 25;

		Button button = new Button(x, y, width, height);

		button.rectangles(getGraphics());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
