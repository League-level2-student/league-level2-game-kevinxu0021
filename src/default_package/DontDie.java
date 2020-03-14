package default_package;

import java.awt.Dimension;

import javax.swing.JFrame;

public class DontDie {
	final static int width = 500;
	final static int height = 900;
	JFrame frame;
	Panel panel;

	DontDie() {
		frame = new JFrame();
		panel = new Panel();

	}

	public static void main(String[] args) {
		DontDie dontDie = new DontDie();
		dontDie.setup();
	}

	void setup() {
		frame.addKeyListener(panel);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setPreferredSize(new Dimension(width, height));
		frame.setVisible(true);
		frame.pack();
		panel.startGame();

	}
}
