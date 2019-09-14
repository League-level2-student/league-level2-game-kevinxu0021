package default_package;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Dropper {
	final static int width = 500;
	final static int height = 900;
	JFrame frame;
	Panel panel;
	GamePanel gamePanel;

	Dropper() {
		frame = new JFrame();
		panel = new Panel();
		gamePanel = new GamePanel();

	}

	public static void main(String[] args) {
		Dropper dropper = new Dropper();
		dropper.setup();
	}

	void setup() {
		frame.addKeyListener(panel);
		frame.addMouseListener(panel);
		frame.addKeyListener(gamePanel);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setPreferredSize(new Dimension(width, height));
		frame.setVisible(true);
		frame.pack();
		panel.startGame();

	}
}
