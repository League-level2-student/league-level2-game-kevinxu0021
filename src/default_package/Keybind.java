package default_package;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Keybind implements KeyListener {
	JFrame frame;
	JPanel panel;

	Keybind() {
		frame = new JFrame();
		panel = new JPanel();
	}

	public static void main(String[] args) {
		Keybind keybind = new Keybind();

	}

	void setup() {
		frame.setSize(500, 900);
		frame.add(panel);
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
