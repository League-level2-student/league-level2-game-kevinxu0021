package default_package;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Keybind implements KeyListener{
	JFrame frame;
	final static int width = 500;
	final static int height = 900;

	KeybindPanel keybindPanel;

	Keybind() {
		frame = new JFrame();
		keybindPanel = new KeybindPanel();
	}

	public void setup() {
		frame.addKeyListener(keybindPanel);
		frame.add(keybindPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setPreferredSize(new Dimension(width, height));
		frame.setResizable(false);
		frame.setVisible(true);
		frame.pack();
		frame.addMouseListener(keybindPanel);
		keybindPanel.start();
		keybindPanel.draw();
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
