package default_package;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class KeybindPanel extends JPanel implements ActionListener, KeyListener {

	String Left = "A";
	String Right = "D";

	int x = 100;
	int y = 100;
	int width = 75;
	int height = 25;

	int x2 = 100;
	int y2 = 200;
	int width2 = 75;
	int height2 = 25;

	Font font;

	Timer timer;

	Button button = new Button(x, y, width, height);
	Button button2 = new Button(x2, y2, width2, height2);

	KeybindPanel() {
		timer = new Timer(1000 / 60, this);

		font = new Font("Arial", Font.PLAIN, 14);
	}

	void start() {
		timer.start();
	}

	void draw() {

	}

	public void paintComponent(Graphics g) {
		button.rectangles(g);
		button2.rectangles(g);
		g.setFont(font);
		g.drawString(Left, x, y);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
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
