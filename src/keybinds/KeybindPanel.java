package keybinds;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import default_package.Button;

public class KeybindPanel extends JPanel implements ActionListener, KeyListener, MouseListener {

	static String Left = "A";
	static String Right = "D";

	public static int left = java.awt.event.KeyEvent.getExtendedKeyCodeForChar(Left.charAt(0));
	public static int right = java.awt.event.KeyEvent.getExtendedKeyCodeForChar(Right.charAt(0));

	int x = 300;
	int y = 100;
	int width = 75;
	int height = 25;

	int x2 = 300;
	int y2 = 200;
	int width2 = 75;
	int height2 = 25;

	Font font;

	Timer timer;

	Button button = new Button(x, y, width, height);
	Button button2 = new Button(x2, y2, width2, height2);

	public KeybindPanel() {
		timer = new Timer(1000 / 60, this);

		font = new Font("Arial", Font.PLAIN, 14);
	}

	void start() {
		timer.start();
	}

	public void paintComponent(Graphics g) {
		button.rectangles(g);
		button2.rectangles(g);
		g.setFont(font);
		g.drawString(Left, 333, 118);
		g.drawString(Right, 333, 218);
		g.drawString("Move Left", 100, 118);
		g.drawString("Move Right", 100, 218);
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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getPoint().x + ", " + e.getPoint().y);
		if (button.checkPressed(e.getPoint().x, e.getPoint().y) == true) {
			Left = JOptionPane.showInputDialog(null, "Type the key you want to move left.");
			Left = Left.substring(0, 1).toUpperCase();
			left = java.awt.event.KeyEvent.getExtendedKeyCodeForChar(Left.charAt(0));
		}
		if (button2.checkPressed(e.getPoint().x, e.getPoint().y) == true) {
			Right = JOptionPane.showInputDialog(null, "Type the key you want to move right.");
			Right = Right.substring(0, 1).toUpperCase();
			right = java.awt.event.KeyEvent.getExtendedKeyCodeForChar(Right.charAt(0));
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void draw() {
		// TODO Auto-generated method stub

	}
}
