package default_package;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import keybinds.KeybindPanel;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
	Character character;
	KeybindPanel keybindPanel;
	int x = 100;

	boolean left = false;
	boolean right = false;

	GamePanel() {
		keybindPanel = new KeybindPanel();

	}

	public void paintComponemt(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, 500, 900);
		g.setColor(Color.GREEN);
		g.fillRect(x, 300, 50, 50);

	}

	public void update() {
		if (left == true) {
			x--;
		}
		if (right == true) {
			x++;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeybindPanel.left) {
			System.out.println("Left Pressed");
			x--;
			System.out.println(x);
		}
		if (e.getKeyCode() == KeybindPanel.right) {
			System.out.println("Right Pressed");
			right = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeybindPanel.left) {
			System.out.println("Left Pressed");
			left = false;
		}
		if (e.getKeyCode() == KeybindPanel.right) {
			System.out.println("Right Pressed");
			right = false;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}

}
