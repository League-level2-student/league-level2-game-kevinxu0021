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
	Character character = new Character(50, 100, 25, 25);
	ObjectManager objectManager = new ObjectManager(character);
	KeybindPanel keybindPanel;
	int x = 100;

	boolean left = false;
	boolean right = false;

	GamePanel() {
		keybindPanel = new KeybindPanel();

	}

	public void paintComponemt(Graphics g) {
		objectManager.draw(g);

	}

	void update() {
		objectManager.update();
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
			character.left = true;
		}
		if (e.getKeyCode() == KeybindPanel.right) {
			System.out.println("Right Pressed");
			character.right = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeybindPanel.left) {
			System.out.println("Left Pressed");
			character.left = false;
		}
		if (e.getKeyCode() == KeybindPanel.right) {
			System.out.println("Right Pressed");
			character.right = false;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		// update();
	}

}
