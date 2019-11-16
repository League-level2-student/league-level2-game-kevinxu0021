package default_package;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Game {
	final static int width = 500;
	final static int height = 900;
	JFrame frame;
	Panel panel;

	Game() {
		frame = new JFrame();
		panel = new Panel();

	}

	public static void main(String[] args) {
		Game game = new Game();
		game.setup();
	}

	void setup() {
		frame.addKeyListener(panel);
		frame.addMouseListener(panel);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setPreferredSize(new Dimension(width, height));
		frame.setVisible(true);
		frame.pack();
		panel.startGame();

	}
}